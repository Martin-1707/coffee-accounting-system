package com.back_cafe.servicesimplements;

import com.back_cafe.entities.Abono;
import com.back_cafe.repositories.IAbonoRepository;
import com.back_cafe.servicesintefaces.IAbonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AbonoServiceImplement implements IAbonoService {
    @Autowired
    private IAbonoRepository aR;

    @Override
    public List<Abono> list() {
        return aR.findAll();
    }

    @Override
    public Abono listarId(int id) {
        return aR.findById(id).orElse(new Abono());
    }

    @Override
    @Transactional
    public void registrarAbono(int ventaId, BigDecimal abono, int tipoPagoId) {
        aR.registrarAbono(ventaId, abono, tipoPagoId);
    }
}
