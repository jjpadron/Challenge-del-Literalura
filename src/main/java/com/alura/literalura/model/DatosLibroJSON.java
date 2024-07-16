package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibroJSON(
        @JsonAlias("count")  Long cuenta,
        @JsonAlias("next") String proximo,
        @JsonAlias("previous") String anterior,
        @JsonAlias("results") List<DatosLibro> ListaDatosLibro
) {


}