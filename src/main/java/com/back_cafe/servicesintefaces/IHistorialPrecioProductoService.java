package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.HistorialPrecioProducto;

import java.util.List;

public interface IHistorialPrecioProductoService {
    //Create
    public void insert(HistorialPrecioProducto historialPrecioProducto);

    //Read
    public List<HistorialPrecioProducto> list();

    //ListarId
    public HistorialPrecioProducto listarId(int id);
}
