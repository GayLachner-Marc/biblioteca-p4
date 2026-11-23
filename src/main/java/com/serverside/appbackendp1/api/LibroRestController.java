
package com.serverside.appbackendp1.api;

import com.serverside.appbackendp1.dto.AutorDTO;
import com.serverside.appbackendp1.dto.LibroDTO;
import com.serverside.appbackendp1.model.Libro;
import com.serverside.appbackendp1.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    private final LibroService libroService;

    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroDTO> listarLibros() {

        List<Libro> libros = libroService.listar();

        return libros.stream()
                .map(libro -> new LibroDTO(
                        libro.getId(),
                        libro.getTitulo(),
                        libro.getIsbn(),
                        libro.getEditorial(),
                        libro.getAnioPublicacion(),
                        libro.getEjemplaresDisponibles(),
                        libro.getAutores().stream()
                                .map(autor -> new AutorDTO(
                                        autor.getId(),
                                        autor.getNombre(),
                                        autor.getNacionalidad()
                                ))
                                .toList()
                ))
                .toList();
    }
}
