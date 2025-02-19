package com.back_cafe.repositories;

import com.back_cafe.entities.HistorialEstadoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistorialEstadoVentaRepository extends JpaRepository<HistorialEstadoVenta, Integer> {
}
