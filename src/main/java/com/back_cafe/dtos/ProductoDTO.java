package com.back_cafe.dtos;

public class ProductoDTO {
    private  int idproducto;
    private String nombre;
    private double precio_lista;

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
