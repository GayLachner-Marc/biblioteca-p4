package com.serverside.appbackendp1.dto;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDTO(
        Long id,
        String nombre,
        String apellidos,
        String email,
        String telefono,
        LocalDate fechaAlta,
        List<String> roles
) {}
