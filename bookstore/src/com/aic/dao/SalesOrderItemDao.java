package com.aic.dao;

import com.aic.pojo.SalesOrderItem;

import java.util.List;

public interface SalesOrderItemDao {
    public int saveOrderItem(SalesOrderItem salesOrderItem);

    public List<SalesOrderItem> queryOrderItemsByOrderId(String orderId);
}
