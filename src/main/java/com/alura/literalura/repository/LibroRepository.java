package com.alura.literalura.repository;
import com.alura.literalura.model.Libro;
import com.alura.literalura.model.LibrosxAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findByTitleContainsIgnoreCase(String nombreLibro);

   // List<Libro> findTop5ByOrderByEvaluacionDesc();

    //List<Libro> findByLanguages(String idioma);
    //List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);

    //   @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")
    //   List<Libro> LibrosPorTemparadaYEvaluacion(int totalTemporadas, Double evaluacion);

//    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
//    List<Autor> AutoresPorNombre(String nombreAutor);

  //@Query("SELECT l FROM libros l")
   //List<Libro> ListarLibrosxAutor();




}






