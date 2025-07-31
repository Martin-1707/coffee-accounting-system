package com.back_cafe.controllers;

import com.back_cafe.dtos.*;
import com.back_cafe.entities.Usuario;
import com.back_cafe.servicesintefaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @PostMapping
    public ResponseEntity<?> insertar(@RequestBody UsuarioConAccesoDTO dto) {
        try {
            ModelMapper m = new ModelMapper();
            Usuario mn = m.map(dto, Usuario.class);
            uS.insert(mn);
            return ResponseEntity.ok("Usuario registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar usuario: " + e.getMessage());
        }
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.obtenerUsuariosPorRol().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario d=m.map(dto,Usuario.class);
        uS.update(d);
    }

    @PutMapping("/cambiar-password")
    public ResponseEntity<String> cambiarPassword(@RequestBody UsuarioPasswordDTO dto) {
        boolean actualizado = uS.cambiarPassword(dto.getIdusuario(), dto.getOldPassword(), dto.getNewPassword());

        if (actualizado) {
            return ResponseEntity.ok("Contraseña actualizada correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar la contraseña.");
        }
    }

    @GetMapping("/clientes")
    public List<UsuarioDTO> listarClientes() {
        return uS.obtenerUsuariosCliente().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listarId(id), UsuarioDTO.class);
        return dto;
    }

    // Nuevo endpoint para listar subordinados directos
    @GetMapping("/{idUsuario}/listarSubordinados")
    public List<UsuarioDTO> listarSubordinados(@PathVariable("idUsuario") int idUsuario) {
        return uS.listarSubordinados(idUsuario).stream()
                .map(usuario -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(usuario, UsuarioDTO.class);
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/visibles")
    public ResponseEntity<List<Usuario>> getUsuariosVisibles(Authentication auth) {
        Usuario actual = uS.findByUsername(auth.getName());
        List<Usuario> visibles = uS.obtenerUsuariosVisibles(actual);
        return ResponseEntity.ok(visibles);
    }

    @GetMapping("/jerarquia")
    public ResponseEntity<UsuarioJerarquicoDTO> getJerarquia(Authentication auth) {
        Usuario actual = uS.findByUsername(auth.getName());
        UsuarioJerarquicoDTO dto = uS.construirJerarquia(actual);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioActual(Authentication auth) {
        try {
            UsuarioDTO dto = uS.obtenerUsuarioActual(auth);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/superior")
    public ResponseEntity<UsuarioSuperiorDTO> obtenerSuperior(Authentication auth) {
        try {
            Usuario usuario = uS.findByUsername(auth.getName());
            if (usuario.getUsuarioPadre() == null) {
                return ResponseEntity.noContent().build();
            }
            ModelMapper m = new ModelMapper();
            UsuarioSuperiorDTO dto = m.map(usuario.getUsuarioPadre(), UsuarioSuperiorDTO.class);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}