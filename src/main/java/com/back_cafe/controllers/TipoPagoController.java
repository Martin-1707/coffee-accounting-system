package com.back_cafe.controllers;

import com.back_cafe.dtos.TipoPagoDTO;
import com.back_cafe.entities.TipoPago;
import com.back_cafe.servicesintefaces.ITipoPagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipopago")
public class TipoPagoController {

    @Autowired
    private ITipoPagoService dS;

    @PostMapping
    public void insertar(@RequestBody TipoPagoDTO dto){
        ModelMapper m=new ModelMapper();
        TipoPago mn=m.map(dto,TipoPago.class);
        dS.insert(mn);
    }

    @GetMapping
    public List<TipoPagoDTO> listar(){
        return dS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TipoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody TipoPagoDTO dto){
        ModelMapper m=new ModelMapper();
        TipoPago d=m.map(dto,TipoPago.class);
        dS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }

    @GetMapping("/{id}")
    public TipoPagoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        TipoPagoDTO dto = m.map(dS.listarId(id), TipoPagoDTO.class);
        return dto;
    }
}
