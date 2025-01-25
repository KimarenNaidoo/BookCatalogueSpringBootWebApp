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

	@Autowired
	public BookService bookService;

	@GetMapping("/")
    public String getAllBooks() {
        List<Book> books = bookService.getAllBooks();
		StringBuffer stringBuffer = new StringBuffer();
		for (Book book : books)
		{
			stringBuffer.append(displayBookString(book));
			stringBuffer.append("<br>");
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
		return String.format("Book id: %d, title: %s, author: %s, category: %d, status: %d, ownership: %d.", book.getId(), book.getTitle(), book.getAuthor(), book.getCategoryId(), book.getStatusId(), book.getOwnershipId());
	}
}
