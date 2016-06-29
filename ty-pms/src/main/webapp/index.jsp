<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>PMS-Login</title>
		<link rel="stylesheet" href="style/login/login.css" />
	</head>
	<body>
		<center>
			<div id="header">
			<div class="header_title">
				<span class="title_con">PMS系统</span>
			</div>
		</div>
		<form action="login_execute.action" method="post">
			<div id="content">
				<div class="con">
					<div class="con_title">
						<span class="con_title_sp">欢迎登录PMS系统</span>
					</div>
					<div class="con_panel">
						<div class="con_input">
							<span>用户名：</span>
							<input name="username" type="text"/>
						</div>
						<div class="con_input">
							<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
							<input name="password" type="password"/>
						</div>
						<input type="submit" value="登    录" class="submit-btn"/>
					</div>
					
				</div>
			</div>
		</form>
	  </center>
	</body>
</html>
