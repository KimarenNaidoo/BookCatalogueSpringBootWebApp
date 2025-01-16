package com.example.BookCatalogueSpringBootWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;	

@SpringBootApplication
public class BookCatalogueSpringBootWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogueSpringBootWebAppApplication.class, args);
	}

}

@RestController
class HelloController {

	@GetMapping("/")  // Responds to HTTP GET requests at the root URL
    public String start() {
        return "Hello, Spring Boot!";
    }

	@GetMapping("/hello")
	public String hello(){
		return "Hello World";
	}
}