package com.ArgProg.LibrosWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgProg.LibrosWeb.models.Libro;
import com.ArgProg.LibrosWeb.repositories.ILibroRepository;

@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroRepository libroRepository;
	
	@Override
	public void guardarLibro(Libro libro) {
		libroRepository.save(libro);
	}

	@Override
	public void modificarLibro(Integer id, Libro libro) {		
		Libro libroFnd = libroRepository.findById(id).orElse(null);
		if(libroRepository.findById(id) != null) {
			if(libro.getIsbn() != 0) libroFnd.setIsbn(libro.getIsbn());
			if(libro.getTitulo() != null) libroFnd.setTitulo(libro.getTitulo());
			if(libro.getAnio() != 0) libroFnd.setAnio(libro.getAnio());
			if(libro.getEjemplares() !=0) libroFnd.setEjemplares(libro.getEjemplares());
			if(libro.getEjemplaresprestados() != 0) libroFnd.setEjemplaresprestados(libro.getEjemplaresprestados());
			if(libro.getEjemplaresrestantes() != 0) libroFnd.setEjemplaresrestantes(libro.getEjemplaresrestantes());
			libroRepository.save(libroFnd);
		}
	}
	
	@Override
	public void borrarLibro(Libro libro) {
		libroRepository.delete(libro);
	}
		
	@Override
	public void bajaLibro(Libro libro) {
		libro.setAlta(false);
		
	}
	
	@Override
	public void altaLibro(Libro libro) {
		libro.setAlta(true);
	}

	@Override
	public List<Libro> getAllLibros() {
		List<Libro> allLibros = libroRepository.findAll();
		return allLibros;
	}

	@Override
	public Libro getLibroById(Integer id) {
		Libro libro = libroRepository.findById(id).orElse(null);
	    return libro;
	}

	@Override
	public Libro getLibroByIsbn(long isbn) {
		Libro libro = libroRepository.findByIsbn(isbn);
		return libro;
	}

	@Override
	public List <Libro> getLibroByAutor(String autorNombre) {
		List<Libro> libro = libroRepository.findByAutorNombre(autorNombre);
		return libro;
	}

	@Override
	public List <Libro> getLibroByEditorial(String editorialNombre) {
		List<Libro> libro = libroRepository.findByEditorialNombre(editorialNombre);
		return libro;
	}

}
