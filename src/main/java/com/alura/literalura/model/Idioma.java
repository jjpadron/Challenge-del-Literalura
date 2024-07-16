package com.alura.literalura.model;

public enum Idioma {
    INGLES("en", "ingles"),
    FRANCES("fr", "frances"),
    ESPAÑOL("es", "español"),
    PORTUGUES("pg", "portugues");

    private String idiomaOmdb;
    private String idiomaEspanol;
    Idioma (String idiomaOmdb, String idiomaEspanol){
        this.idiomaOmdb = idiomaOmdb;
        this.idiomaEspanol = idiomaEspanol;
    }

    public static Idioma fromString(String text) {
        for (Idioma lenguaje : Idioma.values()) {
            if (lenguaje.idiomaOmdb.equalsIgnoreCase(text)) {
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + text);
    }

    public static Idioma fromEspanol(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaEspanol.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + text);
    }

}

