package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.LibroService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class LibroControllerImpl implements LibroController {

    @Autowired
    LibroService libroService;

    // http://localhost:8080/libros (GET)
    @RequestMapping(value="/libros", method=RequestMethod.GET,produces = "application/json")
    @Override
    public List<Libro> getLibros(){
        return libroService.findAllLibros();
    }

    // http://localhost:8080/libros/1 (GET)
    @RequestMapping(value="/libros/{id}", method=RequestMethod.GET,produces = "application/json")
    @Override
    public Optional<Libro> getLibroById(@PathVariable Long id){
        return libroService.findLibroByID(id);
    }
    
    // http://localhost:8080/libros/add (ADD)
    @Override
    @RequestMapping(value="/libros/add", method=RequestMethod.POST,produces = "application/json")
    public Libro addLibro(Libro libro){
        return libroService.saveLibro(libro);
    }

    // http://localhost:8080/libros/delete/1 (GET)
	@Override
	@RequestMapping(value = "/libros/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteLibro(@PathVariable Long id) {
		return libroService.deleteLibro(id);
	}

    // http://localhost:8080/libros/update (PATCH)
	@Override
	@RequestMapping(value = "/libros/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateLibro(Libro libroNew) {
		return libroService.updateLibro(libroNew);
	}

    // http://localhost:8080/testLibros (GET)
	@RequestMapping(value = "/testLibros", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test libro done";
	}

}