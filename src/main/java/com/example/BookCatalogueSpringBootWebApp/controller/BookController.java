package com.example.BookCatalogueSpringBootWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	public BookService bookService = new BookService();

	@GetMapping("/")
    public String getAllBooks() {
        List<Book> books = bookService.getAllBooks();
		StringBuffer stringBuffer = new StringBuffer();
		for (Book book : books)
		{
			stringBuffer.append(book.displayBookString());
			stringBuffer.append("<br>");
		}

		return stringBuffer.toString();
    }

	@GetMapping("/{id}")
	public String getBookById(@PathVariable("id") Long id) {
		Book book = bookService.getBookById(id).get();
		return book.displayBookString();
	}


	
}
