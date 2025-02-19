package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.VentasProducto;

import java.util.List;

public interface IVentasProductoService {
    //Read
    public List<VentasProducto> list();
    //ListarId
    public VentasProducto listarId(int id);
}
