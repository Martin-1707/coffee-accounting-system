package com.back_cafe.repositories;

import com.back_cafe.entities.VentasProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasProductoRepository extends JpaRepository<VentasProducto, Integer> {
}
