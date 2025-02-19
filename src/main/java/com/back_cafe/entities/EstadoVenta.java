package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estadoventa")
public class EstadoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idestado;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombreestado;

    @OneToMany(mappedBy = "estadoVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    //@JsonBackReference
    private List<HistorialEstadoVenta> historialEstados;

    public EstadoVenta() { }

    public EstadoVenta(int idestado, String nombreestado) {
        this.idestado = idestado;
        this.nombreestado = nombreestado;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getNombreestado() {
        return nombreestado;
    }

    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
    }

    public List<HistorialEstadoVenta> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(List<HistorialEstadoVenta> historialEstados) {
        this.historialEstados = historialEstados;
    }
}
