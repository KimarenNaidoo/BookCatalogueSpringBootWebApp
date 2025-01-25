package com.example.BookCatalogueSpringBootWebApp.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.example.BookCatalogueSpringBootWebApp.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;  

@Service
public class BookService {

    private List<Book> books;
    private final ObjectMapper objectMapper;

    public BookService() {
        this.objectMapper = new ObjectMapper();
        loadBooksFromJson();
    }

    private void loadBooksFromJson() {
        try {
            ClassPathResource resource = new ClassPathResource("booksData.json");
            String jsonContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
            Map<String, List<Book>> booksMap = objectMapper.readValue(jsonContent, new TypeReference<Map<String, List<Book>>>() {}
            );
            
            this.books = booksMap.get("books");
        }
        catch (IOException e) {
            this.books = new ArrayList<>();
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }
    
}
