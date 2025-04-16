package com.back_cafe.repositories;

import com.back_cafe.entities.HistorialPrecioProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistorialPrecioProductoRepository extends JpaRepository<HistorialPrecioProducto, Integer> {

}
