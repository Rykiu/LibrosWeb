package com.ArgProg.LibrosWeb.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgProg.LibrosWeb.models.Libro;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {
	Libro findByIsbn(long isbn);
	List<Libro> findByAutorNombre(String autorNombre);
	List<Libro> findByEditorialNombre(String editorialNombre);
	
}
