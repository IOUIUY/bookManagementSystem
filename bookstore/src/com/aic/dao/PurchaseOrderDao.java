package com.aic.dao;

import com.aic.pojo.PurchaseOrder;
import com.aic.pojo.PurchaseOrderItem;

import java.util.List;

public interface PurchaseOrderDao {
    public int saveOrder(PurchaseOrder purchaseOrder);

    public  List<PurchaseOrder> queryOrders();

    public int deleteOrder(PurchaseOrder purchaseOrder);

    public List<PurchaseOrder> queryOrdersByUserId(int userId);

    public List<PurchaseOrderItem> queryOrderItemByOrderId(String orderId);

    List<PurchaseOrder> queryOrdersByBookName(String bookName);
}
