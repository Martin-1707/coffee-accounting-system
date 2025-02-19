package com.back_cafe.controllers;

import com.back_cafe.dtos.UsuarioDTO;
import com.back_cafe.entities.Usuario;
import com.back_cafe.servicesintefaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario mn=m.map(dto,Usuario.class);
        uS.insert(mn);
    }

    @GetMapping
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario d=m.map(dto,Usuario.class);
        uS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listarId(id), UsuarioDTO.class);
        return dto;
    }
}
