package com.ArgProg.LibrosWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgProg.LibrosWeb.models.Editorial;
import com.ArgProg.LibrosWeb.repositories.IEditorialRepository;

@Service
public class EditorialServiceImpl implements IEditorialService{
	
	@Autowired
	private IEditorialRepository editorialRepository;
	
	@Override
	public void guardarEditorial(Editorial editorial) {
		editorialRepository.save(editorial);
	}

	@Override
	public void modificarEditorial(Integer id, Editorial editorial) {
		Editorial editorialFnd = editorialRepository.findById(id).orElse(null);
		if(editorialRepository.findById(id) != null) {
			if(editorial.getNombre() != null) editorialFnd.setNombre(editorial.getNombre());
			editorialRepository.save(editorialFnd);
		}
	}

	@Override
	public void borrarEditorial(Editorial editorial) {
		editorialRepository.delete(editorial);
	}

	@Override
	public List<Editorial> getAllEditorial() {
		List<Editorial> allEditorial = editorialRepository.findAll();
		return allEditorial;
	}

	@Override
	public Editorial getEditorialById(Integer id) {
		Editorial editorial = editorialRepository.findById(id).orElse(null);
	    return editorial;
	}
	
	
	
}
