package com.back_cafe.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "compra_insumo")
public class CompraInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcompra;

    @Column(name = "fecha_inicial", nullable = false)
    private LocalDate fecha_inicial;

    @Column(name = "fecha_final", nullable = false)
    private LocalDate fecha_final;

    @Column(name = "monto", nullable = false)
    private double monto;

    public CompraInsumo() { }

    public CompraInsumo(int idcompra, LocalDate fecha_inicial, LocalDate fecha_final, double monto) {
        this.idcompra = idcompra;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
        this.monto = monto;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public LocalDate getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(LocalDate fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(LocalDate fecha_final) {
        this.fecha_final = fecha_final;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
