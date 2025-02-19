package com.back_cafe.controllers;

import com.back_cafe.dtos.RolDTO;
import com.back_cafe.entities.Rol;
import com.back_cafe.servicesintefaces.IRolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;


    @PostMapping
    public void insertar(@RequestBody RolDTO dto){
        ModelMapper m=new ModelMapper();
        Rol mn=m.map(dto,Rol.class);
        rS.insert(mn);
    }

    @GetMapping
    public List<RolDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto){
        ModelMapper m=new ModelMapper();
        Rol d=m.map(dto,Rol.class);
        rS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rS.listarId(id), RolDTO.class);
        return dto;
    }
}
