package com.example.BookCatalogueSpringBootWebApp.service;

import org.springframework.stereotype.Service;

import com.example.BookCatalogueSpringBootWebApp.model.Book;
import com.example.BookCatalogueSpringBootWebApp.repository.BookRepository;

import java.util.List;
import java.util.Optional;  

@Service
public class BookService {

    private List<Book> books;
    private final BookRepository bookRepository;

    public BookService() {
        bookRepository = new BookRepository();
        this.books = bookRepository.loadBooksFromRepository();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }
    
}
