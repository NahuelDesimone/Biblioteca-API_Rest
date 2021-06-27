package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.biblioteca.model.Socio;
import com.biblioteca.biblioteca.service.SocioService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class SocioControllerImpl implements SocioController{
    @Autowired
    SocioService socioService;

    // http://localhost:8080/socios (GET)
    @RequestMapping(value="/socios", method=RequestMethod.GET,produces = "application/json")
    @Override
    public List<Socio> getSocios(){
        return socioService.findAllSocios();
    }

    // http://localhost:8080/socios/1 (GET)
    @RequestMapping(value="/socios/{id}", method=RequestMethod.GET,produces = "application/json")
    @Override
    public Optional<Socio> getSocioById(@PathVariable Long id){
        return socioService.findSocioByID(id);
    }
    
    // http://localhost:8080/socios/add (ADD)
    @Override
    @RequestMapping(value="/socios/add", method=RequestMethod.POST,produces = "application/json")
    public Socio addSocio(Socio socio){
        return socioService.saveSocio(socio);
    }

    // http://localhost:8080/socios/delete/1 (GET)
	@Override
	@RequestMapping(value = "/socios/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteSocio(@PathVariable Long id) {
		return socioService.deleteSocio(id);
	}

    // http://localhost:8080/socios/update (PATCH)
	@Override
	@RequestMapping(value = "/socios/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateSocio(Socio socioNew) {
		return socioService.updateSocio(socioNew);
	}

    // http://localhost:8080/testSocios (GET)
	@RequestMapping(value = "/testSocios", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test socios done";
	}
    

}
