package com.back_cafe.controllers;

import com.back_cafe.dtos.EstadoVentaDTO;
import com.back_cafe.entities.EstadoVenta;
import com.back_cafe.servicesintefaces.IEstadoVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estadoventa")
public class EstadoVentaController {
    @Autowired
    private IEstadoVentaService evS;


    @PostMapping
    public void insertar(@RequestBody EstadoVentaDTO dto){
        ModelMapper m=new ModelMapper();
        EstadoVenta mn=m.map(dto,EstadoVenta.class);
        evS.insert(mn);
    }

    @GetMapping
    public List<EstadoVentaDTO> listar(){
        return evS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,EstadoVentaDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody EstadoVentaDTO dto){
        ModelMapper m=new ModelMapper();
        EstadoVenta d=m.map(dto,EstadoVenta.class);
        evS.update(d);
    }

    @GetMapping("/{id}")
    public EstadoVentaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EstadoVentaDTO dto = m.map(evS.listarId(id), EstadoVentaDTO.class);
        return dto;
    }
}
