<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城会员登录页面</title>

	<%-- 静态包含base标签，css样式，jQuery文件 --%>
	<%@include file="/pages/common/head.jsp"%>

</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logostatic.gif" >
		</div>
		
			<div class="login_banner" style="background-color: #2897a6">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>书城会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">

									<%-- 在今后的开发基本都是使用EL表达式来替代表达式脚本 --%>
								<%-- <%=request.getAttribute("msg") == null? "请输入用户名和密码":request.getAttribute("msg")%> --%>
									${ empty requestScope.msg? "请输入用户名和密码":requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<%-- 添加隐藏域 --%>
									<input type="hidden" name="action" value="login" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username"
<%--										   value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>" />--%>
										<%-- 对于EL而言，在输出空值的时候就是空串 --%>
										   value = "${requestScope.username }" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" style="background-color:rgba(38,142,156,0.82)" />
									<input type="checkbox" style="margin-left:3px;margin-top: 16px">七天免登录
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%-- 静态包含页脚内容 --%>
		<%@include file="/pages/common/footer.jsp"%>


</body>
</html>