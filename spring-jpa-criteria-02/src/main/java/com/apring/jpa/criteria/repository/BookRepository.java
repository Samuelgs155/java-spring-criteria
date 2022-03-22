package com.apring.jpa.criteria.repository;

import com.apring.jpa.criteria.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>,
        BookCustomRepository, JpaSpecificationExecutor<Book> {
}
