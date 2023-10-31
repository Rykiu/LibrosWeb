package com.ArgProg.LibrosWeb.services;

import java.util.List;

import com.ArgProg.LibrosWeb.models.Libro;

public interface ILibroService {
	
	public void guardarLibro(Libro libro);
	public void modificarLibro(Integer id, Libro libro);
	public void borrarLibro(Libro libro);
	public void bajaLibro(Libro libro);
	public void altaLibro(Libro libro);
	public List<Libro> getAllLibros();
	public Libro getLibroById(Integer id);
	public Libro getLibroByIsbn(long isbn);
	public List<Libro> getLibroByAutor(String autorNombre);
	public List<Libro> getLibroByEditorial(String editorialNombre);
}
