package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.Rol;

import java.util.List;

public interface IRolService {
    //Create
    public void insert(Rol rol);
    //Read
    public List<Rol> list();
    //Update
    public void update(Rol rol);
    //Delete
    public void delete(int id);
    //ListarId
    public Rol listarId(int id);
}
