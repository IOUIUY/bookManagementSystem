package com.aic.dao;

import com.aic.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookByName(String name);

    public Book queryBookById(Integer book_id);

    public List<Book> queryBooks();

    List<Book> queryBooksByName(String bookName);

    List<Book> queryBooksByAuthor(String author);

    //Integer queryForPageTotalCount();

    //List<Book> queryForPageItems(int begin , int pageSize);

    //Integer queryForPageTotalCountByPrice(int min , int max);

    //List<Book> queryForPageItemsByPrice(int begin , int pageSize , int min , int max);
}
