package com.geekbrains.controllers;

import com.geekbrains.entities.Book;
import com.geekbrains.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("/list")
    public String showBooksList(Model model) {
        List<Book> allBooks = booksService.getAllBooksList();
        model.addAttribute("booksList", allBooks);
        return "books-list";
    }

//    @RequestMapping("/books/add")
    @RequestMapping(path="/add", method= RequestMethod.POST)
    public String showAddForm(Book book) {
        booksService.addBook(book);
        return "redirect:/books/list";
    }

    @Secured({"ROLE_ADMIN"})
    @ResponseBody
    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add-book-form";
    }

    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long bookId) {
        booksService.delById(bookId);
        return "redirect:/students/list";
    }
}
