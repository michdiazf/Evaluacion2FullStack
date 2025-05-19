package com.FilmHunt.cl.FilmHunt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FilmHunt.cl.FilmHunt.model.Peliculas;
import com.FilmHunt.cl.FilmHunt.repository.PeliculaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PeliculasService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Peliculas> findAll(){
        return peliculaRepository.findAll();
    }

    public Peliculas findById(Integer id){
        return peliculaRepository.getById(id);
    }

    public Peliculas save(Peliculas peliculas){
        return peliculaRepository.save(peliculas);
    }

    public void delete(Integer id){
        peliculaRepository.deleteById(id);
    }

    public Peliculas patchPelicula(Integer id, Peliculas parcialPelicula){

            Peliculas peliculaToUpdate = findById(id);
            
            if (parcialPelicula.getTituloPelicula() != null) {
                peliculaToUpdate.setTituloPelicula(parcialPelicula.getTituloPelicula());   
            }

            if(parcialPelicula.getPuntuacion() != null) {
                peliculaToUpdate.setPuntuacion(parcialPelicula.getPuntuacion());
            }

            if(parcialPelicula.getDuracion() != null) {
                peliculaToUpdate.setDuracion(parcialPelicula.getDuracion());
            }
            
            if(parcialPelicula.getAno() != 0) {
                peliculaToUpdate.setAno(parcialPelicula.getAno());
            }

            return peliculaRepository.save(peliculaToUpdate);
        } 

    }


