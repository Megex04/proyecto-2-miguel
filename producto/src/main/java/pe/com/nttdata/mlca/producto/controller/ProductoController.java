package pe.com.nttdata.mlca.producto.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.mlca.producto.model.Producto;
import pe.com.nttdata.mlca.producto.service.IProductoService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/producto")
@AllArgsConstructor
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping
    public ResponseEntity<?> listarProductos() {
        List<Producto> productos = productoService.listarProductos();
        log.info("Listar los productos");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    @GetMapping(value= "/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable("id") Long id) {
        log.info("Obtener producto: ", id);
        return new ResponseEntity<>(productoService.obtenerProducto(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> registrarProducto(@Valid @RequestBody Producto producto) {
        log.info("NUevo registro de producto {}", producto);
        Producto newProducto = productoService.registrarProducto(producto);
        return new ResponseEntity<ProductoRequest>(new ProductoRequest(newProducto.getId(),producto.getNombre(), producto.getPeso(), producto.getCantidad(), producto.getPrecio(), producto.getFechaVencimiento()), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> modificarProducto(@Valid @RequestBody Producto producto) {
        log.info("Modificar datos del producto {}", producto);
        productoService.modificarProducto(producto);
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
    @DeleteMapping(value="/{id}")
    public void eliminarProducto(@PathVariable("id") Long id){
        log.info("Eliminar producto: ", id);
        productoService.eliminarProducto(id);
    }
    //parametros por la URL
    @GetMapping(params = "nombre")
    public ResponseEntity<?> listarProductosPorNombreComo(@RequestParam String nombre) {
        List<Producto> productos = productoService.listarProductosPorNombreComo(nombre);
        log.info("Listar productos por nombre");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    @GetMapping(params = {"peso1", "peso2"})
    public ResponseEntity<?> listarProductosPorPesoEntre(@RequestParam String peso1, @RequestParam String peso2) {
        List<Producto> productos = productoService.listarProductosPorPesoEntre(peso1, peso2);
        log.info("listar productos por peso (entre)");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(params = "cantidad")
    public ResponseEntity<?> listarProductosPorCantidad(@RequestParam String cantidad) {
        List<Producto> productos = productoService.listarProductosPorCantidad(cantidad);
        log.info("Listar productos por cantidad");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(params = {"cantidad1", "cantidad2"})
    public ResponseEntity<?> listarProductosPorCantidadEntre(@RequestParam String cantidad1, @RequestParam String cantidad2) {
        List<Producto> productos = productoService.listarProductosPorCantidadEntre(cantidad1, cantidad2);
        log.info("listar productos por cantidad (entre)");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(params = {"precio1", "precio2"})
    public ResponseEntity<?> listarProductosPorPrecioEntre(@RequestParam String precio1, @RequestParam String precio2) {
        List<Producto> productos = productoService.listarProductosPorPrecioEntre(precio1, precio2);
        log.info("listar productos por precio (entre)");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(params="fechaVencimiento")
    public ResponseEntity<?> listarProductosPorFechaVencimiento(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaVencimiento) {
        List<Producto> productos = productoService.listarProductosPorFechaVencimiento(fechaVencimiento);
        log.info("listar productos por fecha de vencimiento: ", fechaVencimiento);
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
