<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>

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
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logostatic.gif." >
			<span class="wel_word">编辑图书</span>
<%--			<div>
				<a href="book_manager.jsp">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="../../index.jsp">返回商城</a>
			</div>--%>

			<%-- 静态包含 manager管理模块的菜单 --%>
			<%@include file="/pages/common/manager_menu.jsp"%>

		</div>
		
		<div id="main">
			<!-- 表单提交地址 -->
			<form action="manager/bookServlet" method="get">
				<!-- 添加隐藏域，告诉服务器要调用哪个方法(add：添加方法) -->
				<input type="hidden" name="pageNo" value="${ param.pageNo }">
				<input type="hidden" name="action" value="${ empty param.id ? "add" : "update"}" />
				<input type="hidden" name="id" value="${ requestScope.book.id }" />
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<%-- 参数名要和JavaBean保持一致 --%>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
	
		</div>

		<%-- 静态包含页脚内容 --%>
		<%@include file="/pages/common/footer.jsp"%>

</body>
</html>