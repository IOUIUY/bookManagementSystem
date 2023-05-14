package com.aic.service;

import com.aic.pojo.PurchaseOrder;
import com.aic.pojo.PurchaseOrderItem;
import com.aic.pojo.SalesOrder;
import com.aic.pojo.SalesOrderItem;

import java.util.List;

public interface SalesOrderService {

    public List<SalesOrder> showAllOrder();

    public String createOrder(List<SalesOrderItem> salesOrderItemList, Integer userId , double totalPrice);

    public List<SalesOrderItem> showSalesOrderDetail(String orderId);

    public void createOrderItem(SalesOrderItem salesOrderItem);

    public List<SalesOrder> searchByUser(String name);

    public List<SalesOrder> searchByBookName(String bookName);
}
