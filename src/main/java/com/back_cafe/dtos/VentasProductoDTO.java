package com.back_cafe.dtos;

import com.back_cafe.entities.Producto;
import com.back_cafe.entities.Venta;

public class VentasProductoDTO {
    private int idventaproducto;
    private Venta venta;
    private Producto producto;
    private double cantidad;
    private double precio;

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
