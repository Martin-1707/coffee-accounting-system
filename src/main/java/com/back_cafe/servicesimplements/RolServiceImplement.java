package com.back_cafe.servicesimplements;

import com.back_cafe.entities.Rol;
import com.back_cafe.repositories.IRolRepository;
import com.back_cafe.servicesintefaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rR;


    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Rol listarId(int id) {
        return rR.findById(id).orElse(new Rol());
    }
}
