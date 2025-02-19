package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.HistorialEstadoVenta;

import java.util.List;

public interface IHistorialEstadoVentaService {

    //Read
    public List<HistorialEstadoVenta> list();

    //ListarId
    public HistorialEstadoVenta listarId(int id);
}
