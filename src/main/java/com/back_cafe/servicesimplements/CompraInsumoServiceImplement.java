package com.back_cafe.servicesimplements;

import com.back_cafe.entities.CompraInsumo;
import com.back_cafe.repositories.ICompraInsumoRepository;
import com.back_cafe.servicesintefaces.ICompraInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraInsumoServiceImplement implements ICompraInsumoService {
    @Autowired
    private ICompraInsumoRepository ciR;

    @Override
    public void insert(CompraInsumo compraInsumo) {
        ciR.save(compraInsumo);
    }

    @Override
    public List<CompraInsumo> list() {
        return ciR.findAll();
    }

    @Override
    public void update(CompraInsumo compraInsumo) {
        ciR.save(compraInsumo);
    }

    @Override
    public void delete(int id) {
        ciR.deleteById(id);
    }

    @Override
    public CompraInsumo listarId(int id) {
        return ciR.findById(id).orElse(new CompraInsumo());
    }

    @Override
    public List<CompraInsumo> obtenerComprasPorUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        boolean isAdminOrSupervisor = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("Administrador") || role.equals("Supervisor"));

        if (isAdminOrSupervisor) {
            return ciR.findAll(); // Devuelve todas las compras de insumo
        } else {
            return ciR.findByUsuario_Username(username); // Devuelve solo las compras del vendedor logueado
        }
    }
}
