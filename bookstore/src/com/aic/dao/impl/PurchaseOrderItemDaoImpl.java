package com.aic.dao.impl;

import com.aic.dao.PurchaseOrderItemDao;
import com.aic.pojo.PurchaseOrderItem;

import java.util.List;

public class PurchaseOrderItemDaoImpl extends BaseDao implements PurchaseOrderItemDao {
    @Override
    public int saveOrderItem(PurchaseOrderItem purchaseOrderItem) {
        String sql = "insert into t_order_purchase_item(name , count , purchase_price , order_id) values(? , ? , ? , ?)";
        return update(sql, purchaseOrderItem.getName(), purchaseOrderItem.getCount(), purchaseOrderItem.getPrice(), purchaseOrderItem.getOrderId());
    }

    @Override
    public List<PurchaseOrderItem> queryOrderItemsByOderId(String orderId) {
        String sql = "select id , name , count , purchase_price 'price', order_id 'orderId' from t_order_purchase_item where order_id = ?";
        return queryForList(PurchaseOrderItem.class , sql , orderId);
    }
}
