package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venta")

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idventa;

    @Column(name = "fechaventa", nullable = false)
    private LocalDate fechaventa;

    @Column(name = "monto", nullable = false)
    private double monto;

    @ManyToOne
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", nullable = false)
    private Usuario usuarioCliente;

    @ManyToOne
    @JoinColumn(name = "usuario_idusuario2", referencedColumnName = "idusuario", nullable = false)
    private Usuario usuarioVendedor;

    @Column(name = "factura", nullable = false)
    private Boolean factura;

    @Column(name = "saldopendiente", nullable = false)
    private double saldopendiente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<VentasProducto> ventaProductos;


    public Venta() { }

    public Venta(int idventa, LocalDate fechaventa, double monto, Usuario usuarioCliente, Usuario usuarioVendedor, Boolean factura, double saldopendiente) {
        this.idventa = idventa;
        this.fechaventa = fechaventa;
        this.monto = monto;
        this.usuarioCliente = usuarioCliente;
        this.usuarioVendedor = usuarioVendedor;
        this.factura = factura;
        this.saldopendiente = saldopendiente;
    }

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
