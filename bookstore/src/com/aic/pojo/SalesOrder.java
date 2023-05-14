package com.aic.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SalesOrder {
    private String orderId;
    private Date createTime;
    private Integer userId;
    private BigDecimal price;
    private String userName;
    private List<SalesOrderItem> salesOrderItemList;

    public SalesOrder() {
    }

    public SalesOrder(String orderId, Date createTime, Integer userId, BigDecimal price, String userName, List<SalesOrderItem> salesOrderItemList) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.userId = userId;
        this.price = price;
        this.userName = userName;
        this.salesOrderItemList = salesOrderItemList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<SalesOrderItem> getSalesOrderItemList() {
        return salesOrderItemList;
    }

    public void setSalesOrderItemList(List<SalesOrderItem> salesOrderItemList) {
        this.salesOrderItemList = salesOrderItemList;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", price=" + price +
                ", userName='" + userName + '\'' +
                ", salesOrderItemList=" + salesOrderItemList +
                '}';
    }
}
