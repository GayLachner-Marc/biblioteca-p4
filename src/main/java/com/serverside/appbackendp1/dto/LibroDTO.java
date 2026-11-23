package com.serverside.appbackendp1.dto;

import java.util.List;

public record LibroDTO(
        Long id,
        String titulo,
        String isbn,
        String editorial,
        Integer anioPublicacion,
        Integer ejemplaresDisponibles,
        List<AutorDTO> autores
) {
}