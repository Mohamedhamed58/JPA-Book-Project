package com.book.jpabookproject.Entity;

import com.book.jpabookproject.Base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book extends BaseEntity <Long>{
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }
    @NotNull
    private String name;
    @Max(value = 1000)
    @Min(value = 50)
    private double price;
    //@NotNull
    //@JsonIgnore
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "auther_id")
    private Auther auther;

}
