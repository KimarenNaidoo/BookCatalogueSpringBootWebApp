package com.example.BookCatalogueSpringBootWebApp;

import com.example.BookCatalogueSpringBootWebApp.repository.BookRepository;
import com.example.BookCatalogueSpringBootWebApp.service.BookService;
import com.example.BookCatalogueSpringBootWebApp.model.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(BookService.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> expectedBooks = mockBooks();
        when(bookRepository.loadBooksFromRepository()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.getAllBooks();
        assertEquals(expectedBooks, actualBooks);
        //verify(bookRepository).loadBooksFromRepository();
    }


    private List<Book> mockBooks() {
        List<Book> mockBooks = new ArrayList<>();

        Book book1 = new Book(1, "The Alchemist", 2, 3, "Paulo Coelho", 0);
        Book book2 = new Book(2, "Life 3.0", 2, 1, "Max Tegmark", 3);

        mockBooks.add(book1);
        mockBooks.add(book2);

        return mockBooks;

    }
    
}
