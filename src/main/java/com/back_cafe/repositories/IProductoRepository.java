package com.back_cafe.repositories;

import com.back_cafe.entities.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    @Modifying
    @Transactional
    @Query(value = "CALL actualizar_precio_producto(CAST(:idProducto AS INTEGER), CAST(:nuevoPrecio AS NUMERIC), CAST(:idUsuario AS INTEGER))", nativeQuery = true)
    void actualizarPrecioProducto(
            @Param("idProducto") Integer idProducto,
            @Param("nuevoPrecio") Double nuevoPrecio,
            @Param("idUsuario") Integer idUsuario
    );
}
