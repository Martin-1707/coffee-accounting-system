package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historialprecioproducto")
public class HistorialPrecioProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorialPrecio;

    @Column(name = "precio_anterior", nullable = false)
    private double precio_anterior;

    @Column(name = "precio_nuevo", nullable = false)
    private double precio_nuevo;

    @Column(name = "fecha_cambio", nullable = false)
    private LocalDate fecha_cambio;

    // Relación con Producto
    @ManyToOne
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto", nullable = false)
    private Producto producto;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario", nullable = false)
    private Usuario usuario;

    public HistorialPrecioProducto() { }

    public HistorialPrecioProducto(int idHistorialPrecio, double precio_anterior, double precio_nuevo, LocalDate fecha_cambio, Producto producto, Usuario usuario) {
        this.idHistorialPrecio = idHistorialPrecio;
        this.precio_anterior = precio_anterior;
        this.precio_nuevo = precio_nuevo;
        this.fecha_cambio = fecha_cambio;
        this.producto = producto;
        this.usuario = usuario;
    }

    public int getIdHistorialPrecio() {
        return idHistorialPrecio;
    }

    public void setIdHistorialPrecio(int idHistorialPrecio) {
        this.idHistorialPrecio = idHistorialPrecio;
    }

    public double getPrecio_anterior() {
        return precio_anterior;
    }

    public void setPrecio_anterior(double precio_anterior) {
        this.precio_anterior = precio_anterior;
    }

    public double getPrecio_nuevo() {
        return precio_nuevo;
    }

    public void setPrecio_nuevo(double precio_nuevo) {
        this.precio_nuevo = precio_nuevo;
    }

    public LocalDate getFecha_cambio() {
        return fecha_cambio;
    }

    public void setFecha_cambio(LocalDate fecha_cambio) {
        this.fecha_cambio = fecha_cambio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
