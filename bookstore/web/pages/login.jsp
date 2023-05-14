<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2022/12/19
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <%@include file="/static/common/head.jsp"%>
</head>

<body>
<div id="login_header">
    图书进货、销售管理系统
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>管理员登录</h1>
                    <a href="regist.jsp" id="get_user">申请管理员账号</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
<%--									<%= request.getAttribute("msg") == null ? "请输入账号和密码" : request.getAttribute("msg")%>--%>
									${empty requestScope.msg ? "请输入账号和密码！" : requestScope.msg}
								</span>
                </div>
                <div class="form" id="login_form">
                    <form action="http://39.105.173.94/bookstore/userServlet?action=login" method="post">
                        <input type="hidden" name="action" value="login">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
                               value="${requestScope.username}"/>
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
