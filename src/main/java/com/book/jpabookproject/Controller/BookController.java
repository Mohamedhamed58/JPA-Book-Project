package com.book.jpabookproject.Controller;

import com.book.jpabookproject.Entity.Auther;
import com.book.jpabookproject.Entity.Book;
import com.book.jpabookproject.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/book",
        produces = "application/json"
        )

public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return bookService.findById(id);
    }
    @GetMapping("")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping("")
    public void insert(@RequestBody @Valid Book entity) {
        bookService.insert(entity);
    }
    @PutMapping("")
    public void update(@RequestBody @Valid Book entity) {
        bookService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        bookService.deleteById(id);
    }
}
