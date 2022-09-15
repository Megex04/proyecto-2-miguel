package pe.com.nttdata.mlca.kafka.service;

import pe.com.nttdata.mlca.productofeign.notificacionkafka.NotificacionKafkaRequest;

public interface INotificacionService {
    public boolean enviarNotificacion(NotificacionKafkaRequest notificacionRequest);
}
