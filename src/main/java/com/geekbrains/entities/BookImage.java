package com.geekbrains.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books_images")
@Data
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "path")
    private String path;
}
