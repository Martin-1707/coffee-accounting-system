package com.back_cafe.dtos;

import com.back_cafe.entities.TipoPago;
import com.back_cafe.entities.Venta;

import java.time.LocalDateTime;

public class AbonoDTO {
    private int idabono;
    private double monto;
    private LocalDateTime fecha_abono;
    private Venta venta;
    private TipoPago tipoPago;

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha_abono() {
        return fecha_abono;
    }

    public void setFecha_abono(LocalDateTime fecha_abono) {
        this.fecha_abono = fecha_abono;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
}
