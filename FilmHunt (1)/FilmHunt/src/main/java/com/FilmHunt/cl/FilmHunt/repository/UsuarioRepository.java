package com.FilmHunt.cl.FilmHunt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FilmHunt.cl.FilmHunt.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNombreUsuario(String nombreUsuario);

    List<Usuario> findByCorreo(String correo);

    List<Usuario> findByContrasena(String correo);

}
