package com.book.jpabookproject.Controller;


import com.book.jpabookproject.Entity.Auther;
import com.book.jpabookproject.Entity.AutherSearch;
import com.book.jpabookproject.Service.AutherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auther")
public class AutherController {
    @Autowired
    private AutherService autherService;

    @GetMapping("/{id}")
    public Auther findById(@PathVariable long id) {
        return autherService.findById(id);
    }
    @GetMapping("")
    public List<Auther> findAll() {
        return autherService.findAll();
    }

    @PostMapping
    public Auther insert(@RequestBody @Valid Auther entity) {
        return autherService.insert(entity);
    }
    @PutMapping
    public Auther update(@RequestBody @Valid Auther entity) {
        return autherService.update(entity);
    }

    @DeleteMapping("/{id}")
    public Auther deleteById(@PathVariable long id) {
        return autherService.deleteById(id);
    }
    //@Operation(summary = "Get a book by search ")
    @PostMapping("/spec")
    public ResponseEntity<?> findByAutherSpec(@RequestBody AutherSearch search) {

        return ResponseEntity.ok(autherService.findByAutherSpec(search));
    }
}
