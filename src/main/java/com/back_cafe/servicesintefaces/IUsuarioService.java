package com.back_cafe.servicesintefaces;

import com.back_cafe.dtos.UsuarioComunDTO;
import com.back_cafe.entities.Usuario;

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

    //listar clientes por vendedor
    List<Usuario> listarClientesPorVendedor(int idVendedor);
    //listar vendedores por asesor
    List<Usuario> listarVendedoresPorAsesor(int idAsesor);
    //listar asesores por administrador
    List<Usuario> listarAsesoresPorAdmin(int idAdmin);
    //listar subordinados directos según ID (útil para mostrar jerarquía)
    List<Usuario> listarSubordinados(int idUsuario);

    // 🔒 Nuevo método: Obtener usuarios filtrados por rol
    List<?> obtenerUsuariosPorRol();
    //Obtener usuarios con rol de cliente
    List<?> obtenerUsuariosCliente();
    public boolean cambiarPassword(int idusuario, String oldPassword, String newPassword);
}
