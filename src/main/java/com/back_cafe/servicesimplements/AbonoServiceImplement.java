package com.back_cafe.servicesimplements;

import com.back_cafe.entities.Abono;
import com.back_cafe.repositories.IAbonoRepository;
import com.back_cafe.servicesintefaces.IAbonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AbonoServiceImplement implements IAbonoService {
    @Autowired
    private IAbonoRepository aR;

    @Override
    public List<Abono> list() {
        return aR.findAll();
    }

    @Override
    public Abono listarId(int id) {
        return aR.findById(id).orElse(new Abono());
    }

    @Override
    @Transactional
    public void registrarAbono(int ventaId, BigDecimal abono, int tipoPagoId) {
        aR.registrarAbono(ventaId, abono, tipoPagoId);
    }

    @Override
    public List<Abono> obtenerAbonosPorUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        boolean isAdminOrSupervisor = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("Administrador") || role.equals("Supervisor"));

        return isAdminOrSupervisor ? aR.findAll() : aR.findByVenta_UsuarioCliente_UsernameOrVenta_UsuarioVendedor_Username(username, username);
    }
}
