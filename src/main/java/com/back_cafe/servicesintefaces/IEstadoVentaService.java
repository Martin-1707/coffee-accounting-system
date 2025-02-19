package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.EstadoVenta;

import java.util.List;

public interface IEstadoVentaService {
    //Create
    public void insert(EstadoVenta estadoVenta);
    //Read
    public List<EstadoVenta> list();
    //Update
    public void update(EstadoVenta estadoVenta);

    //ListarId
    public EstadoVenta listarId(int id);
}
