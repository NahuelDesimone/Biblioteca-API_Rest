package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.LibroService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/biblioteca/libros/")
public class LibroControllerImpl implements LibroController {

    @Autowired
    LibroService libroService;

    // CREATE
    @PostMapping(value = "/createLibro")
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libroNew) {
        Libro libro = libroService.saveLibro(libroNew);
        return new ResponseEntity<Libro>(libro, HttpStatus.OK);
    }

    // READ ALL
    @GetMapping(value = "/readAllLibros")
    public List<Libro> getAllLibros() {
        return libroService.findAllLibros();
    }

    // READ LIBRO BY ID
    @GetMapping(value = "/readLibro/{id}")
    public Optional<Libro> getLibroById(@PathVariable Long id) {
        return libroService.findLibroByID(id);
    }

    // UPDATE
    @PatchMapping(value = "/updateLibro")
    public String updateLibro(@RequestBody Libro libroNew) {
        return libroService.updateLibro(libroNew);
    }

    // DELETE
    @DeleteMapping(value = "/deleteLibro/{id}")
    public String deleteLibro(@PathVariable Long id) {
        if (libroService.findLibroByID(id).isPresent()) {
            return libroService.deleteLibro(id);
        } else {
            return "Error! El libro ingresado no existe, no se puede eliminar";
        }
    }
}