package com.alura.literalura.principal;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.*;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
import java.util.stream.Collectors;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    //  private final String API_KEY = "&apikey=4fc7c187";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibro> datosLibros = new ArrayList<>();

    private LibroRepository repositorio;

    private List<Libro> libros;
    private Optional<Libro> libroBuscada;

    public Principal(LibroRepository repository1) {
        this.repositorio = repository1;
    }


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por Titulo 
                    2 - Listar Libros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores en un determinado Año
                    5 - Listar Libros por Idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibros();
                  break;
                case 3:
                    mostrarAutores();
                    break;
                case 4:
                    //mostrarAutoresxAño();
                    break;
                case 5:
                    // mostrarLibrosxIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }



    private void buscarLibro() {
        DatosLibroJSON datos = getDatosLibroJSON();


        datos.ListaDatosLibro().forEach(e -> {
            System.out.printf("titulo %s idiomas %s download_cuenta %s\n",
                    e.titulo(), e.lenguaje(), e.download_cuenta());

            e.Autores().forEach(d -> {
                Libro libro = new Libro(e.titulo(), e.lenguaje(), d.getName(), d.getBirth_year(), d.getDeath_year(), e.download_cuenta());
            repositorio.save(libro);

            });


        });


    }

    private DatosLibroJSON getDatosLibroJSON() {
        System.out.println("Escribe el nombre del libro  que deseas buscar");
        var nombreLibro = teclado.nextLine();

        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));

        DatosLibroJSON datos = conversor.obtenerDatos(json, DatosLibroJSON.class);

        return datos;
    }

    private void mostrarLibros() {
        List<Libro> libros = repositorio.findAll();
        System.out.println("titulo                                      idiomas                 Autores                     download_cuenta %s\n");
        System.out.println("==========================================  =======                 ============================   ==============  \n");

        libros.forEach(e -> System.out.printf("%s                                        %s                      %s                            %s\n", e.getTitle(), e.getLanguages(), e.getName(), e.getDownload_count()));
    }

    private void mostrarAutores() {
        List<Libro> libros = repositorio.findAll();
        System.out.println("Idioma   Birth_year  Death_year    Autores\n");
        System.out.println("======   ==========  ==========    ============================\n");

        libros.forEach(e -> System.out.printf("%s        %s         %s           %s \n", e.getLanguages(), e.getBirth_year()  ,e.getDeath_year(), e.getName()));
    }

}
