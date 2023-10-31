package com.ArgProg.LibrosWeb.models;

import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Boolean alta;

    @OneToMany(mappedBy = "editorial")
    
    @JsonIgnore
    private List<Libro> libros;
	
}
