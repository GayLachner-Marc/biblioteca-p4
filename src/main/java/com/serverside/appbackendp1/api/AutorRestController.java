package com.serverside.appbackendp1.api;

import com.serverside.appbackendp1.dto.AutorDTO;
import com.serverside.appbackendp1.model.Autor;
import com.serverside.appbackendp1.repository.AutorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorRestController {

    private final AutorRepository autorRepository;

    public AutorRestController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<AutorDTO> listarAutores() {

        List<Autor> autores = autorRepository.findAllByOrderByNombreAsc();

        return autores.stream()
                .map(autor -> new AutorDTO(
                        autor.getId(),
                        autor.getNombre(),
                        autor.getNacionalidad()
                ))
                .toList();
    }
}