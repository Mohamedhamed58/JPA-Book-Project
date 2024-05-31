package com.book.jpabookproject.Config;


import com.book.jpabookproject.Entity.Auther;
import com.book.jpabookproject.Entity.Book;
import com.book.jpabookproject.Service.AutherService;
import com.book.jpabookproject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class StartUpApp implements CommandLineRunner {

    @Autowired
    private BookService bookService;
    @Autowired
    private AutherService autherService;
    @Override
    public void run(String... args) throws Exception {
        if(bookService.findAll().isEmpty()) {
            Book book1 = new Book();
            book1.setName("Java");
            book1.setPrice(200);
            //book1.setAuther(autherService.findById(1L));
            // bookService.insert(book1);

            Book book2 = new Book();
            book2.setName("JavaScript");
            book2.setPrice(300);
            //book2.setAuther(autherService.findById(2L));
            // bookService.insert(book2);

            Book book3 = new Book();
            book3.setName("Python");
            book3.setPrice(400);
            //book3.setAuther(autherService.findById(3L));
            // bookService.insert(book3);

            bookService.insertAll(Arrays.asList(book1, book2, book3));
        }
        if(autherService.findAll().isEmpty()) {
            Auther auther1 = new Auther();
            auther1.setName("ALi");
            //autherService.insert(auther1);

            Auther auther2 = new Auther();
            auther2.setName("Mohamed");
            //autherService.insert(auther2);

            Auther auther3 = new Auther();
            auther3.setName("Ahmed");
            //autherService.insert(auther3);

            //autherService.update(auther1);
            autherService.insertAll(Arrays.asList(auther1, auther2, auther3));
        }
    }
}

