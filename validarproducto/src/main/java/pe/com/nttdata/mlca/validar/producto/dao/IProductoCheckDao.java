package pe.com.nttdata.mlca.validar.producto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.mlca.validar.producto.model.ProductoCheck;

public interface IProductoCheckDao extends JpaRepository<ProductoCheck, Integer> {
}
