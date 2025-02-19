package com.back_cafe.servicesimplements;

import com.back_cafe.entities.EstadoVenta;
import com.back_cafe.repositories.IEstadoVentaRepository;
import com.back_cafe.servicesintefaces.IEstadoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoVentaServiceImplement implements IEstadoVentaService {
    @Autowired
    private IEstadoVentaRepository evR;


    @Override
    public void insert(EstadoVenta estadoVenta) {
        evR.save(estadoVenta);
    }

    @Override
    public List<EstadoVenta> list() {
        return evR.findAll();
    }

    @Override
    public void update(EstadoVenta estadoVenta) {
        evR.save(estadoVenta);
    }

    @Override
    public EstadoVenta listarId(int id) {
        return evR.findById(id).orElse(new EstadoVenta());
    }
}
