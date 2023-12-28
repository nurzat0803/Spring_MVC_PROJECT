package com.JavaXSTACK.dao;

import com.JavaXSTACK.model.Book;

import java.util.List;

public interface BookDao {
    public Book addBook(Book bookAdd);
    public Book getBookById(int idGet);
    public Book updateBook(Book book);
    public List<Book> listBooks();
    public void deleteBookById(int idRemove);

}
