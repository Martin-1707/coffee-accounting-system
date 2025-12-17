package com.back_cafe.dtos;

import java.time.LocalDate;

public class CompraResumenDTO {
    private Integer idcompra;
    private LocalDate fecha_inicial;
    private LocalDate fecha_final;
    private Double monto;
    private UsuarioSuperiorDTO usuario;
    private LocalDate fecha_registro;

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public LocalDate getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(LocalDate fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(LocalDate fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public UsuarioSuperiorDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSuperiorDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
