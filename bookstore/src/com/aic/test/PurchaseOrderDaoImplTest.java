package com.aic.test;

import com.aic.dao.PurchaseOrderDao;
import com.aic.dao.impl.PurchaseOrderDaoImpl;
import com.aic.pojo.PurchaseOrder;
import com.aic.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderDaoImplTest {

    PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDaoImpl();

    @Test
    void saveOrder() {
        System.out.println(purchaseOrderDao.saveOrder(new PurchaseOrder("1", new Date(), 1, new BigDecimal(20),null)));
        JdbcUtils.commitAndClose();
    }

    @Test
    void queryOrders() {
        System.out.println(purchaseOrderDao.queryOrders());
    }

    @Test
    void deleteOrder() {
        System.out.println(purchaseOrderDao.deleteOrder(new PurchaseOrder("1", null, null, null , null)));
    }

    @Test
    void queryOrdersByUserId() {
        System.out.println(purchaseOrderDao.queryOrdersByUserId(1));
    }
}