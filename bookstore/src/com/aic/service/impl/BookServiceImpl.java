package com.aic.service.impl;

import com.aic.dao.BookDao;
import com.aic.dao.impl.BookDaoImpl;
import com.aic.pojo.Book;
import com.aic.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> showAllBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Book findBookByName(String booName) {
        return bookDao.queryBookByName(booName);
    }

    @Override
    public List<Book> findBooksByName(String bookName) {
        return bookDao.queryBooksByName(bookName);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookDao.queryBooksByAuthor(author);
    }
}
