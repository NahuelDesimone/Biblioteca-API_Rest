package com.biblioteca.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "AUTOR")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_AUTOR")
    Long idAutor;

    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "APELLIDO")
    String apellido;

    @Column(name = "NACIONALIDAD")
    String nacionalidad;
}
