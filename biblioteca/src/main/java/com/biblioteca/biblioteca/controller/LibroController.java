
package com.biblioteca.biblioteca.controller;

import java.util.List;
import java.util.Optional;
import com.biblioteca.biblioteca.model.Libro;

public interface LibroController {
    public List<Libro> getLibros();

    public Optional<Libro> getLibroById(Long id);

    public Libro addLibro(Libro libro);

    public String deleteLibro(Long id);

    public String updateLibro(Libro libroNew);

    public String test();

}