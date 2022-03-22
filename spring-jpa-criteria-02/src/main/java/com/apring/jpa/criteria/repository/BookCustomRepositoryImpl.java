package com.apring.jpa.criteria.repository;

import com.apring.jpa.criteria.model.Book;
import com.apring.jpa.criteria.model.Book_;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookCustomRepositoryImpl implements BookCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> findBooksByAuthorNameAndTitle(String title, String author) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery(Book.class);

        Root<Book> employee=cq.from(Book.class);

        Predicate titlePredicate=cb.equal(employee.get(Book_.TITLE),title);
        Predicate authorPredicate=cb.equal(employee.get(Book_.AUTHOR),author);

        cq.where(titlePredicate,authorPredicate);

        TypedQuery<Book> query=entityManager.createQuery(cq);

        return query.getResultList();
    }
}
