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

import com.ArgProg.LibrosWeb.models.Autor;
import com.ArgProg.LibrosWeb.services.AutorServiceImpl;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorServiceImpl autorService;

	@PostMapping("/agregar")
	public ResponseEntity<Object> agregarAutor(@RequestBody Autor autor){
		try {
			autorService.guardarAutor(autor);
			return new ResponseEntity<>("Autor agregado", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/borrar/{id_autor}")
	public ResponseEntity<String> borrarAutor(@PathVariable Integer id_autor){
		try {
			autorService.borrarAutor(autorService.getAutorById(id_autor));
			return new ResponseEntity<>("Se borro el autor correctamente", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("No se pudo borrar el autor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actualizar/{autor_id}")
	public ResponseEntity<Object> modificarAutor(@PathVariable Integer autor_id,@RequestBody Autor autor){
		try {
			autorService.modificarAutor(autor_id, autor);
			return new ResponseEntity<>("Se modifico el autor correctamente", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("No se pudo modificar el autor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Autor>> getAllAutor() {
		List<Autor> allAutor = autorService.getAllAutor();
		if (!allAutor.isEmpty()) {
			return new ResponseEntity<>(allAutor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/{autor_id}")
	public ResponseEntity<Autor> getLibroById(@PathVariable Integer autor_id){
		Autor autor = autorService.getAutorById(autor_id);
		return new ResponseEntity<>(autor, HttpStatus.OK);
	}

}
