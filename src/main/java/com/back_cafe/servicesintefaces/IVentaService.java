package com.back_cafe.servicesintefaces;

import com.back_cafe.entities.Venta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    //Read
    public List<Venta> list();
    //ListarId
    public Venta listarId(int id);
    // Create (registrar venta)
    void registrarVenta(int clienteId, int vendedorId, boolean factura, BigDecimal abono, String productos, Integer tipoPagoId, LocalDate fechaVenta);
    // Create (registrar venta simple)
    void registrarVentaSimple(int clienteId, int vendedorId, boolean factura, BigDecimal montoManual, BigDecimal abono, Integer tipoPagoId, LocalDate fechaVenta);
    // 🔒 Nuevo método: Obtener ventas filtradas por usuario autenticado
    List<Venta> obtenerVentasPorUsuario();
}