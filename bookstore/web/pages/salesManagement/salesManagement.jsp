<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/19
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售管理</title>
    <%@include file="/static/common/head.jsp"%>
    <script type='text/javascript' src="/bookstore/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        // 页面加载完成后
        $(function () {
            // 给搜索按钮绑定单击事件
            $("#search_button").click(function () {
                name = $("#search").val();
                if(name== ""){
                    alert("请输入查找记录的处理人！");
                }else{
                    location.href = "http://39.105.173.94/bookstore/salesManagementServlet?action=search&name="+name;
                }
            });
        })
    </script>
</head>
<body id="form_list">
    <div id="login_header">销售记录总览</div>
    <div id="main">
        <table>
            <tr>
                <td>订单日期</td>
                <td>总额</td>
                <td>处理人</td>
                <td></td>
            </tr>
            <c:if test="${not empty sessionScope.salesOrderList}">
                <c:forEach items="${sessionScope.salesOrderList}" var="item">
                    <tr>
                        <td>${item.createTime}</td>
                        <td>${item.price}</td>
                        <td>${item.userName}</td>
                        <td><a href="http://39.105.173.94/bookstore/salesManagementServlet?action=showSalesOrderDetail&orderId=${item.orderId}">查看详情</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
    <form action="http://39.105.173.94/bookstore/salesManagementServlet?action=search" method="post">
        <input type="text" name="search" id="search" placeholder="输入查询内容">
        <select name="way">
            <option value="user">根据处理人查找</option>
            <option value="bookName">根据书名查找</option>
        </select>
        <input type="submit" id="search_button" value="查找"><br/>
    </form>
    <a href="http://39.105.173.94/bookstore/pages/salesManagement/addSalesOrder.jsp" id="add">添加售货记录</a>
    <a href="http://39.105.173.94/bookstore/pages/bookstoreManagement.jsp" id="return_last">返回上一层</a>
</body>
</html>
