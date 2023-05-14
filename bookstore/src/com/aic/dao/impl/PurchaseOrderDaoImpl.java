package com.aic.dao.impl;

import com.aic.dao.PurchaseOrderDao;
import com.aic.pojo.PurchaseOrder;
import com.aic.pojo.PurchaseOrderItem;

import java.util.List;

public class PurchaseOrderDaoImpl extends BaseDao implements PurchaseOrderDao {
    @Override
    public int saveOrder(PurchaseOrder purchaseOrder) {
        String sql = "insert into t_order_purchase(order_id , create_time , user_id , price) values(? , ? , ? , ?)";
        return update(sql,purchaseOrder.getOrderId(),purchaseOrder.getCreateTime(),purchaseOrder.getUserId(),purchaseOrder.getPrice());
    }

    @Override
    public List<PurchaseOrder> queryOrders() {
        String sql = "select order_id 'orderId' , create_time 'createTime' , user_id 'userId' , price from t_order_purchase";
        return queryForList(PurchaseOrder.class , sql);
    }

    @Override
    public int deleteOrder(PurchaseOrder purchaseOrder) {
        String sql = "delete from t_order_purchase where order_id = ?";
        return update(sql , purchaseOrder.getOrderId());
    }

    @Override
    public List<PurchaseOrder> queryOrdersByUserId(int userId) {
        String sql = "select order_id 'orderId' , create_time 'createTime' , user_id 'userId' , price from t_order_purchase where user_id = ?";
        return queryForList(PurchaseOrder.class , sql , userId);
    }

    @Override
    public List<PurchaseOrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select name , count , purchase_price 'price' , order_id 'orderId' from t_order_purchase_item where order_id = ?";
        return queryForList(PurchaseOrderItem.class , sql , orderId);
    }

    @Override
    public List<PurchaseOrder> queryOrdersByBookName(String bookName) {
        String sql = "select order_id 'orderId' , create_time 'createTime' , user_id 'userId' , price from t_order_purchase where order_id in (SELECT order_id FROM t_order_purchase_item WHERE name = ?)";
        return queryForList(PurchaseOrder.class , sql , bookName);
    }
}
