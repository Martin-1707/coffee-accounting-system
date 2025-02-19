package com.back_cafe.servicesimplements;

import com.back_cafe.entities.VentasProducto;
import com.back_cafe.repositories.IVentasProductoRepository;
import com.back_cafe.servicesintefaces.IVentasProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasProductoServiceImplement implements IVentasProductoService {
    @Autowired
    private IVentasProductoRepository vpR;


    @Override
    public List<VentasProducto> list() {
        return vpR.findAll();
    }

    @Override
    public VentasProducto listarId(int id) {
        return vpR.findById(id).orElse(new VentasProducto());
    }
}
