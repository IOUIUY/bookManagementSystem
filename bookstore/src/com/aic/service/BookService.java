package com.aic.service;

import com.aic.pojo.Book;

import java.util.List;

public interface BookService {
    public List<Book> showAllBooks();

    Book findBookByName(String booName);

    List<Book> findBooksByName(String bookName);

    List<Book> findBooksByAuthor(String author);
}
