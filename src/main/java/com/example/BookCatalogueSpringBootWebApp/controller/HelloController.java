package com.example.BookCatalogueSpringBootWebApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;	

@RestController
public class HelloController {

	@GetMapping("/")  // Responds to HTTP GET requests at the root URL
    public String start() {
        return "Hello, Spring Boot!";
    }

	@GetMapping("/hello")
	public String hello(){
		return "Hello World";
	}
}
