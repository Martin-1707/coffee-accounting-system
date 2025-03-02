package com.back_cafe.controllers;

import com.back_cafe.dtos.VentaDTO;
import com.back_cafe.dtos.VentasProductoDTO;
import com.back_cafe.servicesintefaces.IVentasProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ventaproducto")
public class VentasProductoController {

    @Autowired
    private IVentasProductoService vS;

    @GetMapping
    public List<VentasProductoDTO> listar(){
        return vS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,VentasProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VentasProductoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        VentasProductoDTO dto = m.map(vS.listarId(id), VentasProductoDTO.class);
        return dto;
    }
}
