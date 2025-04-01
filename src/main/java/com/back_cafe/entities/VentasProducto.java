package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ventas_productos")
public class VentasProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idventaproducto;

    @ManyToOne
    @JoinColumn(name = "venta_idventa", referencedColumnName = "idventa", nullable = false)
    @JsonIgnore
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_idProducto", referencedColumnName = "idproducto", nullable = false)
    @JsonIgnore
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private double cantidad;

    @Column(name = "precio", nullable = false)
    private double precio;

    public VentasProducto() { }

    public VentasProducto(int idventaproducto, Venta venta, Producto producto, double cantidad, double precio) {
        this.idventaproducto = idventaproducto;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdventaproducto() {
        return idventaproducto;
    }

    public void setIdventaproducto(int idventaproducto) {
        this.idventaproducto = idventaproducto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
