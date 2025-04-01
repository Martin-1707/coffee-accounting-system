package com.back_cafe.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "abono")
public class Abono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idabono;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "fecha_abono", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fecha_abono;

    @ManyToOne
    @JoinColumn(name = "venta_idventa", referencedColumnName = "idventa", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "tipopago_idtipopago", referencedColumnName = "idtipopago", nullable = false)
    @JsonIgnore
    private TipoPago tipoPago;


    public Abono() { }

    public Abono(int idabono, double monto, LocalDateTime fecha_abono, Venta venta, TipoPago tipoPago) {
        this.idabono = idabono;
        this.monto = monto;
        this.fecha_abono = fecha_abono;
        this.venta = venta;
        this.tipoPago = tipoPago;
    }

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
