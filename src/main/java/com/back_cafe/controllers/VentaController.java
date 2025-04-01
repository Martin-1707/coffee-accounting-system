package com.back_cafe.controllers;

import com.back_cafe.dtos.VentaDTO;
import com.back_cafe.servicesintefaces.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService vS;

    // Registrar una venta con productos (Método original)
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarVenta(@RequestBody Map<String, Object> request) {
        try {
            int clienteId = (int) request.get("clienteId");
            int vendedorId = (int) request.get("vendedorId");
            boolean factura = (boolean) request.get("factura");
            BigDecimal abono = new BigDecimal(request.get("abono").toString());
            String productosJson = request.get("productos").toString();  // Convertimos a JSON en String
            Integer tipoPagoId = (Integer) request.get("tipoPagoId");

            vS.registrarVenta(clienteId, vendedorId, factura, abono, productosJson, tipoPagoId);

            return ResponseEntity.ok("Venta registrada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta: " + e.getMessage());
        }
    }

    // Nuevo método: Registrar una venta simple (Sin productos)
    @PostMapping("/registrar-simple")
    public ResponseEntity<String> registrarVentaSimple(@RequestBody Map<String, Object> request) {
        try {
            int clienteId = (int) request.get("clienteId");
            int vendedorId = (int) request.get("vendedorId");
            boolean factura = (boolean) request.get("factura");
            BigDecimal montoManual = new BigDecimal(request.get("montoManual").toString());
            BigDecimal abono = new BigDecimal(request.get("abono").toString());
            Integer tipoPagoId = (Integer) request.get("tipoPagoId");

            vS.registrarVentaSimple(clienteId, vendedorId, factura, montoManual, abono, tipoPagoId);

            return ResponseEntity.ok("Venta simple registrada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta simple: " + e.getMessage());
        }
    }

    // Obtener solo las ventas del usuario autenticado
    @GetMapping
    public List<VentaDTO> listar() {
        return vS.obtenerVentasPorUsuario().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VentaDTO.class);
        }).collect(Collectors.toList());
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public VentaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(vS.listarId(id), VentaDTO.class);
    }
}