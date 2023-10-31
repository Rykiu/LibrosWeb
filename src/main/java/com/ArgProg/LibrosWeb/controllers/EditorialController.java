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

import com.ArgProg.LibrosWeb.models.Editorial;
import com.ArgProg.LibrosWeb.services.EditorialServiceImpl;

@RestController
@RequestMapping("/editorial")
public class EditorialController {
	
	@Autowired
	private EditorialServiceImpl editorialService;

	@PostMapping("/agregar")
	public ResponseEntity<Object> agregarEditorial(@RequestBody Editorial editorial){
		try {
			editorialService.guardarEditorial(editorial);
			return new ResponseEntity<>("Editorial agregado", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/borrar/{id_editorial}")
	public ResponseEntity<String> borrarEditorial(@PathVariable Integer id_editorial){
		try {
			editorialService.borrarEditorial(editorialService.getEditorialById(id_editorial));
			return new ResponseEntity<>("Se borro el editorial correctamente", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("No se pudo borrar el editorial", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actualizar/{editorial_id}")
	public ResponseEntity<Object> modificarEditorial(@PathVariable Integer editorial_id,@RequestBody Editorial editorial){
		try {
			editorialService.modificarEditorial(editorial_id, editorial);
			return new ResponseEntity<>("Se modifico el editorial correctamente", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("No se pudo modificar el editorial", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Editorial>> getAllEditorial() {
		List<Editorial> allEditorial = editorialService.getAllEditorial();
		if (!allEditorial.isEmpty()) {
			return new ResponseEntity<>(allEditorial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/{editorial_id}")
	public ResponseEntity<Editorial> getLibroById(@PathVariable Integer editorial_id){
		Editorial editorial = editorialService.getEditorialById(editorial_id);
		return new ResponseEntity<>(editorial, HttpStatus.OK);
	}

}
