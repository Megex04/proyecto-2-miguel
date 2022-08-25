package pe.com.nttdata.mlca.producto.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.mlca.producto.dao.IProductoDao;
import pe.com.nttdata.mlca.producto.model.Producto;
import pe.com.nttdata.mlca.producto.service.IProductoService;
import pe.com.nttdata.mlca.productofeign.validar.producto.ProductoCheckClient;
import pe.com.nttdata.mlca.productofeign.validar.producto.ProductoCheckResponse;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final IProductoDao productoDao;

    private final ProductoCheckClient productoCheckClient;

    public List<Producto> listarProductos() {
        return productoDao.findAll();
    }

    public Producto registrarProducto(Producto producto) {
        Producto objProducto = productoDao.save(producto);

        return objProducto;
    }
    public String validarProducto(Producto producto) {
        ProductoCheckResponse productoCheckResponse = productoCheckClient.validarProducto(producto.getId());

        if (productoCheckResponse.estaVencido()) {
            throw new IllegalStateException("El producto esta vencido!!!");
        }

        return "OK";
    }

    public Producto modificarProducto(Producto producto) {
        return productoDao.save(producto);
    }

    public int eliminarProducto(Long id) {
        productoDao.deleteById(id);
        return 0;
    }

    public Producto obtenerProducto(Long id) {
        return productoDao.findById(id).get();
    }

    public List<Producto> listarProductosPorNombreComo(String nombre) {
        return productoDao.findByNombreLikePrsnlzd(nombre);
    }

    public List<Producto> listarProductosPorPesoEntre(String peso1, String peso2) {
        return productoDao.findByPesoBetween(peso1, peso2);
    }

    public List<Producto> listarProductosPorCantidad(String cantidad) {
        return productoDao.findByCantidad(cantidad);
    }

    public List<Producto> listarProductosPorCantidadEntre(String cantidad1, String cantidad2) {
        return productoDao.findByCantidadBetween(cantidad1, cantidad2);
    }

    public List<Producto> listarProductosPorPrecioEntre(String precio1, String precio2) {
        return productoDao.findByPrecioBetween(precio1, precio2);
    }

    public List<Producto> listarProductosPorFechaVencimiento(LocalDate fechaVencimiento) {
        return productoDao.findByFechaVencimiento(fechaVencimiento);
    }
}
