<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/21
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加进货记录</title>
    <script type="text/javascript" src="../../static/jquery-1.7.2.js"></script>
    <%@include file="/static/common/head.jsp"%>
</head>
<body id="form_list">
    <div id="login_header">进货书籍</div>
    <div id="main">
        <table>
            <tr>
                <td>书名</td>
                <td>作者</td>
                <td>数量</td>
                <td>销售单价</td>
                <td>进货单价</td>
            </tr>
            <c:if test="${not empty sessionScope.purchaseOrderItemList}">
                <c:forEach items="${sessionScope.purchaseOrderItemList}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.author}</td>
                        <td>${item.count}</td>
                        <td>${item.salesPrice}</td>
                        <td>${item.price}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
    <a href="http://39.105.173.94/bookstore/pages/puchaseManagemt/purchaseOrderAdd.jsp" id="add">添加进货书籍</a>
    <a href="http://39.105.173.94/bookstore/purchaseManagementServlet?action=addOrder" id="return_last">提交本次进货记录</a>
</body>
</html>
