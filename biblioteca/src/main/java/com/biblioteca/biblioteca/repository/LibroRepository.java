package com.biblioteca.biblioteca.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.biblioteca.model.Libro;

@Repository
    public interface LibroRepository extends CrudRepository<Libro, Long> {
        Void save(Optional<Libro> libroToUpdate);
    }

