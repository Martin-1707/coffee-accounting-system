package com.back_cafe.controllers;

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
    private IVentasProductoService vpS;

    // 🔒 Obtener solo los productos de venta del usuario autenticado
    @GetMapping
    public List<VentasProductoDTO> listar() {
        return vpS.obtenerVentasProductoPorUsuario().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VentasProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VentasProductoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        VentasProductoDTO dto = m.map(vpS.listarId(id), VentasProductoDTO.class);
        return dto;
    }
}
