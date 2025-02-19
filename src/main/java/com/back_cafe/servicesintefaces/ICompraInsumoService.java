package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.CompraInsumo;

import java.util.List;

public interface ICompraInsumoService {
    //Create
    public void insert(CompraInsumo compraInsumo);
    //Read
    public List<CompraInsumo> list();
    //Update
    public void update(CompraInsumo compraInsumo);
    //Delete
    public void delete(int id);
    //ListarId
    public CompraInsumo listarId(int id);
}
