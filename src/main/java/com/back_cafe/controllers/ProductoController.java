package com.back_cafe.controllers;

import com.back_cafe.dtos.ProductoDTO;
import com.back_cafe.entities.HistorialPrecioProducto;
import com.back_cafe.entities.Producto;
import com.back_cafe.entities.Usuario;
import com.back_cafe.repositories.IUsuarioRepository;
import com.back_cafe.servicesintefaces.IHistorialPrecioProductoService;
import com.back_cafe.servicesintefaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService pS;

    @Autowired
    private IHistorialPrecioProductoService hS;

    @Autowired
    private IUsuarioRepository uR;

    @PostMapping
    public void insertar(@RequestBody ProductoDTO dto){
        ModelMapper m = new ModelMapper();
        Producto producto = m.map(dto, Producto.class);
        pS.insert(producto); // Guarda primero el producto

        // Obtener el usuario autenticado desde el JWT
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Esto obtiene el "sub" del JWT

        // Buscar el usuario por su username (o correo)
        Usuario usuario = uR.findByUsername(username); // ajusta si usas 'correo' en vez de username

        // Crear el historial con precio anterior 0 (o null) y nuevo el del producto
        HistorialPrecioProducto historial = new HistorialPrecioProducto();
        historial.setProducto(producto);
        historial.setUsuario(usuario);
        historial.setPrecio_anterior(0.0);
        historial.setPrecio_nuevo(producto.getPrecio_lista());
        historial.setFecha_cambio(LocalDate.now());

        hS.insert(historial);
    }


    @GetMapping
    public List<ProductoDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        pS.delete(id);
    }

    @GetMapping("/{id}")
    public ProductoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ProductoDTO dto = m.map(pS.listarId(id), ProductoDTO.class);
        return dto;
    }

    @PutMapping("/actualizarPrecio")
    public ResponseEntity<String> actualizarPrecio(@RequestBody Map<String, Object> request) {
        try {
            Integer idProducto = Integer.parseInt(request.get("idProducto").toString());
            Double nuevoPrecio = Double.parseDouble(request.get("nuevoPrecio").toString());

            // Suponiendo que ya estás usando el JWT
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Usuario usuario = uR.findByUsername(username);

            pS.actualizarPrecioProducto(idProducto, nuevoPrecio, usuario.getIdusuario());

            return ResponseEntity.ok("Precio actualizado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el precio: " + e.getMessage());
        }
    }


}
