package com.aic.service.impl;

import com.aic.dao.BookDao;
import com.aic.dao.PurchaseOrderDao;
import com.aic.dao.PurchaseOrderItemDao;
import com.aic.dao.UserDao;
import com.aic.dao.impl.BookDaoImpl;
import com.aic.dao.impl.PurchaseOrderDaoImpl;
import com.aic.dao.impl.PurchaseOrderItemDaoImpl;
import com.aic.dao.impl.UserDaoImpl;
import com.aic.pojo.Book;
import com.aic.pojo.PurchaseOrder;
import com.aic.pojo.PurchaseOrderItem;
import com.aic.pojo.User;
import com.aic.service.PurchaseOrderService;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private PurchaseOrderDao purchaseorderDao = new PurchaseOrderDaoImpl();
    private PurchaseOrderItemDao purchaseorderItemDao = new PurchaseOrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public String createOrder(List<PurchaseOrderItem> purchaseOrderItemList, Integer userId ,double totalPrice) {
//        订单号，唯一性
        String orderId = "" + System.currentTimeMillis() + userId;

//        创建订单对象
        PurchaseOrder purchaseOrder = new PurchaseOrder(orderId,new Date() , userId , new BigDecimal(totalPrice),purchaseOrderItemList);
        purchaseorderDao.saveOrder(purchaseOrder);
//        遍历购物车中的每一个商品项，转为 OrderItem 保存在数据库中
        for (PurchaseOrderItem item : purchaseOrderItemList){
            item.setOrderId(orderId);
            purchaseorderItemDao.saveOrderItem(item);

            Book book;
            if(bookDao.queryBookByName(item.getName()) == null){
                book = new Book(null , item.getName() , item.getAuthor(), 0,item.getSalesPrice());
                bookDao.addBook(book);
            }
            book = bookDao.queryBookByName(item.getName());
            book.setStock(book.getStock() + item.getCount());
            bookDao.updateBook(book);
        }
//        清空购物车
        purchaseOrderItemList.clear();
        return orderId;
    }

    @Override
    public List<PurchaseOrder> showAllOrder() {
        List<PurchaseOrder> purchaseOrders = purchaseorderDao.queryOrders();
        for(PurchaseOrder item : purchaseOrders){
            item.setUserName(userDao.queryUserByUserId(item.getUserId()).getUsername());
        }
        return purchaseOrders;
    }

    @Override
    public List<PurchaseOrderItem> showPurchaseOrderDetail(String orderId) {
        List<PurchaseOrderItem> purchaseOrderItemList = purchaseorderDao.queryOrderItemByOrderId(orderId);
        for(PurchaseOrderItem item : purchaseOrderItemList){
            Book book = bookDao.queryBookByName(item.getName());
            item.setAuthor(book.getAuthor());
        }
        return purchaseOrderItemList;
    }

    @Override
    public List<PurchaseOrder> searchByUser(String name) {
        User user = userDao.queryUserBuUsername(name);
        // 输入的管理员不存在
        if(user == null){
            return null;
        }
        List<PurchaseOrder> purchaseOrders = purchaseorderDao.queryOrdersByUserId(user.getId());
        for(PurchaseOrder item : purchaseOrders){
            item.setUserName(userDao.queryUserByUserId(item.getUserId()).getUsername());
        }
        return purchaseOrders;
    }

    @Override
    public List<PurchaseOrder> searchByBookName(String bookName) {
        List<PurchaseOrder> purchaseOrders = purchaseorderDao.queryOrdersByBookName(bookName);
        for(PurchaseOrder item : purchaseOrders){
            item.setUserName(userDao.queryUserByUserId(item.getUserId()).getUsername());
        }
        return purchaseOrders;
    }

}
