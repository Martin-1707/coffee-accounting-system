package com.back_cafe.repositories;

import com.back_cafe.entities.HistorialEstadoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorialEstadoVentaRepository extends JpaRepository<HistorialEstadoVenta, Integer> {
    // 🔎 Nuevo método: Filtrar historial donde el usuario sea cliente o vendedor
    List<HistorialEstadoVenta> findByVenta_UsuarioCliente_UsernameOrVenta_UsuarioVendedor_Username(String clienteUsername, String vendedorUsername);
}
