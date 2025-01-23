package com.example.BookCatalogueSpringBootWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookCatalogueSpringBootWebApp.service.BookService;	
import com.example.BookCatalogueSpringBootWebApp.model.Book;
import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	public BookService bookService;

	@GetMapping("/")  // Responds to HTTP GET requests at the root URL
    public String getAllBooks() {
        List<Book> books = bookService.getAllBooks();
		StringBuffer stringBuffer = new StringBuffer();
		for (Book book : books)
		{
			stringBuffer.append(displayBookString(book));
			stringBuffer.append('\n');
		}

		return stringBuffer.toString();

    }

	@GetMapping("/{id}")
	public String getBookById(@PathVariable("id") Long id) {
		//return bookService.getBookById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		return displayBookString(bookService.getBookById(id).get());
	}


	public String displayBookString(Book book)
	{
		return book.toString();
	}
}
