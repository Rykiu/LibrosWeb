package com.ArgProg.LibrosWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LibrosWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrosWebApplication.class, args);
	}

}
