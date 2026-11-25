
package com.serverside.appbackendp1.api;

import com.serverside.appbackendp1.dto.PrestamoDTO;
import com.serverside.appbackendp1.model.Prestamo;
import com.serverside.appbackendp1.service.PrestamoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoRestController {

    private final PrestamoService prestamoService;

    public PrestamoRestController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<PrestamoDTO> listar() {
        return prestamoService.listar()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private PrestamoDTO convertirADTO(Prestamo prestamo) {
        return new PrestamoDTO(
                prestamo.getId(),
                prestamo.getUsuario().getId(),
                prestamo.getUsuario().getNombreCompleto(),
                prestamo.getLibro().getId(),
                prestamo.getLibro().getTitulo(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucionPrevista(),
                prestamo.getFechaDevolucion(),
                prestamo.getEstado()
        );
    }
}
