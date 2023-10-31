package com.ArgProg.LibrosWeb.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgProg.LibrosWeb.models.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer>{
}
