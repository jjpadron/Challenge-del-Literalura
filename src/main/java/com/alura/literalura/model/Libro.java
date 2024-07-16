package com.alura.literalura.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private String title;
    private String languages ;
    private String  name;
    private Number birth_year;
    private Number death_year;
    private Long  download_count;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;

    public Libro(){}



    public Libro(String title, List<String> idiomas,  String name, Number birth_year, Number death_year, Long download_count) {
        this.title = title;
        this.languages =  idiomas.get(0);
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
        this.download_count = download_count;
    }

    public String getName() {
        return name;
    }



    public Number getBirth_year() {
        return birth_year;
    }

    public Number getDeath_year() {
        return death_year;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        autores.forEach(e -> e.setAutor(this));
        this.autores = autores;
    }


//    this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Number  getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Long download_count) {
        this.download_count = download_count;
    }
    public void setLenguaje(String languages) {
        this.languages = languages;
    }

    public String getLanguages() {
        return languages;
    }


}
