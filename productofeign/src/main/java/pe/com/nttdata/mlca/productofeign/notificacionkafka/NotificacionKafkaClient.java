package pe.com.nttdata.mlca.productofeign.notificacionkafka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notificacionkafka",
        url = "${productofeign.notificacionkafka.url}"
)
public interface NotificacionKafkaClient {
    @PostMapping(path = "api/v1/prodnotificacionkafka")
    void enviarNotificacion(@RequestBody NotificacionKafkaRequest notificacionKafkaRequest);
}
