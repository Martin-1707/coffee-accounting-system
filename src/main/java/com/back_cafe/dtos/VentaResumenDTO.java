package com.back_cafe.dtos;

import java.time.LocalDate;

public class VentaResumenDTO {
    private int idventa;
    private LocalDate fechaventa;
    private double monto;
    private UsuarioSuperiorDTO usuarioCliente;
    private UsuarioSuperiorDTO usuarioVendedor;
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

    public UsuarioSuperiorDTO getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioSuperiorDTO usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public UsuarioSuperiorDTO getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(UsuarioSuperiorDTO usuarioVendedor) {
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
