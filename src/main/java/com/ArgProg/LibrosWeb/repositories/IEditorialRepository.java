package com.ArgProg.LibrosWeb.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgProg.LibrosWeb.models.Editorial;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, Integer>{
}
