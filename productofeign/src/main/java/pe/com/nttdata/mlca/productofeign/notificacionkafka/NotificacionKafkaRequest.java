package pe.com.nttdata.mlca.productofeign.notificacionkafka;

import java.time.LocalDate;

public record NotificacionKafkaRequest(Long productoId, String productoNombre, String fechaVencimiento) {
}
