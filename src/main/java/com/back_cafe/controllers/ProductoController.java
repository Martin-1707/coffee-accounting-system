package com.back_cafe.controllers;

import com.back_cafe.dtos.ProductoDTO;
import com.back_cafe.entities.Producto;
import com.back_cafe.servicesintefaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService pS;

    @PostMapping
    public void insertar(@RequestBody ProductoDTO dto){
        ModelMapper m=new ModelMapper();
        Producto mn=m.map(dto,Producto.class);
        pS.insert(mn);
    }

    @GetMapping
    public List<ProductoDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody ProductoDTO dto){
        ModelMapper m=new ModelMapper();
        Producto d=m.map(dto,Producto.class);
        pS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        pS.delete(id);
    }

    @GetMapping("/{id}")
    public ProductoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ProductoDTO dto = m.map(pS.listarId(id), ProductoDTO.class);
        return dto;
    }
}
