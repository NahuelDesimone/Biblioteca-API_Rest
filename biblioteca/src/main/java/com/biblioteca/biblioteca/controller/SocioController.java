package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Socio;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface SocioController {
    public ResponseEntity<Socio> createSocio(Socio socio);

    public List<Socio> getAllSocios();

    public Optional<Socio> getSocioById(Long id);
    
    public String updateSocio(@RequestBody Socio socioNew);

    public String deleteSocio(@PathVariable Long id);

}
