package com.geekbrains.services;

import com.geekbrains.entities.Book;
import com.geekbrains.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private BooksRepository booksRepository;

    @Autowired
    public void setBooksRepository(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksService() {
    }

    public List<Book> getAllBooksList() {
        return (List<Book>) booksRepository.findAll();
    }

    public void addBook (Book book) {booksRepository.save(book);}
    public void delById (Long Id) {booksRepository.deleteById(Id);}
}
