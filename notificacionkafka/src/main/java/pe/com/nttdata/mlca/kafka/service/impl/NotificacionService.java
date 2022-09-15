package pe.com.nttdata.mlca.kafka.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.mlca.kafka.dao.INotificacionDao;
import pe.com.nttdata.mlca.kafka.model.Notificacion;
import pe.com.nttdata.mlca.kafka.service.INotificacionService;
import pe.com.nttdata.mlca.productofeign.notificacionkafka.NotificacionKafkaRequest;

import java.util.Date;

@Service
@AllArgsConstructor
public class NotificacionService implements INotificacionService {

    private final INotificacionDao notificacionDao;

    public boolean enviarNotificacion(NotificacionKafkaRequest notificacionRequest) {
        notificacionDao.save(
                Notificacion.builder()
                        .productoId(notificacionRequest.productoId())
                        .productoNombre(notificacionRequest.productoNombre())
                        .fechaVencimiento(notificacionRequest.fechaVencimiento())
                        .horaEnvio(new Date())
                        .build()
        );
        return false;
    }
}
