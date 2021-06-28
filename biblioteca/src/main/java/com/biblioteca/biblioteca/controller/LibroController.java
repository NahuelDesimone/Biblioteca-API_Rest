
package com.biblioteca.biblioteca.controller;

import java.util.List;
import com.biblioteca.biblioteca.model.Libro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

public interface LibroController {

    public ResponseEntity<Libro> createLibro(@RequestBody Libro libroNew);

    public List<Libro> getAllLibros();

    public Optional<Libro> getLibroById(Long id);

    public String updateLibro(@RequestBody Libro libroNew);

    public String deleteLibro(@PathVariable Long id);

    
    
}