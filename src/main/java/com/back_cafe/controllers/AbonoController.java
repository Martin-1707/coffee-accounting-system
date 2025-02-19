package com.back_cafe.controllers;

import com.back_cafe.dtos.AbonoDTO;
import com.back_cafe.servicesintefaces.IAbonoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/abonos")
public class AbonoController {
    @Autowired
    private IAbonoService aS;

    @GetMapping
    public List<AbonoDTO> listar() {
        return aS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,AbonoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AbonoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        AbonoDTO dto = m.map(aS.listarId(id), AbonoDTO.class);
        return dto;
    }

    @PostMapping("/registrarAbono")
    public void registrarAbono(@RequestParam int ventaId, @RequestParam BigDecimal abono, @RequestParam int tipoPagoId) {
        aS.registrarAbono(ventaId, abono, tipoPagoId);
    }

}
