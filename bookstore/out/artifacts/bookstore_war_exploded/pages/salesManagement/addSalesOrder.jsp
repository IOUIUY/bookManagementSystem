<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/24
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../static/jquery-1.7.2.js"></script>
    <%@include file="/static/common/head.jsp"%>
</head>
<body id="form_list">
    <div id="login_header">销售书籍</div>
    <div id="main">
        <table>
            <tr>
                <td>书名</td>
                <td>作者</td>
                <td>数量</td>
                <td>总额</td>
            </tr>
            <c:if test="${not empty sessionScope.salesOrderItemList}">
                <c:forEach items="${sessionScope.salesOrderItemList}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.author}</td>
                        <td>${item.count}</td>
                        <td>${item.price}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="salesOrderAdd.jsp">添加记录</a></td>
            </tr>
        </table>
    </div>
    <a href="http://39.105.173.94/bookstore/salesManagementServlet?action=addOrder" id="add">提交本次进货记录</a>
    <a href="http://39.105.173.94/bookstore/pages/salesManagement/salesManagement.jsp" id="return_last">返回上一页</a>
</body>
</html>
