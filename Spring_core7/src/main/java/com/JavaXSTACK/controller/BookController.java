package com.JavaXSTACK.controller;

import com.JavaXSTACK.model.Book;
import com.JavaXSTACK.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.listBooks());
        return "bookList";
    }

    @GetMapping("/books/getBookAddPage")
    public String getBookAddPage(Model model) {
        model.addAttribute("bookSave", new Book());
        return "bookSave";
    }

    @PostMapping("/books")
    public String bookSave(@ModelAttribute Book book, Model model) {
        bookService.addBook(book);
        model.addAttribute("books", bookService.listBooks());
        return "bookList";
    }


    //*****
    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable int id, Model model) {
        model.addAttribute("bookUpdate", bookService.getBookById(id));
        return "update_book";
    }

    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable int id,
                              @ModelAttribute("books") Book book, Model model) {
        Book exitBook = bookService.getBookById(id);
        exitBook.setId(id);
        exitBook.setBookAuthor(book.getBookAuthor());
        exitBook.setPrice(book.getPrice());

        bookService.updateBook(exitBook);
        return "bookList";
    }
}


