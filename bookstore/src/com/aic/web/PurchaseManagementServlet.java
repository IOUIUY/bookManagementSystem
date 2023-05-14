package com.aic.web;

import com.aic.pojo.PurchaseOrder;
import com.aic.pojo.PurchaseOrderItem;
import com.aic.pojo.User;
import com.aic.service.BookService;
import com.aic.service.PurchaseOrderService;
import com.aic.service.impl.BookServiceImpl;
import com.aic.service.impl.PurchaseOrderServiceImpl;
import com.aic.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseManagementServlet extends BaseServlet{

    PurchaseOrderService purchaseOrderService = new PurchaseOrderServiceImpl();
    BookService bookService = new BookServiceImpl();

    protected void addOrderItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<PurchaseOrderItem> purchaseOrderItemList = (List<PurchaseOrderItem>) req.getSession().getAttribute("purchaseOrderItemList");
        double totalPurchasePrice;
        if(req.getSession().getAttribute("totalPurchasePrice") == null){
            purchaseOrderItemList = new ArrayList<>();
            totalPurchasePrice = 0;
        }else{
            totalPurchasePrice = (double) req.getSession().getAttribute("totalPurchasePrice");
        }
        PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
        purchaseOrderItem.setName(req.getParameter("name"));
        purchaseOrderItem.setAuthor(req.getParameter("author"));
        purchaseOrderItem.setSalesPrice(new BigDecimal(WebUtils.parseInt(req.getParameter("salesPrice"),0)));
        purchaseOrderItem.setCount(WebUtils.parseInt(req.getParameter("count") , 0));
        purchaseOrderItem.setPrice(new BigDecimal(req.getParameter("purchasePrice")));
        purchaseOrderItemList.add(purchaseOrderItem);
        totalPurchasePrice += purchaseOrderItem.getPrice().doubleValue() * purchaseOrderItem.getCount();
        req.getSession().setAttribute("purchaseOrderItemList",purchaseOrderItemList);
        req.getSession().setAttribute("totalPurchasePrice",totalPurchasePrice);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/puchaseManagemt/addPurchaseOrder.jsp");
    }

    protected void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<PurchaseOrderItem> purchaseOrderItemList = (List<PurchaseOrderItem>) session.getAttribute("purchaseOrderItemList");
        User user = (User) session.getAttribute("user");
        purchaseOrderService.createOrder(purchaseOrderItemList, user.getId(), (Double) session.getAttribute("totalPurchasePrice"));
        session.removeAttribute("purchaseOrderItemList");
        session.removeAttribute("totalPurchasePrice");
        showAllPurchaseOrder(req,resp);
    }


    protected void showAllPurchaseOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PurchaseOrder> purchaseOrderList = purchaseOrderService.showAllOrder();
        req.getSession().setAttribute("purchaseOrderList",purchaseOrderList);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/puchaseManagemt/purchaseManagement.jsp");
    }

    protected void showPurchaseOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<PurchaseOrderItem> purchaseOrderDetailList = purchaseOrderService.showPurchaseOrderDetail(orderId);
        req.getSession().setAttribute("purchaseOrderDetailList",purchaseOrderDetailList);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/puchaseManagemt/purchaseOrderDetail.jsp");
    }

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String way = req.getParameter("way");
        String search = req.getParameter("search");
        List<PurchaseOrder> purchaseOrderList;
        if("user".equals(way)){
            purchaseOrderList = purchaseOrderService.searchByUser(search);
        }else{
            purchaseOrderList = purchaseOrderService.searchByBookName(search);
        }
        req.getSession().setAttribute("purchaseOrderList",purchaseOrderList);
        resp.sendRedirect("http://39.105.173.94/bookstore/pages/puchaseManagemt/purchaseManagement.jsp");
    }
}
