package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.Producto;

import java.util.List;

public interface IProductoService {
    //Create
    public void insert(Producto producto);
    //Read
    public List<Producto> list();
    //Update-Actualizar precio
    public void actualizarPrecioProducto(Integer idProducto, Double nuevoPrecio, Integer idUsuario);
    //Delete
    public void delete(int id);
    //ListarId
    public Producto listarId(int id);
}
