package com.aic.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// 进货订单的 javaBean
public class PurchaseOrder {
    private String orderId;
    private Date createTime;
    private Integer userId;
    private BigDecimal price;
    private String userName;
    private List<PurchaseOrderItem> purchaseOrderItemList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PurchaseOrder() {
    }

    public PurchaseOrder(String orderId, Date createTime, Integer userId, BigDecimal price, List<PurchaseOrderItem> purchaseOrderItemList) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.userId = userId;
        this.price = price;
        this.purchaseOrderItemList = purchaseOrderItemList;
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

    public List<PurchaseOrderItem> getPurchaseOrderItemList() {
        return purchaseOrderItemList;
    }

    public void setPurchaseOrderItemList(List<PurchaseOrderItem> purchaseOrderItemList) {
        this.purchaseOrderItemList = purchaseOrderItemList;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", price=" + price +
                ", purchaseOrderItemList=" + purchaseOrderItemList +
                '}';
    }
}
