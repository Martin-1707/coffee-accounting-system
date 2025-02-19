package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.TipoPago;

import java.util.List;

public interface ITipoPagoService {
    //Create
    public void insert(TipoPago tipoPago);
    //Read
    public List<TipoPago> list();
    //Update
    public void update(TipoPago tipoPago);
    //Delete
    public void delete(int id);
    //ListarId
    public TipoPago listarId(int id);
}
