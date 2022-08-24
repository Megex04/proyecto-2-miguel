package pe.com.nttdata.mlca.producto.controller;

import java.time.LocalDate;

public record ProductoRequest(Long id, String nombre, String peso, String cantidad, String precio, LocalDate fechaVencimiento) {
}
