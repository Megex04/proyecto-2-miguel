package pe.com.nttdata.mlca.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.nttdata.mlca.producto.model.Producto;

import java.time.LocalDate;
import java.util.List;

public interface IProductoDao extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM producto p where p.producto_nombre like %?1%", nativeQuery = true)
    List<Producto> findByNombreLikePrsnlzd(String nombre);

    List<Producto> findByPesoBetween(String peso1, String peso2);

    List<Producto> findByCantidad(String cantidad);
    List<Producto> findByCantidadBetween(String cantidad1, String cantidad2);

    @Query(value = "SELECT * FROM producto p where p.producto_precio between ?1 and ?2", nativeQuery = true)
    List<Producto> findByPrecioBetween(String precio1, String precio2);

    List<Producto> findByFechaVencimiento(LocalDate fechaVencimiento);
}
