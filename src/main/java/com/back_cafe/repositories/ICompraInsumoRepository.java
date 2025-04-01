package com.back_cafe.repositories;

import com.back_cafe.entities.CompraInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompraInsumoRepository extends JpaRepository<CompraInsumo, Integer> {
    List<CompraInsumo> findByUsuario_Username(String username);
}
