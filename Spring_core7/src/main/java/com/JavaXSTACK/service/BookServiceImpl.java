package com.JavaXSTACK.service;

import com.JavaXSTACK.dao.BookDao;
import com.JavaXSTACK.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Qualifier("bookDao")
    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public Book addBook(Book bookAdd) {
        return bookDao.addBook(bookAdd);
    }
    @Override
    @Transactional
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
    @Override
    @Transactional
    public Book updateBook(Book bookUpdate) {
        return bookDao.updateBook(bookUpdate);
    }
    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.listBooks();
    }
    @Override
    @Transactional
    public void deleteBookById(int idRemove) {
        bookDao.deleteBookById(idRemove);
    }
}


