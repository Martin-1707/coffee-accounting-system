package com.back_cafe.controllers;

import com.back_cafe.dtos.HistorialEstadoVentaDTO;
import com.back_cafe.servicesintefaces.IHistorialEstadoVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historialventa")
public class HistorialVentaController {
    @Autowired
    private IHistorialEstadoVentaService hS;

    @GetMapping
    public List<HistorialEstadoVentaDTO> listar(){
        return hS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,HistorialEstadoVentaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HistorialEstadoVentaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        HistorialEstadoVentaDTO dto = m.map(hS.listarId(id), HistorialEstadoVentaDTO.class);
        return dto;
    }
}
