package com.back_cafe.servicesimplements;

import com.back_cafe.entities.HistorialEstadoVenta;
import com.back_cafe.repositories.IHistorialEstadoVentaRepository;
import com.back_cafe.servicesintefaces.IHistorialEstadoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialEstadoventaServiceImplement implements IHistorialEstadoVentaService {
    @Autowired
    private IHistorialEstadoVentaRepository hevR;

    @Override
    public List<HistorialEstadoVenta> list() {
        return hevR.findAll();
    }

    @Override
    public HistorialEstadoVenta listarId(int id) {
        return hevR.findById(id).orElse(new HistorialEstadoVenta());
    }
}
