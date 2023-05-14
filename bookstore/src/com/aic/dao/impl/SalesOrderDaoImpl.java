package com.aic.dao.impl;

import com.aic.dao.SalesOrderDao;
import com.aic.pojo.SalesOrder;
import com.aic.pojo.SalesOrderItem;

import java.util.List;

public class SalesOrderDaoImpl extends BaseDao implements SalesOrderDao {
    @Override
    public int saveOrder(SalesOrder salesOrder) {
        String sql = "insert into t_order_sales(order_id , create_time , user_id , price) values(? , ? , ? , ?)";
        return update(sql,salesOrder.getOrderId(),salesOrder.getCreateTime(),salesOrder.getUserId(),salesOrder.getPrice());
    }

    @Override
    public List<SalesOrder> queryOrders() {
        String sql = "select order_id 'orderId' , create_time 'createTime' , user_id 'userId' , price from t_order_sales";
        return queryForList(SalesOrder.class , sql);
    }

    @Override
    public int deleteOrder(SalesOrder salesOrder) {
        String sql = "delete from t_order_sales where order_id = ?";
        return update(sql , salesOrder.getOrderId());
    }

    @Override
    public List<SalesOrder> queryOrdersByUserId(int userId) {
        String sql = "select order_id 'orderId' , create_time 'createTime' , user_id 'userId' , price from t_order_sales where user_id = ?";
        return queryForList(SalesOrder.class , sql , userId);
    }

    @Override
    public List<SalesOrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select book_id 'bookId' ,count ,  order_id 'orderId' from t_order_sales_item where order_id = ?";
        return queryForList(SalesOrderItem.class , sql , orderId);
    }

    @Override
    public List<SalesOrder> queryOrdersByBookName(Integer bookId) {
        String sql = "select order_id 'orderId' , create_time 'createTime' , user_id 'userId' , price from t_order_sales where order_id in (SELECT order_id FROM t_order_sales_item WHERE book_id = ?)";
        return queryForList(SalesOrder.class , sql , bookId);
    }
}
