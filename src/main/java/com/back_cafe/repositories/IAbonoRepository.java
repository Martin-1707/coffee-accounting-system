package com.back_cafe.repositories;

import com.back_cafe.entities.Abono;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IAbonoRepository extends JpaRepository<Abono, Integer> {
    @Modifying
    @Transactional
    @Query(value = "CALL registrarabono(:p_venta_id, :p_abono, :p_tipopago_id)", nativeQuery = true)
    void registrarAbono(
            @Param("p_venta_id") int p_venta_id,
            @Param("p_abono") BigDecimal p_abono,
            @Param("p_tipopago_id") int p_tipopago_id
    );

    List<Abono> findByVenta_UsuarioCliente_UsernameOrVenta_UsuarioVendedor_Username(String clienteUsername, String vendedorUsername);

    List<Abono> findByVenta_Idventa(int idventa);
}
