package com.FilmHunt.cl.FilmHunt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FilmHunt.cl.FilmHunt.model.Lista;


@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {

    List<Lista> findByTituloLista(String tituloLista);

}
