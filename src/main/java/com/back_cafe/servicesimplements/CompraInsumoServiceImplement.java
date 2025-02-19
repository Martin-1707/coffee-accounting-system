package com.back_cafe.servicesimplements;

import com.back_cafe.entities.CompraInsumo;
import com.back_cafe.repositories.ICompraInsumoRepository;
import com.back_cafe.servicesintefaces.ICompraInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraInsumoServiceImplement implements ICompraInsumoService {
    @Autowired
    private ICompraInsumoRepository ciR;

    @Override
    public void insert(CompraInsumo compraInsumo) {
        ciR.save(compraInsumo);
    }

    @Override
    public List<CompraInsumo> list() {
        return ciR.findAll();
    }

    @Override
    public void update(CompraInsumo compraInsumo) {
        ciR.save(compraInsumo);
    }

    @Override
    public void delete(int id) {
        ciR.deleteById(id);
    }

    @Override
    public CompraInsumo listarId(int id) {
        return ciR.findById(id).orElse(new CompraInsumo());
    }
}
