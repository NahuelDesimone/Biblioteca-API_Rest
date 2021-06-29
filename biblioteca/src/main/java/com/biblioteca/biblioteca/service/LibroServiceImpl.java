package com.biblioteca.biblioteca.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<Libro> findAllLibros() {
        return (List<Libro>)libroRepository.findAll();
    }

    @Override
    public Optional<Libro> findLibroByID(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro;
    }
    
    @Override
    public Libro saveLibro(Libro libroNew) {
        if (libroNew != null){
            return libroRepository.save(libroNew);
        }
        return new Libro();
    }

    @Override
    public String deleteLibro(Long id) {
        if (libroRepository.findById(id).isPresent()){
            libroRepository.deleteById(id);
            return "Libro eliminado correctamente";
        }
        return "Error! El libro no existe";
    }

    @Override
    public String updateLibro(Libro libroUpdated){
        Long num = libroUpdated.getIdLibro();
        if(libroRepository.findById(num).isPresent()){
            Libro libroToUpdate = new Libro();
            libroToUpdate.setIdLibro(libroUpdated.getIdLibro());
            libroToUpdate.setNombre(libroUpdated.getNombre());
            libroToUpdate.setAutor(libroUpdated.getAutor());
            libroToUpdate.setEditorial(libroUpdated.getEditorial());
            libroToUpdate.setGenero(libroToUpdate.getGenero());
            libroRepository.save(libroToUpdate);
            return "Libro modificado";
        }
        else{
            return "Error! El libro que se quiere modificar no existe";
        }
    }
}