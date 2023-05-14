package com.aic.service.impl;

import com.aic.dao.BookDao;
import com.aic.dao.SalesOrderDao;
import com.aic.dao.SalesOrderItemDao;
import com.aic.dao.UserDao;
import com.aic.dao.impl.BookDaoImpl;
import com.aic.dao.impl.SalesOrderDaoImpl;
import com.aic.dao.impl.SalesOrderItemDaoImpl;
import com.aic.dao.impl.UserDaoImpl;
import com.aic.pojo.*;
import com.aic.service.SalesOrderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SalesOrderServiceImpl implements SalesOrderService {

    SalesOrderDao salesOrderDao = new SalesOrderDaoImpl();
    SalesOrderItemDao salesOrderItemDao = new SalesOrderItemDaoImpl();
    UserDao userDao = new UserDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    @Override
    public List<SalesOrder> showAllOrder() {
        List<SalesOrder> salesOrders = salesOrderDao.queryOrders();
        for(SalesOrder item : salesOrders){
            item.setUserName(userDao.queryUserByUserId(item.getUserId()).getUsername());
        }
        return salesOrders;
    }

    @Override
    public String createOrder(List<SalesOrderItem> salesOrderItemList, Integer userId, double totalPrice) {
        //        订单号，唯一性
        String orderId = "" + System.currentTimeMillis() + userId;

//        创建订单对象
        SalesOrder salesOrder = new SalesOrder(orderId,new Date() , userId , new BigDecimal(totalPrice),null,salesOrderItemList);
        salesOrderDao.saveOrder(salesOrder);
//        遍历购物车中的每一个商品项，转为 OrderItem 保存在数据库中
        for (SalesOrderItem item : salesOrderItemList){
            item.setOrderId(orderId);
            salesOrderItemDao.saveOrderItem(item);
            Book book;
            book = bookDao.queryBookByName(item.getName());
            book.setStock(book.getStock() - item.getCount());
            bookDao.updateBook(book);
        }
        return orderId;
    }

    @Override
    public List<SalesOrderItem> showSalesOrderDetail(String orderId) {
        List<SalesOrderItem> salesOrderItemList = salesOrderItemDao.queryOrderItemsByOrderId(orderId);
        for(SalesOrderItem item : salesOrderItemList){
            Book book = bookDao.queryBookById(item.getBookId());
            item.setAuthor(book.getAuthor());
            item.setName(book.getName());
            item.setPrice(book.getPrice());
        }
        return salesOrderItemList;
    }

    @Override
    public void createOrderItem(SalesOrderItem salesOrderItem) {
        Book book = bookDao.queryBookByName(salesOrderItem.getName());
        salesOrderItem.setBookId(book.getId());
        salesOrderItem.setPrice(new BigDecimal((book.getPrice().doubleValue() * salesOrderItem.getCount())));
    }

    @Override
    public List<SalesOrder> searchByBookName(String bookName) {
        List<SalesOrder> salesOrders = salesOrderDao.queryOrdersByBookName(bookDao.queryBookByName(bookName).getId());
        for(SalesOrder item : salesOrders){
            item.setUserName(userDao.queryUserByUserId(item.getUserId()).getUsername());
        }
        return salesOrders;
    }

    @Override
    public List<SalesOrder> searchByUser(String name) {
        User user = userDao.queryUserBuUsername(name);
        // 输入的管理员不存在
        if(user == null){
            return null;
        }
        List<SalesOrder> salesOrders = salesOrderDao.queryOrdersByUserId(user.getId());
        for(SalesOrder item : salesOrders){
            item.setUserName(userDao.queryUserByUserId(item.getUserId()).getUsername());
        }
        return salesOrders;
    }
}
