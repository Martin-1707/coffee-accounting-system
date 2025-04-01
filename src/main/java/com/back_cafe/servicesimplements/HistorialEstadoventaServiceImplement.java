package com.back_cafe.servicesimplements;

import com.back_cafe.entities.HistorialEstadoVenta;
import com.back_cafe.repositories.IHistorialEstadoVentaRepository;
import com.back_cafe.servicesintefaces.IHistorialEstadoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialEstadoventaServiceImplement implements IHistorialEstadoVentaService {
    @Autowired
    private IHistorialEstadoVentaRepository hevR;

    @Override
    public List<HistorialEstadoVenta> list() {
        return hevR.findAll();
    }

    @Override
    public HistorialEstadoVenta listarId(int id) {
        return hevR.findById(id).orElse(new HistorialEstadoVenta());
    }

    @Override
    public List<HistorialEstadoVenta> obtenerHistorialPorUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Obtener usuario autenticado

        // Verificar si el usuario es Administrador o Supervisor
        boolean isAdminOrSupervisor = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("Administrador") || role.equals("Supervisor"));

        if (isAdminOrSupervisor) {
            return hevR.findAll(); // Devuelve todo si es Admin o Supervisor
        } else {
            // Devuelve solo los historiales donde el usuario es cliente o vendedor
            return hevR.findByVenta_UsuarioCliente_UsernameOrVenta_UsuarioVendedor_Username(username, username);
        }
    }
}
