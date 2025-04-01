package com.back_cafe.servicesimplements;

import com.back_cafe.entities.Usuario;
import com.back_cafe.repositories.IUsuarioRepository;
import com.back_cafe.servicesintefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void insert(Usuario usuario) {
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
    public List<Usuario> obtenerUsuariosPorRol() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Obtener usuario autenticado

        // Verificar si el usuario es Administrador o Supervisor
        boolean isAdminOrSupervisor = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("Administrador") || role.equals("Supervisor"));

        if (isAdminOrSupervisor) {
            return uR.findAll(); // Si es Admin o Supervisor, devuelve todos los usuarios
        } else {
            Usuario usuario = uR.findByUsername(username);
            return usuario != null ? List.of(usuario) : Collections.emptyList(); // Devuelve solo su propio usuario
        }
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
