package com.back_cafe.controllers;

import com.back_cafe.dtos.HistorialEstadoVentaDTO;
import com.back_cafe.dtos.HistorialPrecioProductoDTO;
import com.back_cafe.entities.HistorialPrecioProducto;
import com.back_cafe.servicesintefaces.IHistorialEstadoVentaService;
import com.back_cafe.servicesintefaces.IHistorialPrecioProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historialprecioproducto")
public class HistorialPrecioProductoController {
    @Autowired
    private IHistorialPrecioProductoService hS;

    @GetMapping
    public List<HistorialPrecioProductoDTO> listar() {
        return hS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HistorialPrecioProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HistorialPrecioProductoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        HistorialPrecioProductoDTO dto = m.map(hS.listarId(id), HistorialPrecioProductoDTO.class);
        return dto;
    }
}
