package com.back_cafe.controllers;

import com.back_cafe.dtos.CompraInsumoDTO;
import com.back_cafe.entities.CompraInsumo;
import com.back_cafe.servicesintefaces.ICompraInsumoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comprasinsumos")
public class CompraInsumoController {
    @Autowired
    private ICompraInsumoService ciS;

    @PostMapping
    public void insertar(@RequestBody CompraInsumoDTO dto){
        ModelMapper m=new ModelMapper();
        CompraInsumo mn=m.map(dto,CompraInsumo.class);
        ciS.insert(mn);
    }

    @GetMapping
    public List<CompraInsumoDTO> listar(){
        return ciS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CompraInsumoDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody CompraInsumoDTO dto){
        ModelMapper m=new ModelMapper();
        CompraInsumo d=m.map(dto,CompraInsumo.class);
        ciS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        ciS.delete(id);
    }

    @GetMapping("/{id}")
    public CompraInsumoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CompraInsumoDTO dto = m.map(ciS.listarId(id), CompraInsumoDTO.class);
        return dto;
    }
}

