package com.back_cafe.dtos;

import java.util.List;

public class UsuarioJerarquicoDTO {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String rol;
    private List<UsuarioJerarquicoDTO> subordinados;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<UsuarioJerarquicoDTO> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(List<UsuarioJerarquicoDTO> subordinados) {
        this.subordinados = subordinados;
    }
}
