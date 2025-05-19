package com.FilmHunt.cl.FilmHunt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FilmHunt.cl.FilmHunt.model.resena;
import com.FilmHunt.cl.FilmHunt.service.ResenaService;

@RestController
@RequestMapping("/api/v1/Resena")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public ResponseEntity <List<resena>> listar(){
        List<resena> resena =resenaService.findAll();
        if (resena.isEmpty()){
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(resena);
    }

    @GetMapping("/{id}")
    public ResponseEntity<resena> buscar(@PathVariable Integer id){
        try{
            resena resena = resenaService.findById(id);
            return ResponseEntity.ok(resena);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<resena> guardar(@RequestBody resena resena) {
        resena resenaNuevo = resenaService.save(resena);
        return ResponseEntity.status(HttpStatus.CREATED).body(resenaNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<resena> actualizar(@PathVariable Integer id, @RequestBody resena resena){
        try{
            resenaService.save(resena);
            return ResponseEntity.ok(resena);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<resena> patchUsuario(@PathVariable Integer id, @RequestBody resena partialresena) {
        try {
            resena updatedrResena = resenaService.patchResena(id, partialresena);
            return ResponseEntity.ok(updatedrResena);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            resenaService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
