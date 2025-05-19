package com.FilmHunt.cl.FilmHunt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String nombreUsuario;

    @Column (nullable = false)
    private String correo;

    @Column (nullable = false)
    private String contrasena;
      
    @ManyToOne
    @JoinColumn(name = "idTipoUsuario", nullable = false)
    private TipoUsuario idTipoUsuario;
    
}

