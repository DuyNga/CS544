package edu.mum.cs544.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    public Book(String title, String ISBN, String author, double price) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
    }
    @org.hibernate.validator.constraints.ISBN
    private String ISBN;
    @NotEmpty
    private String author;
    @Positive
    private double price;
}
