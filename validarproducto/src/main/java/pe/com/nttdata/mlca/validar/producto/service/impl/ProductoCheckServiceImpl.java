package pe.com.nttdata.mlca.validar.producto.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.mlca.validar.producto.dao.IProductoCheckDao;
import pe.com.nttdata.mlca.validar.producto.model.ProductoCheck;
import pe.com.nttdata.mlca.validar.producto.service.IProductoCheckService;

import java.util.Date;

@Service
@AllArgsConstructor
public class ProductoCheckServiceImpl implements IProductoCheckService {

    private final IProductoCheckDao productoCheckDao;

    public boolean esProductoVencido(Long productoId) {
        productoCheckDao.save(
                ProductoCheck.builder()
                        .clienteId(productoId)
                        .estaVencido(false)
                        .fechaCreacion(new Date())
                        .build()
        );

        return false;
    }
}
