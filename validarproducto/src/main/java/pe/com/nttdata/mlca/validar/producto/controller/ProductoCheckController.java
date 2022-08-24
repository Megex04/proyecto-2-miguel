package pe.com.nttdata.mlca.validar.producto.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.mlca.productofeign.validar.producto.ProductoCheckResponse;
import pe.com.nttdata.mlca.validar.producto.service.IProductoCheckService;

@Slf4j
@RestController
@RequestMapping("api/v1/producto-check")
@AllArgsConstructor
public class ProductoCheckController {

    private final IProductoCheckService productoCheckService;

    @GetMapping(path = "/{productoId}")
    public ProductoCheckResponse validarProducto(
            @PathVariable("productoId") Long productoId) {
        boolean estaVencido = productoCheckService.esProductoVencido(productoId);
        log.info("Validacion para el producto: {}", productoId);

        return new ProductoCheckResponse(estaVencido);
    }
}
