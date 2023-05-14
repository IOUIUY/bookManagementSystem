package com.aic.web;

import com.aic.pojo.*;
import com.aic.service.SalesOrderService;
import com.aic.service.impl.SalesOrderServiceImpl;
import com.aic.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesManagementServlet extends BaseServlet{
    SalesOrderService salesOrderService = new SalesOrderServiceImpl();

    protected void showAllSalesOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SalesOrder> salesOrderList = salesOrderService.showAllOrder();
        req.getSession().setAttribute("salesOrderList" , salesOrderList);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/salesManagement/salesManagement.jsp");
    }

    protected void addOrderItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SalesOrderItem> salesOrderItemList = (List<SalesOrderItem>) req.getSession().getAttribute("salesOrderItemList");
        double totalSalesPrice;
        if(salesOrderItemList == null){
            salesOrderItemList = new ArrayList<>();
            totalSalesPrice = 0;
        }else{
            totalSalesPrice = (double) req.getSession().getAttribute("totalSalesPrice");
        }
        SalesOrderItem salesOrderItem = new SalesOrderItem();
        salesOrderItem.setName(req.getParameter("name"));
        salesOrderItem.setCount(WebUtils.parseInt(req.getParameter("count") , 0));
        salesOrderItem.setAuthor(req.getParameter("author"));
        salesOrderService.createOrderItem(salesOrderItem);
        salesOrderItemList.add(salesOrderItem);
        totalSalesPrice += salesOrderItem.getPrice().doubleValue();
        req.getSession().setAttribute("salesOrderItemList",salesOrderItemList);
        req.getSession().setAttribute("totalSalesPrice",totalSalesPrice);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/salesManagement/addSalesOrder.jsp");
    }

    protected void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<SalesOrderItem> salesOrderItemList = (List<SalesOrderItem>) req.getSession().getAttribute("salesOrderItemList");
        User user = (User) session.getAttribute("user");
        salesOrderService.createOrder(salesOrderItemList, user.getId(), (Double) session.getAttribute("totalSalesPrice"));
        session.removeAttribute("salesOrderItemList");
        session.removeAttribute("totalSalesPrice");
        showAllSalesOrder(req , resp);
    }

    protected void showSalesOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<SalesOrderItem> salesOrderDetailList = salesOrderService.showSalesOrderDetail(orderId);
        req.getSession().setAttribute("salesOrderDetailList",salesOrderDetailList);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/salesManagement/salesOrderDetail.jsp");
    }

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String way = req.getParameter("way");
        String search = req.getParameter("search");
        List<SalesOrder> salesOrderList;
        if("user".equals(way)){
            salesOrderList = salesOrderService.searchByUser(search);
        }else{
            salesOrderList = salesOrderService.searchByBookName(search);
        }
        req.getSession().setAttribute("salesOrderList",salesOrderList);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/salesManagement/salesManagement.jsp");
    }

}
