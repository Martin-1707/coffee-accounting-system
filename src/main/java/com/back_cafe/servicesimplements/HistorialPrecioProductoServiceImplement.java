package com.back_cafe.servicesimplements;

import com.back_cafe.entities.HistorialEstadoVenta;
import com.back_cafe.entities.HistorialPrecioProducto;
import com.back_cafe.repositories.IHistorialPrecioProductoRepository;
import com.back_cafe.servicesintefaces.IHistorialPrecioProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialPrecioProductoServiceImplement implements IHistorialPrecioProductoService {
    @Autowired
    private IHistorialPrecioProductoRepository hprR;

    @Override
    public void insert(HistorialPrecioProducto historialPrecioProducto) {
        hprR.save(historialPrecioProducto);
    }

    @Override
    public List<HistorialPrecioProducto> list() {
        return hprR.findAll();
    }

    @Override
    public HistorialPrecioProducto listarId(int id) {
            return hprR.findById(id).orElse(new HistorialPrecioProducto());
    }
}
