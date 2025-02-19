package com.back_cafe.servicesintefaces;

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

}
