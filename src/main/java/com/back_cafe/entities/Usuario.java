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

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @Column(length = 30, nullable = true, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = true, length = 200)
    private String password;

    @Column(name = "estado", nullable = false)
    private Boolean enabled;

    @Column(name = "fecha_creacion", nullable = true)
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

    // Nuevo campo: referencia al usuario "padre" (quien supervisa)
    @ManyToOne
    @JoinColumn(name = "id_padre")
    private Usuario usuarioPadre;

    // Nuevo campo: lista de usuarios subordinados (hijos)
    @OneToMany(mappedBy = "usuarioPadre")
    @JsonIgnore
    private List<Usuario> subordinados;

    public Usuario() { }

    public Usuario(int idusuario, String nombre, String apellido, String email, String username, String password, Boolean enabled, LocalDate fecha_creacion, Rol rol, Usuario usuarioPadre) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.fecha_creacion = fecha_creacion;
        this.rol = rol;
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

    public Usuario getUsuarioPadre() {return usuarioPadre;}

    public void setUsuarioPadre(Usuario usuarioPadre) {this.usuarioPadre = usuarioPadre;}

    public List<Usuario> getSubordinados() {return subordinados;}

    public void setSubordinados(List<Usuario> subordinados) {this.subordinados = subordinados;}

}
