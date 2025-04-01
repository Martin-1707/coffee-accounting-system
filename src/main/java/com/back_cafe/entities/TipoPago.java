package com.back_cafe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipopago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipopago;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    @JsonIgnore
    private List<Abono> abonos;

    public TipoPago() { }

    public TipoPago(int idtipopago, String nombre, String descripcion) {
        this.idtipopago = idtipopago;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

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
