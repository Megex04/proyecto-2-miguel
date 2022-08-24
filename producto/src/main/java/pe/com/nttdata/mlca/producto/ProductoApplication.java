package pe.com.nttdata.mlca.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "pe.com.nttdata.mlca.producto",
                "pe.com.nttdata.mlca.productoqueues"
        }
)
@EnableFeignClients(
        basePackages = "pe.com.nttdata.mlca.productofeign"
)
@PropertySources({
        @PropertySource("classpath:productofeign-${spring.profiles.active}.properties")
})
public class ProductoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductoApplication.class, args);
    }
}