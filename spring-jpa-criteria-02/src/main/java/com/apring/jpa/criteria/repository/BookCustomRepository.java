package com.apring.jpa.criteria.repository;

import com.apring.jpa.criteria.model.Book;

import java.util.List;

public interface BookCustomRepository {
    List<Book> findBooksByAuthorNameAndTitle(String title, String author);
}
