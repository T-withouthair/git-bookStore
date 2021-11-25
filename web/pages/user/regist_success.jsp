<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城会员注册页面</title>

	<%-- 静态包含base标签，css样式，jQuery文件 --%>
	<%@include file="/pages/common/head.jsp"%>

	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}
	</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logostatic.gif" >
				<span class="wel_word"></span>
<%--
				使用静态包含进行替换
				<div>
					<span>欢迎<span class="um_span">汤总</span>光临书城</span>
					<a href="../order/order.jsp">我的订单</a>
					<a href="../../index.jsp">注销</a>&nbsp;&nbsp;
					<a href="../../index.jsp">返回</a>
				</div>--%>

			<%-- 静态包含，登录 成功之后的菜单 --%>
			<%@include file="/pages/common/login_success_menu.jsp"%>

		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.jsp">转到主页</a></h1>
	
		</div>
		
<%--		<div id="bottom">
			<span>
				书城.Copyright &copy;2021
			</span>
		</div>--%>

		<%-- 静态包含页脚内容 --%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>