package com.aic.dao;

import com.aic.pojo.PurchaseOrderItem;

import java.util.List;

public interface PurchaseOrderItemDao {
    public int saveOrderItem(PurchaseOrderItem purchaseOrderItem);

    public List<PurchaseOrderItem> queryOrderItemsByOderId(String orderId);
}
