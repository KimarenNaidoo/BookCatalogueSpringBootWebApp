package com.example.BookCatalogueSpringBootWebApp.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public String getBook(Long id) {
        return "Book " + id;
    }
    
}
