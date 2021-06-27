package com.biblioteca.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "GENERO")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_GENERO")
    Long idGenero;

    @Column(name = "NOMBRE")
    String nombre;
}
