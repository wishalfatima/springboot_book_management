package com.bookapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotNull(message = "Genre is required")
    @ManyToOne(optional = false)
    private Genre genre;

    @NotNull(message = "Publisher is required")
    @ManyToOne(optional = false)
    private Publisher publisher;



// Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}

