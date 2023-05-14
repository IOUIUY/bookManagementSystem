<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/1/5
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理</title>
    <%@include file="/static/common/head.jsp"%>
</head>
<body id="form_list">
<div id="login_header">书籍库存</div>
<div id="main">
    <table>
        <tr>
            <td>书名</td>
            <td>作者</td>
            <td>库存</td>
            <td>售价</td>
        </tr>
        <tr>
            <td>活着</td>
            <td>余华</td>
            <td>20</td>
            <td>35</td>
        </tr>
        <tr>
            <td>兄弟</td>
            <td>余华</td>
            <td>50</td>
            <td>28</td>
        </tr>
        <tr>
            <td>第七天</td>
            <td>余华</td>
            <td>20</td>
            <td>30</td>
        </tr>
<%--        <c:forEach items="${sessionScope.books}" var="item">--%>
<%--            <tr>--%>
<%--                <td>${item.name}</td>--%>
<%--                <td>${item.author}</td>--%>
<%--                <td>${item.stock}</td>--%>
<%--                <td>${item.price}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
    </table>
</div>
<input type="text" name="searchBook" placeholder="输入查询的内容" style="margin-left: 650px;">
<select>
    <option>根据书名查找</option>
    <option>根据作者查找</option>
</select>
<button name="searchBtn">查询</button><br/>
<a href="http://39.105.173.94/bookstore/pages/bookstoreManagement.jsp" id="book_back">返回</a>

</body>
</html>
