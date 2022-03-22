package com.apring.jpa.criteria.services;

import com.apring.jpa.criteria.dto.BookDTO;

import java.util.List;

public interface BookService {

    void addBook(BookDTO book);
    List<BookDTO> findBooksByAuthorNameAndTitle(String authorName, String title);
}
