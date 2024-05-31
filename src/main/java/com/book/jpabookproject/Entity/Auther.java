package com.book.jpabookproject.Entity;

import com.book.jpabookproject.Base.BaseEntity;
import com.book.jpabookproject.Repository.AutherRepo;
import com.book.jpabookproject.Validator.IpAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authers")
public class Auther extends BaseEntity <Long>{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    @NotBlank
    private String autherName;
//    @Pattern(regexp = "[1-9]")
    @IpAddress(message = "should be enter valid ip adress")
    private String ipAdress;
    @Email
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "auther")
    private List<Book> books = new ArrayList<Book>();
    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public String getName() {
        return autherName;
    }

    public void setName(String name) {
        this.autherName = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}