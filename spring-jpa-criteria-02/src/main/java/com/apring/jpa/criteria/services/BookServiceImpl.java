package com.apring.jpa.criteria.services;

import com.apring.jpa.criteria.converter.BookConverter;
import com.apring.jpa.criteria.dto.BookDTO;
import com.apring.jpa.criteria.model.Book;
import com.apring.jpa.criteria.repository.BookCustomRepositoryImpl;
import com.apring.jpa.criteria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCustomRepositoryImpl bookCustomRepositoryImpl;


    @Override
    public void addBook(BookDTO book) {
        bookRepository.save(BookConverter.convertToBook(book));
    }

    @Override
    public List<BookDTO> findBooksByAuthorNameAndTitle(String authorName, String title) {
        List<Book> books = bookCustomRepositoryImpl.findBooksByAuthorNameAndTitle(authorName, title);
        return BookConverter.convertToBookDTO(books);
    }
}
