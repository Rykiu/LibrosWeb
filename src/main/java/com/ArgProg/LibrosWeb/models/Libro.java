package com.ArgProg.LibrosWeb.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private long  isbn;
	private String titulo;
	private int anio;
	private int ejemplares;
	private int ejemplaresprestados;
	private int ejemplaresrestantes;
	private boolean alta;
	
	@ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
	
	@ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;	
}
