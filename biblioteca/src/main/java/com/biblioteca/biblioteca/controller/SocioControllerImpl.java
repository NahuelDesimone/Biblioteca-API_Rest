package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.biblioteca.model.Socio;
import com.biblioteca.biblioteca.service.SocioService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/biblioteca/socios/")
public class SocioControllerImpl implements SocioController {
    @Autowired
    SocioService socioService;

    // CREATE
    @PostMapping(value = "/createSocio")
    public ResponseEntity<Socio> createSocio(@RequestBody Socio socioNew) {
        Socio socio = socioService.saveSocio(socioNew);
        return new ResponseEntity<Socio>(socio, HttpStatus.OK);
    }

    // READ ALL
    @GetMapping(value = "/readAllSocios")
    public List<Socio> getAllSocios() {
        return socioService.findAllSocios();
    }

    // READ SOCIO BY ID
    @GetMapping(value = "/readSocio/{id}")
    public Optional<Socio> getSocioById(@PathVariable Long id) {
        return socioService.findSocioByID(id);
    }

    // UPDATE
    @PatchMapping(value = "/updateSocio")
    public String updateSocio(@RequestBody Socio socioNew) {
        return socioService.updateSocio(socioNew);
    }

    // DELETE
    @DeleteMapping(value = "/deleteSocio/{id}")
    public String deleteSocio(@PathVariable Long id) {
        if (socioService.findSocioByID(id).isPresent()) {
            return socioService.deleteSocio(id);
        } else {
            return "Error! El libro ingresado no existe, no se puede eliminar";
        }
    }
}
