package com.apring.jpa.criteria.controller;

import com.apring.jpa.criteria.dto.BookDTO;
import com.apring.jpa.criteria.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{title}/{author}")
    public List<BookDTO> findAll(@PathVariable("title") String title,
                                 @PathVariable("author") String author){
        return bookService.findBooksByAuthorNameAndTitle(title,author);

    }

    @PostMapping("/book")
    public void addBook(@RequestBody BookDTO book) {
        bookService.addBook(book);
    }
}
