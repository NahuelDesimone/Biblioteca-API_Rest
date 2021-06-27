package com.biblioteca.biblioteca.service;

import java.util.Optional;
import java.util.List;
import com.biblioteca.biblioteca.model.Socio;

public interface SocioService {

    public List<Socio> findAllSocios();

    public Optional<Socio> findSocioByID(Long id);

    public Socio saveSocio(Socio socioNew);

    public String deleteSocio(Long id);

    public String updateSocio(Socio socioUpdated);
}
