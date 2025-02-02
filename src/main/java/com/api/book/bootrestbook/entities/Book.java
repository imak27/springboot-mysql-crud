package com.api.book.bootrestbook.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")

public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private int id;

    private String title;

    @OneToOne
    private Author author;
    
    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
    public Book() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public Author getAuthor() {
        return author;
    }
}
