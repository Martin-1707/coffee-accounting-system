package com.back_cafe.repositories;

import com.back_cafe.entities.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPagoRepository extends JpaRepository<TipoPago, Integer> {
}
