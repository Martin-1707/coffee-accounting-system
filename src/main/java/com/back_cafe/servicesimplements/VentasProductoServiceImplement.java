package com.back_cafe.servicesimplements;

import com.back_cafe.entities.VentasProducto;
import com.back_cafe.repositories.IVentasProductoRepository;
import com.back_cafe.servicesintefaces.IVentasProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasProductoServiceImplement implements IVentasProductoService {
    @Autowired
    private IVentasProductoRepository vpR;

    @Override
    public List<VentasProducto> list() {
        return vpR.findAll();
    }

    @Override
    public VentasProducto listarId(int id) {
        return vpR.findById(id).orElse(new VentasProducto());
    }

    // 🔒 Método para obtener productos de ventas filtrados según usuario autenticado
    @Override
    public List<VentasProducto> obtenerVentasProductoPorUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Obtener usuario autenticado

        // Verificar si el usuario es Administrador o Supervisor
        boolean isAdmin = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("Administrador") || role.equals("Supervisor"));

        if (isAdmin) {
            return vpR.findAll(); // Si es Admin o Supervisor, devuelve todos los productos de ventas
        } else {
            return vpR.findByVenta_UsuarioCliente_UsernameOrVenta_UsuarioVendedor_Username(username, username);
        }
    }
}
