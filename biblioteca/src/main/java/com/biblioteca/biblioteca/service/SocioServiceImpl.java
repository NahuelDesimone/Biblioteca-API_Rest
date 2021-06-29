package com.biblioteca.biblioteca.service;

import java.util.List;
import java.util.Optional;
import com.biblioteca.biblioteca.model.Socio;
import com.biblioteca.biblioteca.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    SocioRepository socioRepository;

    @Override
    public List<Socio> findAllSocios() {
        return (List<Socio>) socioRepository.findAll();
    }

    @Override
    public Optional<Socio> findSocioByID(Long id) {
        Optional<Socio> socio = socioRepository.findById(id);
        return socio;
    }

    @Override
    public Socio saveSocio(Socio socioNew) {
        if (socioNew != null){
            return socioRepository.save(socioNew);
        }
        return new Socio();
    }

    @Override
    public String deleteSocio(Long id) {
        if (socioRepository.findById(id).isPresent()){
            socioRepository.deleteById(id);
            return "Socio eliminado correctamente";
        }
        return "Error! El socio no existe";
    }

    @Override
    public String updateSocio(Socio socioUpdated) {
        Long num = socioUpdated.getIdSocio();
        if(socioRepository.findById(num).isPresent()){
            Socio socioToUpdate = new Socio();
            socioToUpdate.setIdSocio(socioUpdated.getIdSocio());
            socioToUpdate.setNombre(socioUpdated.getNombre());
            socioToUpdate.setApellido(socioUpdated.getApellido());
            socioToUpdate.setEmail(socioUpdated.getEmail());
            socioRepository.save(socioToUpdate);
            return "Socio modificado";
        }
        else{
            return "Error al modificar el socio";
        }
    }  
}
