package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idusuario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", length = 100)
    private String email;

    @Column(length = 30, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "estado", nullable = false)
    private Boolean enabled;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "rol_idrol",referencedColumnName ="idrol", nullable = false)
    private Rol rol;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioCliente")
    private List<Venta> ventasComoCliente;

    @OneToMany(mappedBy = "usuarioVendedor")
    @JsonIgnore
    private List<Venta> ventasComoVendedor;

    public Usuario() { }

    public Usuario(int idusuario, String nombre, String apellido, String email, String username, String password, Boolean enabled, LocalDate fecha_creacion, Rol rol) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.fecha_creacion = fecha_creacion;
        this.rol = rol;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
