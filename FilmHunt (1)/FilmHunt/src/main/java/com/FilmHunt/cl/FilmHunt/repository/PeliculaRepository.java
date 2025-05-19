package com.FilmHunt.cl.FilmHunt.repository;

import com.FilmHunt.cl.FilmHunt.model.Peliculas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas, Integer>{

    List<Peliculas> findByTituloPelicula(String tituloPelicula);

    List<Peliculas> findByPuntuacion(String puntuacion);

    List<Peliculas> findByDuracion(String duracion);

    List<Peliculas> findByAno(Integer ano);

}
