package com.aic.dao.impl;

import com.aic.dao.SalesOrderItemDao;
import com.aic.pojo.SalesOrderItem;

import java.util.List;

public class SalesOrderItemDaoImpl extends BaseDao implements SalesOrderItemDao {
    @Override
    public int saveOrderItem(SalesOrderItem salesOrderItem) {
        String sql = "insert into t_order_sales_item(book_id , count , order_id) values(? , ? , ?)";
        return update(sql , salesOrderItem.getBookId() , salesOrderItem.getCount() , salesOrderItem.getOrderId());
    }

    @Override
    public List<SalesOrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select book_id 'bookId' , count , order_id 'orderId' from t_order_sales_item where order_id = ?";
        return queryForList(SalesOrderItem.class,sql,orderId);
    }
}
