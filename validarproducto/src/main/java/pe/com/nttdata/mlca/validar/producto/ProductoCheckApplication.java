package pe.com.nttdata.mlca.validar.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "pe.com.nttdata.mlca.productofeign"
)
@EnableSwagger2
public class ProductoCheckApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductoCheckApplication.class, args);
    }
}
