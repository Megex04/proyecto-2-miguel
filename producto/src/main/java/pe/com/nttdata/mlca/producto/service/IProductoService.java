package pe.com.nttdata.mlca.producto.service;

import pe.com.nttdata.mlca.producto.model.Producto;

import java.time.LocalDate;
import java.util.List;

public interface IProductoService {

    public List<Producto> listarProductos();
    public Producto registrarProducto(Producto producto);
    public Producto modificarProducto(Producto producto);
    public int eliminarProducto(Long id);
    public Producto obtenerProducto(Long id);
    public List<Producto> listarProductosPorNombreComo(String nombre);
    public List<Producto> listarProductosPorPesoEntre(String peso1, String peso2);
    public List<Producto> listarProductosPorCantidad(String cantidad);
    public List<Producto> listarProductosPorCantidadEntre(String cantidad1, String cantidad2);
    public List<Producto> listarProductosPorPrecioEntre(String precio1, String precio2);
    public List<Producto> listarProductosPorFechaVencimiento(LocalDate fechaVencimiento);
}
