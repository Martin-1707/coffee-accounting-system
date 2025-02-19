package com.back_cafe.controllers;

import com.back_cafe.dtos.VentaDTO;
import com.back_cafe.servicesintefaces.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService vS;

    @PostMapping("/registrar")
    public void registrarVenta(
            @RequestParam int clienteId,
            @RequestParam int vendedorId,
            @RequestParam boolean factura,
            @RequestParam BigDecimal abono,
            @RequestParam String productos,
            @RequestParam(required = false) Integer tipoPagoId) {

        vS.registrarVenta(clienteId, vendedorId, factura, abono, productos, tipoPagoId);
    }


        @GetMapping
    public List<VentaDTO> listar(){
        return vS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,VentaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VentaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        VentaDTO dto = m.map(vS.listarId(id), VentaDTO.class);
        return dto;
    }

}
