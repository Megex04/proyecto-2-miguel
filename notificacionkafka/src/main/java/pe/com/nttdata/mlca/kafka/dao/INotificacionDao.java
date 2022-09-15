package pe.com.nttdata.mlca.kafka.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.nttdata.mlca.kafka.model.Notificacion;

public interface INotificacionDao extends JpaRepository<Notificacion,Integer> {
}
