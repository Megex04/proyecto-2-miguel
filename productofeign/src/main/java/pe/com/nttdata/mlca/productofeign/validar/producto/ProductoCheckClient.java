package pe.com.nttdata.mlca.productofeign.validar.producto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("validarproducto")
@FeignClient(
        name = "validarproducto",
        url = "${productofeign.validarproducto.url}"
)
public interface ProductoCheckClient {
    @GetMapping(path = "api/v1/producto-check/{productoId}")
    ProductoCheckResponse validarProducto(@PathVariable("productoId") Long productoId);
}
