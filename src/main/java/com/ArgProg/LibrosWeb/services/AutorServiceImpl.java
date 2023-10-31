package com.ArgProg.LibrosWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgProg.LibrosWeb.models.Autor;
import com.ArgProg.LibrosWeb.repositories.IAutorRepository;

@Service
public class AutorServiceImpl implements IAutorService{
	
	@Autowired
	private IAutorRepository autorRepository;
	
	@Override
	public void guardarAutor(Autor autor) {
		autorRepository.save(autor);
	}

	@Override
	public void modificarAutor(Integer id, Autor autor) {
		Autor autorFnd = autorRepository.findById(id).orElse(null);
		if(autorRepository.findById(id) != null) {
			if(autor.getNombre() != null) autorFnd.setNombre(autor.getNombre());
			autorRepository.save(autorFnd);
		}
	}

	@Override
	public void borrarAutor(Autor autor) {
		autorRepository.delete(autor);
	}

	@Override
	public List<Autor> getAllAutor() {
		List<Autor> allAutor = autorRepository.findAll();
		return allAutor;
	}

	@Override
	public Autor getAutorById(Integer id) {
		Autor autor = autorRepository.findById(id).orElse(null);
	    return autor;
	}
	
	
	
}
