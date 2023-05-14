package com.aic.test;

import com.aic.dao.PurchaseOrderDao;
import com.aic.dao.PurchaseOrderItemDao;
import com.aic.dao.impl.PurchaseOrderDaoImpl;
import com.aic.dao.impl.PurchaseOrderItemDaoImpl;
import com.aic.pojo.PurchaseOrderItem;
import com.aic.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderItemDaoImplTest {

    PurchaseOrderItemDao purchaseOrderItemDao = new PurchaseOrderItemDaoImpl();
    PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDaoImpl();

    @Test
    void saveOrderItem() {
        System.out.println(purchaseOrderItemDao.saveOrderItem(new PurchaseOrderItem("bookTest", "test", 10, new BigDecimal(20) ,null, "3")));
        JdbcUtils.commitAndClose();
    }

    @Test
    void queryOrderItemsByOderId() {
        System.out.println(purchaseOrderItemDao.queryOrderItemsByOderId("1"));
    }

    @Test
    void quertOrdersByBookName(){
        System.out.println(purchaseOrderDao.queryOrdersByBookName("人生海海"));
    }
}