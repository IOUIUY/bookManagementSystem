<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/31
  Time: 16:40
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
            <c:forEach items="${sessionScope.books}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.author}</td>
                    <td>${item.stock}</td>
                    <td>${item.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="http://39.105.173.94/bookstore/bookServlet?action=queryBooks" method="post">
        <input type="text" name="searchBook" placeholder="输入查询的内容" style="margin-left: 600px;">
        <select name="way">
            <option value="bookName">根据书名查找</option>
            <option value="author">根据作者查找</option>
        </select>
        <input type="submit" value="查询"><br/>
    </form>
    <a href="http://39.105.173.94/bookstore/pages/bookstoreManagement.jsp" id="book_back">返回</a>

</body>
</html>
