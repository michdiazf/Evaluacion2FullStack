package com.FilmHunt.cl.FilmHunt.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FilmHunt.cl.FilmHunt.model.resena;

@Repository
public interface ResenaRepository extends JpaRepository<resena, Integer>{

    List<resena> findByTituloResena(String tituloResena );

    List<resena> findByAno(Date ano);

    List<resena> findByPuntuacionResena(String puntuacionResena);


}
