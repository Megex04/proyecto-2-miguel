package pe.com.nttdata.mlca.producto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {
    @Id
    @SequenceGenerator(
            name = "producto_id_sequence",
            sequenceName = "producto_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "producto_id_sequence"
    )
    @Column(name = "producto_id")
    private Long id;

    @Column(name = "producto_nombre")
    @NotEmpty(message = "{NotEmpty.producto.nombre}")
    @Pattern(regexp = "[a-zA-Z]{3,15}", message = "{Pattern.producto.nombre}")
    private String nombre;

    @Column(name = "producto_peso")
    @NotEmpty(message = "{NotEmpty.producto.peso}")
    //  \\d{3}\.\\d{2}
    @Pattern(regexp = "\\d+\\.\\d+", message = "{Pattern.producto.peso}")
    private String peso;

    @Column(name = "producto_cantidad")
    @NotEmpty(message = "{NotEmpty.producto.cantidad}")
    @Pattern(regexp = "\\d+", message = "{Pattern.producto.cantidad}")
    private String cantidad;

    @Column(name = "producto_precio")
    @NotEmpty (message = "{NotEmpty.producto.precio}")
    //  \\d{3}\.\\d{2}
    @Pattern(regexp = "\\d+\\.\\d+", message = "{Pattern.producto.precio}")
    private String precio;

    @Column(name ="producto_fechaVencimiento")
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name="ubicacion_id", nullable = false)
    @NotNull(message = "{NotNull.producto.ubicacion}")
    private Ubicacion ubicacion;
}
