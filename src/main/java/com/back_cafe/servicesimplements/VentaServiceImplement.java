package com.back_cafe.servicesimplements;

import com.back_cafe.entities.Venta;
import com.back_cafe.repositories.IVentaRepository;
import com.back_cafe.servicesintefaces.IVentaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VentaServiceImplement implements IVentaService {
    @Autowired
    private IVentaRepository vR;

    @Override
    public List<Venta> list() {
        return vR.findAll();
    }

    @Override
    public Venta listarId(int id) {
        return vR.findById(id).orElse(new Venta());
    }

    @Override
    @Transactional
    public void registrarVenta(int clienteId, int vendedorId, boolean factura, BigDecimal abono, String productos, Integer tipoPagoId) {
        vR.registrarVenta(clienteId, vendedorId, factura, abono, productos, tipoPagoId);
    }


}
