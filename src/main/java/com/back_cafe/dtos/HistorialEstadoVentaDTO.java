package com.back_cafe.dtos;

import com.back_cafe.entities.EstadoVenta;
import com.back_cafe.entities.Venta;

import java.time.LocalDateTime;

public class HistorialEstadoVentaDTO {
    private int idhistorial;
    private EstadoVenta estadoVenta;
    private Venta venta;
    private LocalDateTime fechacambio;

    public int getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(int idhistorial) {
        this.idhistorial = idhistorial;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public LocalDateTime getFechacambio() {
        return fechacambio;
    }

    public void setFechacambio(LocalDateTime fechacambio) {
        this.fechacambio = fechacambio;
    }
}
