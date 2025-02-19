package com.back_cafe.dtos;

import com.back_cafe.entities.Usuario;

import java.time.LocalDate;

public class VentaDTO {
    private int idventa;
    private LocalDate fechaventa;
    private double monto;
    private Usuario usuarioCliente;
    private Usuario usuarioVendedor;
    private Boolean factura;
    private double saldopendiente;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public LocalDate getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(LocalDate fechaventa) {
        this.fechaventa = fechaventa;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Usuario usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public Usuario getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Usuario usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    public Boolean getFactura() {
        return factura;
    }

    public void setFactura(Boolean factura) {
        this.factura = factura;
    }

    public double getSaldopendiente() {
        return saldopendiente;
    }

    public void setSaldopendiente(double saldopendiente) {
        this.saldopendiente = saldopendiente;
    }
}
