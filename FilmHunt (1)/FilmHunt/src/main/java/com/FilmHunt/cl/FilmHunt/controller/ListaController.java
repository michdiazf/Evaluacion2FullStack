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

import com.FilmHunt.cl.FilmHunt.model.Lista;
import com.FilmHunt.cl.FilmHunt.service.ListaService;


@RestController
@RequestMapping("/api/v1/Lista")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @GetMapping
    public ResponseEntity <List<Lista>> listar(){
        List<Lista> lista =listaService.findAll();
        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(lista);
    }
    
        @GetMapping("/{id}")
    public ResponseEntity<Lista> buscar(@PathVariable Integer id){
        try{
            Lista lista = listaService.findById(id);
            return ResponseEntity.ok(lista);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Lista> guardar(@RequestBody Lista lista) {
        Lista listaNuevo = listaService.save(lista);
        return ResponseEntity.status(HttpStatus.CREATED).body(listaNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lista> actualizar(@PathVariable Integer id, @RequestBody Lista lista){
        try{
            listaService.save(lista);
            return ResponseEntity.ok(lista);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Lista> patchLista(@PathVariable Integer id, @RequestBody Lista partialLista) {
        try {
            Lista updatedLista = listaService.patchLista(id, partialLista);
            return ResponseEntity.ok(updatedLista);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            listaService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
