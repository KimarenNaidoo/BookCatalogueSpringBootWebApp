package com.example.BookCatalogueSpringBootWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookCatalogueSpringBootWebApp.service.BookService;	

@RestController
public class BookController {

	@Autowired
	public BookService bookService;

	@GetMapping("/")  // Responds to HTTP GET requests at the root URL
    public String start() {
        return "Hello, Spring Boot!";
    }

	@GetMapping("/books/{id}")
	public String book(@PathVariable("id") Long id) {
		return bookService.getBook(id);
	}
}
