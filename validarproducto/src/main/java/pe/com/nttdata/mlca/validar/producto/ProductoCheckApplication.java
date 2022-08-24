package pe.com.nttdata.mlca.validar.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "e.com.nttdata.mlca.productofeign"
)
public class ProductoCheckApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductoCheckApplication.class, args);
    }
}
