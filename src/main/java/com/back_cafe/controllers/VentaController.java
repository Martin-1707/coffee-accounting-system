package com.back_cafe.controllers;

import com.back_cafe.dtos.VentaDTO;
import com.back_cafe.dtos.VentaResumenDTO;
import com.back_cafe.entities.Usuario;
import com.back_cafe.servicesintefaces.IUsuarioService;
import com.back_cafe.servicesintefaces.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService vS;
    @Autowired
    private IUsuarioService uS;

    // Registrar una venta con productos (Metodo original)
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarVenta(@RequestBody Map<String, Object> request, Authentication auth) {
        try {
            int clienteId = (int) request.get("clienteId");
            int vendedorId = (int) request.get("vendedorId");
            boolean factura = (boolean) request.get("factura");
            BigDecimal abono = new BigDecimal(request.get("abono").toString());
            String productosJson = request.get("productos").toString();
            Integer tipoPagoId = (Integer) request.get("tipoPagoId");

            Usuario actual = uS.findByUsername(auth.getName());
            if (actual.getRol().getNombre_rol().equalsIgnoreCase("Vendedor")) {
                vendedorId = actual.getIdusuario();
            }

            LocalDate fechaVenta = null;
            if (request.containsKey("fechaVenta") && request.get("fechaVenta") != null) {
                String fechaStr = request.get("fechaVenta").toString();
                fechaVenta = LocalDate.parse(fechaStr); // Asegúrate de que venga en formato yyyy-MM-dd
            }

            // ✅ Nuevo parámetro incluido
            vS.registrarVenta(clienteId, vendedorId, factura, abono, productosJson, tipoPagoId, fechaVenta);

            return ResponseEntity.ok("Venta registrada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta: " + e.getMessage());
        }
    }


    // Nuevo método: Registrar una venta simple (Sin productos)
    @PostMapping("/registrar-simple")
    public ResponseEntity<String> registrarVentaSimple(@RequestBody Map<String, Object> request, Authentication auth) {
        try {
            int clienteId = (int) request.get("clienteId");
            int vendedorId = (int) request.get("vendedorId");
            boolean factura = (boolean) request.get("factura");
            BigDecimal montoManual = new BigDecimal(request.get("montoManual").toString());
            BigDecimal abono = new BigDecimal(request.get("abono").toString());
            Integer tipoPagoId = request.get("tipoPagoId") != null ? (Integer) request.get("tipoPagoId") : null;

            Usuario actual = uS.findByUsername(auth.getName());
            if (actual.getRol().getNombre_rol().equalsIgnoreCase("Vendedor")) {
                vendedorId = actual.getIdusuario();
            }

            LocalDate fechaVenta = null;
            if (request.containsKey("fechaVenta") && request.get("fechaVenta") != null) {
                String fechaStr = request.get("fechaVenta").toString(); // formato esperado: "2025-05-19 10:30:00"
                fechaVenta = LocalDate.parse(fechaStr);
            }

            // ✅ Llamada a la lógica del servicio según presencia de fecha
            vS.registrarVentaSimple(clienteId, vendedorId, factura, montoManual, abono, tipoPagoId, fechaVenta);

            return ResponseEntity.ok("Venta simple registrada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta simple: " + e.getMessage());
        }
    }

    // Obtener solo las ventas del usuario autenticado
    @GetMapping
    public List<VentaResumenDTO> listar() {
        return vS.obtenerVentasPorUsuario().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VentaResumenDTO.class);
        }).collect(Collectors.toList());
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public VentaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(vS.listarId(id), VentaDTO.class);
    }
}