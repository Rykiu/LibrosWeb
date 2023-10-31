package com.ArgProg.LibrosWeb.services;

import java.util.List;

import com.ArgProg.LibrosWeb.models.Editorial;

public interface IEditorialService {

	public void guardarEditorial(Editorial editorial);
	public void modificarEditorial(Integer id, Editorial editorial);
	public void borrarEditorial(Editorial editorial);
	public List<Editorial> getAllEditorial();
	public Editorial getEditorialById(Integer Id);
	
}
