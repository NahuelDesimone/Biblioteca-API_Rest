package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Socio;
import java.util.List;
import java.util.Optional;

public interface SocioController {
    public List<Socio> getSocios();

    public Optional<Socio> getSocioById(Long id);

    public Socio addSocio(Socio socio);

    public String deleteSocio(Long id);

    public String updateSocio(Socio socioNew);

    public String test();
}
