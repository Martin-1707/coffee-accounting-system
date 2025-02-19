package com.back_cafe.servicesimplements;

import com.back_cafe.entities.TipoPago;
import com.back_cafe.repositories.ITipoPagoRepository;
import com.back_cafe.servicesintefaces.ITipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoServiceImplement implements ITipoPagoService {
    @Autowired
    private ITipoPagoRepository tpR;


    @Override
    public void insert(TipoPago tipoPago) {
        tpR.save(tipoPago);
    }

    @Override
    public List<TipoPago> list() {
        return tpR.findAll();
    }

    @Override
    public void update(TipoPago tipoPago) {
        tpR.save(tipoPago);
    }

    @Override
    public void delete(int id) {
        tpR.deleteById(id);
    }

    @Override
    public TipoPago listarId(int id) {
        return tpR.findById(id).orElse(new TipoPago());
    }
}
