package com.back_cafe.repositories;

import com.back_cafe.entities.CompraInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraInsumoRepository extends JpaRepository<CompraInsumo, Integer> {
}
