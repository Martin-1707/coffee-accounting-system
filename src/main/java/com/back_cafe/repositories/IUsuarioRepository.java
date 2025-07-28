package com.back_cafe.repositories;

import com.back_cafe.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
    @Query("SELECT u FROM Usuario u WHERE u.rol.nombre_rol = :nombreRol")
    List<Usuario> findByRolNombre(@Param("nombreRol") String nombreRol);

    List<Usuario> findByRolIdrol(int rolCliente);
}

