package com.ArgProg.LibrosWeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ArgProg.LibrosWeb.models.Libro;
import com.ArgProg.LibrosWeb.services.LibroServiceImpl;

@RestController
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroServiceImpl libroService;

	@PostMapping("/agregar")
	public ResponseEntity<Object> agregarLibro(@RequestBody Libro libro){
		try {
			libroService.guardarLibro(libro);
			return new ResponseEntity<>("Libro agregado", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/borrar/{id_libro}")
	public ResponseEntity<String> borrarLibro(@PathVariable Integer id_libro){
		try {
			libroService.borrarLibro(libroService.getLibroById(id_libro));
			return new ResponseEntity<>("Se borro el libro correctamente", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("No se pudo borrar el libro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actualizar/{libro_id}")
	public ResponseEntity<Object> modificarLibro(@PathVariable Integer libro_id,@RequestBody Libro libro){
		try {
			libroService.modificarLibro(libro_id, libro);
			return new ResponseEntity<>("Se modifico el libro correctamente", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("No se pudo modificar el libro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Libro>> getAllLibros() {
		List<Libro> allLibros = libroService.getAllLibros();
		if (!allLibros.isEmpty()) {
			return new ResponseEntity<>(allLibros, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/{libro_id}")
	public ResponseEntity<Libro> getLibroById(@PathVariable Integer libro_id){
		Libro libro = libroService.getLibroById(libro_id);
		return new ResponseEntity<>(libro, HttpStatus.OK);
	}
	
	@GetMapping("/isbn/{libro_isbn}")
	public ResponseEntity<Object> getLibroByIsbn(@PathVariable long libro_isbn){
		Libro libro = libroService.getLibroByIsbn(libro_isbn);
		if (libro != null) {
			return new ResponseEntity<>(libro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontro el libro", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/autor/{libro_autor}")
	public ResponseEntity<Object> getLibroByAutor(@PathVariable String libro_autor){
		List<Libro> libro = libroService.getLibroByAutor(libro_autor);
		
		if (!libro.isEmpty()) {
			return new ResponseEntity<>(libro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontro el libro", HttpStatus.OK);
		}
	}
	
	@GetMapping("/editorial/{libro_editorial}")
	public ResponseEntity<Object> getLibroByEditorial(@PathVariable String libro_editorial){
		List<Libro> libro = libroService.getLibroByEditorial(libro_editorial);
		
		if (!libro.isEmpty()) {
			return new ResponseEntity<>(libro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontro el libro", HttpStatus.OK);
		}
	}
	
	@PostMapping("/baja/{libro_id}")
	public ResponseEntity<Object> getLibroBaja(@PathVariable Integer libro_id){
		Libro libro = libroService.getLibroById(libro_id);
		
		if (libro != null) {
			libroService.bajaLibro(libro);
			return new ResponseEntity<>(String.format("Libro de alta: %b", libro.isAlta()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontro el libro", HttpStatus.OK);
		}
	}
	
	@PostMapping("/alta/{libro_id}")
	public ResponseEntity<Object> getLibroAlta(@PathVariable Integer libro_id){
		Libro libro = libroService.getLibroById(libro_id);
		
		if (libro != null) {
			libroService.altaLibro(libro);
			return new ResponseEntity<>(String.format("Libro de alta: %b", libro.isAlta()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontro el libro", HttpStatus.OK);
		}
	}
}
