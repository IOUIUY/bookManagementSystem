package com.aic.pojo;

import java.math.BigDecimal;

public class SalesOrderItem {
    private String name;
    private String author;
    private int count;
    private BigDecimal price;
    private String orderId;
    private Integer bookId;

    public SalesOrderItem() {
    }

    public SalesOrderItem(String name, String author, int count, BigDecimal price, String orderId, Integer bookId) {
        this.name = name;
        this.author = author;
        this.count = count;
        this.price = price;
        this.orderId = orderId;
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "SalesOrderItem{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", orderId='" + orderId + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
