package com.book.jpabookproject.Repository;

import com.book.jpabookproject.Entity.Auther;
import com.book.jpabookproject.Entity.AutherSearch;
import com.book.jpabookproject.Entity.Book;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

public class AutherSpec implements Specification {
    private AutherSearch search;

    public AutherSpec(AutherSearch search) {
        this.search=search;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
        Join<Auther, Book> bookJoin = root.join("books", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        // auther name
        if (search.getAuthorName() != null && !search.getAuthorName().isEmpty()) {
            predicates.add(cb.equal(root.get("name"), search.getAuthorName()));
        }

        // email
        if (search.getEmail() != null && !search.getEmail().isEmpty()) {
            predicates.add(cb.like(root.get("email"), search.getEmail()));
        }

        // ipAdress
        if (search.getIpAdress() != null && !search.getIpAdress().isEmpty()) {
            predicates.add(cb.like(root.get("ipAddress"), "%" + search.getIpAdress() + "%" ));
        }

        //book name
        if (search.getBookName()!=null && !search.getBookName().isEmpty()) {
            predicates.add(cb.like(bookJoin.get("name"), "%" + search.getBookName()+ "%" ));
        }

        //book price
        if (search.getPrice()!=null) {
            predicates.add(cb.equal(bookJoin.get("price"), search.getPrice()));
        }

        query.orderBy(cb.desc(root.get("id")));
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
