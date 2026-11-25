package com.serverside.appbackendp1.dto;

import com.serverside.appbackendp1.model.EstadoPrestamo;

import java.time.LocalDate;

public record PrestamoDTO(
        Long id,
        Long usuarioId,
        String nombreUsuario,
        Long libroId,
        String tituloLibro,
        LocalDate fechaPrestamo,
        LocalDate fechaDevolucionPrevista,
        LocalDate fechaDevolucion,
        EstadoPrestamo estado
) {}