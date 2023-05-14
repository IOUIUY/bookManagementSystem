package com.aic.service;


import com.aic.pojo.PurchaseOrder;
import com.aic.pojo.PurchaseOrderItem;

import java.util.List;

public interface PurchaseOrderService {
    public String createOrder(List<PurchaseOrderItem> purchaseOrderItemList, Integer userId , double totalPrice);

    public List<PurchaseOrder> showAllOrder();

    public List<PurchaseOrderItem> showPurchaseOrderDetail(String orderId);

    public List<PurchaseOrder> searchByUser(String name);

    public List<PurchaseOrder> searchByBookName(String bookName);
}
