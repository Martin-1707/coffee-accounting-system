package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.Producto;

import java.util.List;

public interface IProductoService {
    //Create
    public void insert(Producto producto);
    //Read
    public List<Producto> list();
    //Update
    public void update(Producto producto);
    //Delete
    public void delete(int id);
    //ListarId
    public Producto listarId(int id);
    //Actualizar precio
    void actualizarPrecioProducto(Integer idProducto, Double nuevoPrecio, Integer idUsuario);
}
