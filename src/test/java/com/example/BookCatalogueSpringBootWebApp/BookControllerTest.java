package com.example.BookCatalogueSpringBootWebApp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.BookCatalogueSpringBootWebApp.service.BookService;
import com.example.BookCatalogueSpringBootWebApp.controller.BookController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(BookController.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BookControllerTest {

    private final String apiEndpoint = "/api/books/";
    private final String getBooksEndpointResponseString = "<h3>Book Id: 1</h3> <ul><li>Title: The Alchemist.</li> <li>Author: Paulo Coelho.</li> <li>Category: Fiction.</li> <li>Status: Finished.</li> <li>Ownership: Unown.</li></ul>";

    @Autowired
    private MockMvc mockMvc;

    BookService mockService = Mockito.mock(BookService.class);
    BookController controller = new BookController();

    @Test
    public void testGetAllBooksEndpoint() throws Exception {
        mockMvc.perform(get(apiEndpoint)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(getBooksEndpointResponseString)));
    }

    @Test 
    public void testGetBookByIdEndpoint() throws Exception {
        mockMvc.perform(get(apiEndpoint + "{id}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(getBooksEndpointResponseString));
    }

}
