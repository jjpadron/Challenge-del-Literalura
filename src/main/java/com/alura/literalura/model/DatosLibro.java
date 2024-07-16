package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id")  Long id1,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> Autores,
        @JsonAlias("languages") List<String> lenguaje,
        @JsonAlias("download_count")  Long download_cuenta
) {


}