package pe.com.nttdata.mlca.producto.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ubicacion implements Serializable{

    @Id
    @SequenceGenerator(
            name = "ubicacion_id_sequence",
            sequenceName = "ubicacion_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ubicacion_id_sequence"
    )
    @Column(name = "ubicacion_id")
    private int id;

    @Column(name = "ubicacion_nombre")
    private String nombre;


}
