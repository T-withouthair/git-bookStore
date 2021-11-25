<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
<%--<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >--%>

	<%-- 静态包含base标签，css样式，jQuery文件 --%>
	<%@include file="/pages/common/head.jsp"%>


<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 160px;
	}
</style>

</head>

<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logostatic.gif" >
			<span class="wel_word">结算</span>

		<%-- 静态包含，登录 成功之后的菜单 --%>
		<%@include file="/pages/common/login_success_menu.jsp"%>

	</div>

	<div id="main">
<%--		<h1>你的订单已结算，订单号为：${sessionScope.orderId}</h1>--%>

		<h1>您的订单已结算！</h1><br />
<%--		<dt style="text-align: center">订单号为：</dt>--%>
		<dd style="text-align: center;font-weight: bold;font-size: 18px">
<%--			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
			订单号为：<input id="OrderNub" name="OrderNub" type="text" disabled="disabled" style="font-size: 15px">
		</dd>

    <br /><br /><br />
    <a style="display: block; text-align: center; font-weight: bold; font-size: 17px; color:red" href="index.jsp">点击返回首页</a>

	</div>

	<script language="JavaScript">
		var Nub = sessionStorage.getItem("sNow");
		document.getElementById("OrderNub").value = "   " + Nub;
	</script>

	<%--<div id="bottom">
		<span>
			书城.Copyright &copy;2021
		</span>
	</div>--%>

	<%-- 静态包含页脚内容 --%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>