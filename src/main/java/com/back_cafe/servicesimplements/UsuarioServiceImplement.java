package com.back_cafe.servicesimplements;

import com.back_cafe.dtos.UsuarioDTO;
import com.back_cafe.dtos.UsuarioJerarquicoDTO;
import com.back_cafe.entities.Usuario;
import com.back_cafe.repositories.IUsuarioRepository;
import com.back_cafe.servicesintefaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Constantes para los nombres de roles
    private static final int ROL_CLIENTE = 4;
    private static final int ROL_VENDEDOR = 1;
    private static final int ROL_SUPERVISOR = 6;
    private static final int ROL_ADMIN = 5;
    // Fin de constantes

    public void insert(Usuario usuario) {
        // Validación de roles y credenciales
        if (usuario.getRol().getIdrol()==ROL_CLIENTE) { // Si es cliente
            usuario.setUsername(null);
            usuario.setPassword(null);
        } else { // Para otros roles, validar que tengan credenciales
            if (usuario.getUsername() == null || usuario.getPassword() == null) {
                throw new IllegalArgumentException("Los usuarios con rol diferente a Cliente deben tener username y password");
            }
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        uR.save(usuario);
    }


    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Usuario listarId(int id) {
        return uR.findById(id).orElse(new Usuario());
    }

    @Override
    public List<Usuario> listarClientesPorVendedor(int idVendedor) {
        Usuario vendedor = uR.findById(idVendedor).orElse(null);
        if (vendedor != null && vendedor.getRol().getNombre_rol().equals(ROL_VENDEDOR)) {
            return vendedor.getSubordinados().stream()
                    .filter(u -> u.getRol().getNombre_rol().equals(ROL_CLIENTE))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<Usuario> listarVendedoresPorAsesor(int idAsesor) {
        Usuario asesor = uR.findById(idAsesor).orElse(null);
        if (asesor != null && asesor.getRol().getNombre_rol().equals(ROL_SUPERVISOR)) {
            return asesor.getSubordinados().stream()
                    .filter(u -> u.getRol().getNombre_rol().equals(ROL_VENDEDOR))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<Usuario> listarAsesoresPorAdmin(int idAdmin) {
        Usuario admin = uR.findById(idAdmin).orElse(null);
        if (admin != null && admin.getRol().getNombre_rol().equals(ROL_ADMIN)) {
            return admin.getSubordinados().stream()
                    .filter(u -> u.getRol().getNombre_rol().equals(ROL_SUPERVISOR))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<Usuario> listarSubordinados(int idUsuario) {
        Usuario usuario = uR.findById(idUsuario).orElse(null);
        if (usuario != null) {
            return usuario.getSubordinados();
        }
        return Collections.emptyList();
    }

    @Override
    public Usuario findByUsername(String username) {
        return uR.findByUsername(username);
    }

    private void agregarSubordinados(Usuario usuario, Set<Usuario> visibles) {
        for (Usuario sub : usuario.getSubordinados()) {
            if (visibles.add(sub)) { // Evita duplicados y bucles
                agregarSubordinados(sub, visibles); // Recurse hacia abajo
            }
        }
    }

    @Override
    public List<Usuario> obtenerUsuariosVisibles(Usuario usuario) {
        // Usamos un Set para evitar duplicados y prevenir ciclos
        Set<Usuario> visiblesSet = new LinkedHashSet<>();
        // 1) Se ve a sí mismo
        visiblesSet.add(usuario);

        // 2) Si tiene un padre, lo agrega
        if (usuario.getUsuarioPadre() != null) {
            visiblesSet.add(usuario.getUsuarioPadre());
        }

        // 3) Agrega recursivamente a todos sus subordinados
        agregarSubordinadosRecursivo(usuario, visiblesSet);

        // Convertimos a lista y devolvemos
        return new ArrayList<>(visiblesSet);
    }

    @Override
    public UsuarioJerarquicoDTO construirJerarquia(Usuario usuario) {
        UsuarioJerarquicoDTO dto = new UsuarioJerarquicoDTO();
        dto.setIdusuario(usuario.getIdusuario());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setRol(usuario.getRol().getNombre_rol());

        if (usuario.getSubordinados() != null && !usuario.getSubordinados().isEmpty()) {
            List<UsuarioJerarquicoDTO> hijos = usuario.getSubordinados().stream()
                    .map(this::construirJerarquia)
                    .collect(Collectors.toList());
            dto.setSubordinados(hijos);
        } else {
            dto.setSubordinados(new ArrayList<>());
        }

        return dto;
    }

    @Override
    public UsuarioDTO obtenerUsuarioActual(Authentication auth) {
        Usuario usuario = findByUsername(auth.getName());
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        ModelMapper mapper = new ModelMapper();
        return mapper.map(usuario, UsuarioDTO.class);
    }

    private void agregarSubordinadosRecursivo(Usuario padre, Set<Usuario> contenedor) {
        if (padre.getSubordinados() == null) {
            return;
        }
        for (Usuario sub : padre.getSubordinados()) {
            // Si aún no estaba en contenedor, lo agregamos y descendemos
            if (contenedor.add(sub)) {
                agregarSubordinadosRecursivo(sub, contenedor);
            }
        }
    }

    @Override
    public List<Usuario> obtenerUsuariosPorRol() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Verificar si el usuario es Administrador o Supervisor usando nombres de roles
        boolean isAdminOrSupervisor = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals(ROL_ADMIN) || role.equals(ROL_SUPERVISOR));

        if (isAdminOrSupervisor) {
            return uR.findAll();
        } else {
            Usuario usuario = uR.findByUsername(username);
            return usuario != null ? List.of(usuario) : Collections.emptyList();
        }
    }

    @Override
    public List<Usuario> obtenerUsuariosCliente() {
        return uR.findByRolIdrol(ROL_CLIENTE);
    }

    public boolean cambiarPassword(int idusuario, String oldPassword, String newPassword) {
        Optional<Usuario> usuarioOptional = uR.findById(idusuario);

        if (usuarioOptional.isEmpty()) {
            return false; // El usuario no existe
        }

        Usuario usuario = usuarioOptional.get();

        if (!passwordEncoder.matches(oldPassword, usuario.getPassword())) {
            return false; // Contraseña incorrecta
        }

        usuario.setPassword(passwordEncoder.encode(newPassword));
        uR.save(usuario);
        return true;
    }
}
