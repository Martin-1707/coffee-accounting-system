package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historialestadoventa")
public class HistorialEstadoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhistorial;

    // Relación con EstadoVenta
    @ManyToOne
    @JoinColumn(name = "estadoventa_idestado", referencedColumnName = "idestado", nullable = false)
    @JsonIgnore
    private EstadoVenta estadoVenta;

    // Relación con Venta
    @ManyToOne
    @JoinColumn(name = "venta_idventa", referencedColumnName = "idventa", nullable = false)
    private Venta venta;

    @Column(name = "fechacambio", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechacambio;

    public HistorialEstadoVenta() { }

    public HistorialEstadoVenta(int idhistorial, EstadoVenta estadoVenta, Venta venta, LocalDateTime fechacambio) {
        this.idhistorial = idhistorial;
        this.estadoVenta = estadoVenta;
        this.venta = venta;
        this.fechacambio = fechacambio;
    }

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
