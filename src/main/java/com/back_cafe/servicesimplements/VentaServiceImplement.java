package com.back_cafe.servicesimplements;

import com.back_cafe.entities.Venta;
import com.back_cafe.repositories.IVentaRepository;
import com.back_cafe.servicesintefaces.IVentaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VentaServiceImplement implements IVentaService {
    @Autowired
    private IVentaRepository vR;

    @Override
    public List<Venta> list() {
        return vR.findAll();
    }

    @Override
    public Venta listarId(int id) {
        return vR.findById(id).orElse(new Venta());
    }

    @Override
    @Transactional
    public void registrarVenta(int clienteId, int vendedorId, boolean factura, BigDecimal abono, String productos, Integer tipoPagoId) {
        vR.registrarVenta(clienteId, vendedorId, factura, abono, productos, tipoPagoId);
    }

    @Override
    @Transactional
    public void registrarVentaSimple(int clienteId, int vendedorId, boolean factura, BigDecimal montoManual, BigDecimal abono, Integer tipoPagoId) {
        vR.registrarVentaSimple(clienteId, vendedorId, factura, montoManual, abono, tipoPagoId);
    }

    // 🔒 Nuevo método: Filtrar ventas según el usuario autenticado y su rol
    @Override
    public List<Venta> obtenerVentasPorUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Obtener usuario autenticado

        // Verificar si el usuario es Administrador o Supervisor
        boolean isAdmin = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("Administrador") || role.equals("Supervisor"));

        if (isAdmin) {
            return vR.findAll(); // Si es Admin o Supervisor, devuelve todas las ventas
        } else {
            return vR.findByUsuarioCliente_UsernameOrUsuarioVendedor_Username(username, username);
        }
    }
}
