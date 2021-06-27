package com.biblioteca.biblioteca.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.biblioteca.model.Socio;

@Repository
    public interface SocioRepository extends CrudRepository<Socio, Long> {
        Void save(Optional<Socio> libroToUpdate);
    }


