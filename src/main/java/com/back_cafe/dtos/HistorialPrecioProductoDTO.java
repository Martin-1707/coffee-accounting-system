package com.back_cafe.dtos;

import com.back_cafe.entities.Producto;
import com.back_cafe.entities.Usuario;

import java.time.LocalDate;

public class HistorialPrecioProductoDTO {
    private int idHistorialPrecio;
    private double precio_anterior;
    private double precio_nuevo;
    private LocalDate fecha_cambio;
    private Producto producto;
    private Usuario usuario;

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
