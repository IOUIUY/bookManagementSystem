package com.aic.pojo;

import java.math.BigDecimal;

public class PurchaseOrderItem {
    private String name;
    private String author;
    private int count;
    private BigDecimal price;
    private BigDecimal salesPrice;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PurchaseOrderItem() {
    }

    public PurchaseOrderItem(String name, String author, int count, BigDecimal price, BigDecimal salesPrice, String orderId) {
        this.name = name;
        this.author = author;
        this.count = count;
        this.price = price;
        this.salesPrice = salesPrice;
        this.orderId = orderId;
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

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
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

    @Override
    public String toString() {
        return "PurchaseOrderItem{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", salesPrice=" + salesPrice +
                ", orderId=" + orderId +
                '}';
    }
}
