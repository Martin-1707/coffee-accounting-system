package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idproducto;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio_lista", nullable = false)
    private double precio_lista;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<VentasProducto> ventaProductos;

    public Producto() { }

    public Producto(int idproducto, String nombre, double precio_lista) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio_lista = precio_lista;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_lista() {
        return precio_lista;
    }

    public void setPrecio_lista(double precio_lista) {
        this.precio_lista = precio_lista;
    }
}
