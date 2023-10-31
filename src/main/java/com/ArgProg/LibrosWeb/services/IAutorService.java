package com.ArgProg.LibrosWeb.services;

import java.util.List;

import com.ArgProg.LibrosWeb.models.Autor;

public interface IAutorService {

	public void guardarAutor(Autor autor);
	public void modificarAutor(Integer id, Autor autor);
	public void borrarAutor(Autor autor);
	public List<Autor> getAllAutor();
	public Autor getAutorById(Integer Id);
	
}
