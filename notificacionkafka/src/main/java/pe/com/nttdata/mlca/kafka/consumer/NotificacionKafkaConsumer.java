package pe.com.nttdata.mlca.kafka.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.com.nttdata.mlca.kafka.service.INotificacionService;
import pe.com.nttdata.mlca.productofeign.notificacionkafka.NotificacionKafkaRequest;

@Service
@Slf4j
@AllArgsConstructor
public class NotificacionKafkaConsumer {

    private final INotificacionService notificacionService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    private void consumer(NotificacionKafkaRequest notificacionKafkaRequest){
        log.info("Notificación Kafka consumer: {}", notificacionKafkaRequest);
        notificacionService.enviarNotificacion(notificacionKafkaRequest);
    }
}
