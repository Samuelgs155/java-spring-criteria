package com.apring.jpa.criteria.converter;

import com.apring.jpa.criteria.dto.BookDTO;
import com.apring.jpa.criteria.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookConverter {

    public static List<BookDTO> convertToBookDTO(List<Book> books) {
        return books.stream().map(s ->
                BookDTO.builder()
                        .id(s.getId())
                        .title(s.getTitle())
                        .author(s.getAuthor())
                        .build()
        ).collect(Collectors.toList());
    }

    public static Book convertToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }
}
