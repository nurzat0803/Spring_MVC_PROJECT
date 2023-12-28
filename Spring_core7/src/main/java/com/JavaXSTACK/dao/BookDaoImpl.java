package com.JavaXSTACK.dao;

import com.JavaXSTACK.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public BookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book addBook(Book bookSave) {
        Session session = sessionFactory.openSession();
        session.save(bookSave);
        session.close();
        return bookSave;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book getBookById(int id) {
        Session session = sessionFactory.openSession();
        Book bookGet = (Book) session.get(Book.class, new int(id));
        return bookGet;
    }

    @Override
    public Book updateBook(Book bookUpdate) {
        Session session = sessionFactory.openSession();
        session.update(bookUpdate);
        session.close();
        return bookUpdate;
    }

    @Override
    public List<Book> listBooks() {
        Session session = sessionFactory.openSession();
        List<Book> bookList = session.createQuery("from Book").list();
        session.close();
        return bookList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteBookById(int idRemove) {
        Session session = sessionFactory.openSession();
        Book bookRemove = (Book) session.get(Book.class, new int(idRemove));
        if (null != bookRemove) {
            session.delete(bookRemove);
        }
    }
}

