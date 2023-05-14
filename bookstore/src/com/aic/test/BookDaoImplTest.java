package com.aic.test;

import com.aic.dao.BookDao;
import com.aic.dao.impl.BookDaoImpl;
import com.aic.pojo.Book;
import com.aic.utils.JdbcUtils;

import java.math.BigDecimal;
import java.util.List;


class BookDaoImplTest {

    BookDao bookDao = new BookDaoImpl();

    @org.junit.jupiter.api.Test
    void addBook() {
        System.out.println(bookDao.addBook(new Book(null , "add", "dashi", 999 , new BigDecimal(24))));
        JdbcUtils.commitAndClose();
    }

    @org.junit.jupiter.api.Test
    void deleteBookById() {
        System.out.println(bookDao.deleteBookById(5));
    }

    @org.junit.jupiter.api.Test
    void updateBook() {
        System.out.println(bookDao.updateBook(new Book(5, "add", "dass", 9999 , new BigDecimal(25))));
    }

    @org.junit.jupiter.api.Test
    void queryBookByName() {
        System.out.println(bookDao.queryBookByName("dj"));
    }

    @org.junit.jupiter.api.Test
    void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        System.out.println(books);
    }
}