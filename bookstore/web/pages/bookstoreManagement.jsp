<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/19
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书进货、销售管理系统</title>
    <%@include file="/static/common/head.jsp"%>
</head>
<body class="index_body">
    <div id="login_header">图书进货、销售管理系统</div>
    <div id="main" style="line-height: 450px;
        text-align: center;">
        <a  id="purchase_a" href="http://39.105.173.94/bookstore/purchaseManagementServlet?action=showAllPurchaseOrder">进货管理</a>
        <a id="sales_a" href="http://39.105.173.94/bookstore/salesManagementServlet?action=showAllSalesOrder">销售管理</a>
        <a id="book_a" href="http://39.105.173.94/bookstore/bookServlet?action=showAllBooks">书籍库存</a>
    </div>

</body>
</html>
