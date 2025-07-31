package com.back_cafe.servicesintefaces;

import com.back_cafe.dtos.UsuarioDTO;
import com.back_cafe.dtos.UsuarioJerarquicoDTO;
import com.back_cafe.entities.Usuario;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IUsuarioService {
    //Create
    public void insert(Usuario usuario);
    //Read
    public List<Usuario> list();
    //Update
    public void update(Usuario usuario);
    //Delete
    public void delete(int id);
    //ListarId
    public Usuario listarId(int id);

    // Seguridad y autenticación
    public Usuario findByUsername(String username);
    public UsuarioDTO obtenerUsuarioActual(Authentication auth);
    public boolean cambiarPassword(int idusuario, String oldPassword, String newPassword);

    // Jerarquía y visibilidad
    public List<Usuario> listarSubordinados(int idUsuario);
    public List<Usuario> obtenerUsuariosVisibles(Usuario usuario);
    public UsuarioJerarquicoDTO construirJerarquia(Usuario usuario);

    // Filtrado por rol
    public List<Usuario> obtenerUsuariosPorRol();
    public List<Usuario> obtenerUsuariosCliente();
}
