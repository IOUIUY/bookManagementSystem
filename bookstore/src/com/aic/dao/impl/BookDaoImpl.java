package com.aic.dao.impl;

import com.aic.dao.BookDao;
import com.aic.pojo.Book;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(name,author,stock,price) VALUES(?,?,?,?)";
        return update(sql , book.getName(),book.getAuthor(),book.getStock(),book.getPrice());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name` = ?,`author` = ?,`stock` = ? where id = ?";
        return update(sql , book.getName(),book.getAuthor(),book.getStock(),book.getId());
    }

    @Override
    public Book queryBookByName(String name) {
        String sql = "select id , name , author , stock , price from t_book where name = ?";
        return queryForOne(Book.class , sql , name);
    }

    @Override
    public Book queryBookById(Integer book_id) {
        String sql = "select id , name , author , stock , price from t_book where id = ?";
        return queryForOne(Book.class , sql , book_id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `stock` ,price from t_book";
        return queryForList(Book.class , sql);
    }

    @Override
    public List<Book> queryBooksByName(String bookName) {
        String sql = "select id , name , author , stock , price from t_book where name = ?";
        return queryForList(Book.class , sql , bookName);
    }

    @Override
    public List<Book> queryBooksByAuthor(String author) {
        String sql = "select id , name , author , stock , price from t_book where author = ?";
        return queryForList(Book.class , sql , author);
    }
}
