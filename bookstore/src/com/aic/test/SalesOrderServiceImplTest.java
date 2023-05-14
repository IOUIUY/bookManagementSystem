package com.aic.test;

import com.aic.pojo.SalesOrderItem;
import com.aic.service.SalesOrderService;
import com.aic.service.impl.SalesOrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesOrderServiceImplTest {

    SalesOrderService salesOrderService = new SalesOrderServiceImpl();

    @Test
    void showAllOrder() {

    }

    @Test
    void createOrder() {
        List<SalesOrderItem> salesOrderItemList = new ArrayList<>();
        salesOrderItemList.add(new SalesOrderItem("三体",null,2,new BigDecimal(1000),null,15));
        salesOrderService.createOrder(salesOrderItemList,1,1234);
    }

    @Test
    void showSalesOrderDetail() {
    }
}