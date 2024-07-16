package com.alura.literalura.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private Number birth_year;
    private Number death_year;
    private String  name;

    //@ManyToOne
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Libro libro;

    public Autor(){}

    public Autor(Number birth_year, Number death_year, String name, Libro libro) {
        this.birth_year = birth_year;
        this.death_year = death_year;
        this.name = name;
        this.libro = libro;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Number getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Number birth_year) {
        this.birth_year = birth_year;
    }

    public Number getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Number death_year) {
        this.death_year = death_year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setAutor(Libro libro) {
    }
}
//private authors: <array of Persons>,


