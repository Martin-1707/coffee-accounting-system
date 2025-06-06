package com.back_cafe.repositories;

import com.back_cafe.entities.EstadoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoVentaRepository extends JpaRepository<EstadoVenta, Integer> {
}
