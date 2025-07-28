package com.back_cafe.dtos;

import com.back_cafe.entities.Rol;
import com.back_cafe.entities.Usuario;

import java.time.LocalDate;

public class UsuarioComunDTO {
    private int idusuario;
    private String nombre;
    private String apellido;
    private Boolean enabled;
    private LocalDate fecha_creacion;
    private Rol rol;
    private Usuario usuarioPadre;

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuarioPadre() {
        return usuarioPadre;
    }

    public void setUsuarioPadre(Usuario usuarioPadre) {
        this.usuarioPadre = usuarioPadre;
    }
}
