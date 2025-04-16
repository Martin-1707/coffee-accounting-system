package com.back_cafe.servicesimplements;

import com.back_cafe.entities.Producto;
import com.back_cafe.repositories.IProductoRepository;
import com.back_cafe.servicesintefaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {
    @Autowired
    private IProductoRepository pR;

    @Override
    public void insert(Producto producto) {
        pR.save(producto);
    }

    @Override
    public List<Producto> list() {
        return pR.findAll();
    }

    @Override
    public void update(Producto producto) {
        pR.save(producto);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public Producto listarId(int id) {
        return pR.findById(id).orElse(new Producto());
    }

    @Override
    public void actualizarPrecioProducto(Integer idProducto, Double nuevoPrecio, Integer idUsuario) {
        pR.actualizarPrecioProducto(idProducto, nuevoPrecio, idUsuario);
    }
}
