package com.serverside.appbackendp1.api;
import com.serverside.appbackendp1.dto.UsuarioDTO;
import com.serverside.appbackendp1.model.Rol;
import com.serverside.appbackendp1.model.Usuario;
import com.serverside.appbackendp1.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listar() {
        return usuarioService.listar()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getFechaAlta(),
                usuario.getRoles()
                        .stream()
                        .map(Rol::getNombre)
                        .sorted()
                        .toList()
        );
    }
}
