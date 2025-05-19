package com.FilmHunt.cl.FilmHunt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FilmHunt.cl.FilmHunt.model.Peliculas;
import com.FilmHunt.cl.FilmHunt.service.PeliculasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/Peliculas")
public class PeliculasController {

    @Autowired
    private PeliculasService peliculaService;

    @GetMapping
    public ResponseEntity <List<Peliculas>> listar(){
        List<Peliculas> pelicula =peliculaService.findAll();
        if (pelicula.isEmpty()){
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(pelicula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peliculas> buscar(@PathVariable Integer id){
        try{
            Peliculas pelicula = peliculaService.findById(id);
            return ResponseEntity.ok(pelicula);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Peliculas> guardar(@RequestBody Peliculas pelicula) {
        Peliculas peliculaNuevo = peliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peliculas> actualizar(@PathVariable Integer id, @RequestBody Peliculas pelicula){
        try{
            peliculaService.save(pelicula);
            return ResponseEntity.ok(pelicula);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Peliculas> patchPelicula(@PathVariable Integer id, @RequestBody Peliculas partialPelicula) {
        try {
            Peliculas updatedPeliculas = peliculaService.patchPelicula(id, partialPelicula);
            return ResponseEntity.ok(updatedPeliculas);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            peliculaService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }




}
