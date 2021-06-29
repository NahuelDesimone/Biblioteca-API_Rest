package com.biblioteca.biblioteca.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Table (name = "SOCIO")

public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_SOCIO")
    Long idSocio;

    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "APELLIDO")
    String apellido;

    @Column(name = "EMAIL")
    String email;

    @OneToMany(mappedBy = "socio")
    List<Libro> listaLibros;

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
