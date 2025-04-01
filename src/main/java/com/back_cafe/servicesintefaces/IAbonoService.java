package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.Abono;

import java.math.BigDecimal;
import java.util.List;

public interface IAbonoService {
    //Read
    public List<Abono> list();

    //ListarId
    public Abono listarId(int id);

    public void registrarAbono(int ventaId, BigDecimal abono, int tipoPagoId);

    List<Abono> obtenerAbonosPorUsuario();
}
