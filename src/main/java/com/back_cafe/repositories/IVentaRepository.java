package com.back_cafe.repositories;

import com.back_cafe.entities.Venta;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface IVentaRepository extends JpaRepository <Venta, Integer>{

    // Método para llamar al procedimiento registrarVenta

    @Modifying
    @Transactional
    @Query(value = "CALL registrarventa(:p_cliente_id, :p_vendedor_id, :p_factura, :p_abono, CAST(:p_productos AS json), :p_tipopago_id)", nativeQuery = true)
    void registrarVenta(
            @Param("p_cliente_id") int p_cliente_id,
            @Param("p_vendedor_id") int p_vendedor_id,
            @Param("p_factura") boolean p_factura,
            @Param("p_abono") BigDecimal p_abono,
            @Param("p_productos") String p_productos,
            @Param("p_tipopago_id") Integer p_tipopago_id
    );

    // Método para llamar al procedimiento registrarVentaSimple
    @Modifying
    @Transactional
    @Query(value = "CALL registrarventasimple(:p_cliente_id, :p_vendedor_id, :p_factura, :p_monto_manual, :p_abono, :p_tipopago_id)", nativeQuery = true)
    void registrarVentaSimple(
            @Param("p_cliente_id") int p_cliente_id,
            @Param("p_vendedor_id") int p_vendedor_id,
            @Param("p_factura") boolean p_factura,
            @Param("p_monto_manual") BigDecimal p_monto_manual,
            @Param("p_abono") BigDecimal p_abono,
            @Param("p_tipopago_id") Integer p_tipopago_id
    );

}

