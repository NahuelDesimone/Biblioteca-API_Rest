package com.biblioteca.biblioteca.service;
import java.util.Optional;
import java.util.List;
import com.biblioteca.biblioteca.model.Libro;

public interface LibroService {

    public List<Libro> findAllLibros();

    public Optional<Libro> findLibroByID(Long id);

    public Libro saveLibro(Libro libroNew);

    public String deleteLibro(Long id);

    public String updateLibro(Libro libroNew);
    
}
