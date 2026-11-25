
package com.serverside.appbackendp1.api;

import com.serverside.appbackendp1.dto.RolDTO;
import com.serverside.appbackendp1.model.Rol;
import com.serverside.appbackendp1.repository.RolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolRestController {

    private final RolRepository rolRepository;

    public RolRestController(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @GetMapping
    public List<RolDTO> listar() {
        return rolRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private RolDTO convertirADTO(Rol rol) {
        return new RolDTO(
                rol.getId(),
                rol.getNombre()
        );
    }
}
