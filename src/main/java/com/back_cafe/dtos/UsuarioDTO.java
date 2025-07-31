package com.back_cafe.dtos;

import com.back_cafe.entities.Rol;

import java.time.LocalDate;

public class UsuarioDTO {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private Boolean enabled;
    private LocalDate fecha_creacion;
    private Rol rol;
    private UsuarioSuperiorDTO usuarioPadre;

    public UsuarioSuperiorDTO getUsuarioPadre() {
        return usuarioPadre;
    }

    public void setUsuarioPadre(UsuarioSuperiorDTO usuarioPadre) {
        this.usuarioPadre = usuarioPadre;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
