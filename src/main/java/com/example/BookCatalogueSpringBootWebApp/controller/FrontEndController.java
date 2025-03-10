package com.example.BookCatalogueSpringBootWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }
}
