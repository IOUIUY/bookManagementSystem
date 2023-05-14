<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/22
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加记录</title>
    <%@include file="/static/common/head.jsp"%>
</head>
<body id="form_list">
    <div id="login_header">添加进货书籍</div>
    <div id="main">
        <form action="http://39.105.173.94/bookstore/purchaseManagementServlet?action=addOrderItem" method="post">
            <table>
                <tr>
                    <td>书名</td>
                    <td>作者</td>
                    <td>数量</td>
                    <td>销售单价</td>
                    <td>进货单价</td>
                    <td></td>
                </tr>
                <tr>
                    <td><input name="name" type="text"></td>
                    <td><input name="author" type="text"></td>
                    <td><input name="count" type="text"></td>
                    <td><input name="salesPrice" type="text"></td>
                    <td><input name="purchasePrice" type="text"></td>
                    <td><input type="submit" value="添加记录"></td>
                </tr>
            </table>
        </form>
    </div>
    <a href="http://39.105.173.94/bookstore/pages/puchaseManagemt/addPurchaseOrder.jsp" style="margin-left: 750px">返回</a>
</body>
</html>
