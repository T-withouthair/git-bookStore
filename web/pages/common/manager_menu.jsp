<%--
  Created by IntelliJ IDEA.
  User: 86177
  Date: 2021/9/28
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 抽取管理模块菜单 --%>

<div>
    <%-- 前面为请求的地址，action表示他要调用服务器功能里的哪一个方法 --%>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
