package com.back_cafe.repositories;

import com.back_cafe.entities.VentasProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVentasProductoRepository extends JpaRepository<VentasProducto, Integer> {
    List<VentasProducto> findByVenta_UsuarioCliente_UsernameOrVenta_UsuarioVendedor_Username(String clienteUsername, String vendedorUsername);
}