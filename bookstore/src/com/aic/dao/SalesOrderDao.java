package com.aic.dao;

import com.aic.pojo.PurchaseOrder;
import com.aic.pojo.PurchaseOrderItem;
import com.aic.pojo.SalesOrder;
import com.aic.pojo.SalesOrderItem;

import java.util.List;

public interface SalesOrderDao {
    public int saveOrder(SalesOrder salesOrder);

    public List<SalesOrder> queryOrders();

    public int deleteOrder(SalesOrder salesOrder);

    public List<SalesOrder> queryOrdersByUserId(int userId);

    public List<SalesOrderItem> queryOrderItemByOrderId(String orderId);

    List<SalesOrder> queryOrdersByBookName(Integer bookId);
}
