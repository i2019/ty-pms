<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>PMS-Login</title>
	<link rel="stylesheet" href="style/login/login.css" />
	<script type="text/javascript" src="scripts/jquery/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="tools/i18n/i18n.js"></script> 
</head>
<body>
<div id="header">
	<div class="header_title">
		<span class="title_con"><fmt:message key="system.pms"/></span>
	</div>
</div>

<form action="login.do" method="post">
<div id="content">
	<center>
		<div class="con">
			<div class="con_title">
				<span class="con_title_sp"><fmt:message key="system.welcome"/><fmt:message key="system.pms"/></span>
			</div>
			
			<div class="con_panel">
				<div class="con_input">
					<span>
					<fmt:message key="common.user.userName"/>
					</span>
					<input name="username" type="text"/>
				</div>
				<div class="con_input">
					<span> <fmt:message key="common.user.password"/> &nbsp;&nbsp;</span>
					<input id="pass" name="password" type="password"/>
				</div>
				<input type="submit" value="<fmt:message key="system.login"/>" class="submit-btn"/>
			</div>
			
		</div>
	</center>
</div>
</form>
</body>

</html>
