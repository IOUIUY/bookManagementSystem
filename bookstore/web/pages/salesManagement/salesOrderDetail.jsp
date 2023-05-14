<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/25
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <%@include file="/static/common/head.jsp"%>
</head>
<body id="form_list">
    <div id="login_header">订单详情</div>
    <div id="main">
        <table>
            <tr>
                <td>书名</td>
                <td>作者</td>
                <td>数量</td>
                <td>单价</td>
            </tr>
            <c:forEach items="${sessionScope.salesOrderDetailList}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.author}</td>
                    <td>${item.count}</td>
                    <td>${item.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="http://39.105.173.94/bookstore/pages/salesManagement/salesManagement.jsp" style="margin-left: 750px">返回</a>
</body>
</html>
