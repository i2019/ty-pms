<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="style/login/login.css" />
</head>
<body>

<div id="header">
	<div class="header_title">
		<span class="title_con">PMS系统</span>
	</div>
</div>

<form action="login_execute.action" method="post">
<div id="content">
	<center>
		<div class="con">
			<div class="con_title">
				<span class="con_title_sp">欢迎登录PMS系统</span>
			</div>
			<div class="con_panel">
				<div class="con_input">
					<span>用户名：</span>
					<input name="username" type="text" placeholder="操作员"/>
				</div>
				<div class="con_input">
					<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
					<input name="password" type="password" placeholder="密码"/>
				</div>
				<input type="submit" value="登    录" class="submit-btn"/>
			</div>
			
		</div>
	</center>
</div>
</form>


</body>
</html>
