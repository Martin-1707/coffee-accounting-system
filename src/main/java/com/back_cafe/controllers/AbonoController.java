package com.back_cafe.controllers;

import com.back_cafe.dtos.AbonoDTO;
import com.back_cafe.servicesintefaces.IAbonoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/abonos")
public class AbonoController {
    @Autowired
    private IAbonoService aS;

    @GetMapping
    public List<AbonoDTO> listar() {
        return aS.obtenerAbonosPorUsuario().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AbonoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AbonoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        AbonoDTO dto = m.map(aS.listarId(id), AbonoDTO.class);
        return dto;
    }

    @PostMapping("/registrarAbono")
    public ResponseEntity<String> registrarAbono(@RequestBody Map<String, Object> request) {
        try {
            int ventaId = (int) request.get("ventaId");
            BigDecimal abono = new BigDecimal(request.get("abono").toString());
            int tipoPagoId = (int) request.get("tipoPagoId");

            aS.registrarAbono(ventaId, abono, tipoPagoId);

            return ResponseEntity.ok("Abono registrado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar el abono: " + e.getMessage());
        }
    }

    @GetMapping("/venta/{ventaId}")
    public ResponseEntity<List<AbonoDTO>> listarAbonosPorVenta(@PathVariable int ventaId) {
        List<AbonoDTO> lista = aS.obtenerAbonosPorVenta(ventaId).stream()
                .map(a -> new ModelMapper().map(a, AbonoDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }
}
