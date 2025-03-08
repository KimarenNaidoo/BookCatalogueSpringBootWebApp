package com.example.BookCatalogueSpringBootWebApp;

import com.example.BookCatalogueSpringBootWebApp.repository.BookRepository;
import com.example.BookCatalogueSpringBootWebApp.service.BookService;
import com.example.BookCatalogueSpringBootWebApp.model.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Book> actualBooks = new ArrayList<>();
        actualBooks.add(bookService.getAllBooks().get(0));
        actualBooks.add(bookService.getAllBooks().get(1));

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    public void testGetBookById() throws Exception {
        List<Book> expectedBooks = mockBooks();
        when(bookRepository.loadBooksFromRepository()).thenReturn(expectedBooks);

        Book actualBook = bookService.getBookById(1L).get();
        Book expectedBook = expectedBooks.stream().filter(b -> b.getId() == 1L).collect(Collectors.toList()).get(0);

        assertEquals(expectedBook, actualBook);
    }

    private List<Book> mockBooks() {
        List<Book> mockBooks = new ArrayList<>();

        Book book1 = new Book(1, "The Alchemist", 2, 3, "Paulo Coelho", 0, "978-0-14-310565-5", LocalDate.of(2023, 01, 01));
        Book book2 = new Book(2, "Life 3.0", 2, 1, "Max Tegmark", 3, "978-0-14-310565-5", LocalDate.of(2024, 05, 29));

        mockBooks.add(book1);
        mockBooks.add(book2);  

        return mockBooks;

    }
    
}
