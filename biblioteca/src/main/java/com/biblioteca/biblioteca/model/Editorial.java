package com.biblioteca.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "EDITORIAL")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_EDITORIAL")
    Long idEditorial;

    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "PAIS")
    String pais;
    
}
