<%--
  Created by IntelliJ IDEA.
  User: 86177
  Date: 2021/9/28
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 抽取头部内容 --%>

<%-- 动态的得到一个完整的base标签的值 --%>
<%
    // 获取协议
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            // 获取当前的工程路径
            + request.getContextPath()
            + "/";

    pageContext.setAttribute("basePath",basePath);
%>

<!-- 写base标签，永远固定相对路径跳转的结果 -->
<base href="<%=basePath%>">	<!-- 在项目中，base标签中的值写到工程路径 -->
<link type="text/css" rel="stylesheet" href="/book/static/css/style.css" >
<script type="text/javascript"
        src="static/script/jquery-1.7.2.js"></script>
