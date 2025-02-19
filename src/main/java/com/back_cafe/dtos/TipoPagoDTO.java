package com.back_cafe.dtos;

public class TipoPagoDTO {
    private int idtipopago;
    private String nombre;
    private String descripcion;

    public int getIdtipopago() {
        return idtipopago;
    }

    public void setIdtipopago(int idtipopago) {
        this.idtipopago = idtipopago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
