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
	<style type="text/css">
		body {
			font-family: 'Microsoft Yahei';
		}
		ol,ul {
		  margin: 0;
		  padding: 0;
		  list-style: none;
		}
		h1 {
		  margin-top: 40px;
		  text-align: center;
		  color: #333;
		}
		
		/*表盘*/
		.clock {
		  position: relative;
		  width: 200px;
		  height: 200px;
		  border-radius: 100%;
		  background-color: #292a38;
		  margin: 50px auto;
		}
		.pointer li.circle {
		  position: absolute;
		  top: 50%;
		  left: 50%;
		  transform-origin: left center;
		  background: #fff;
		  width: 10px;
		  height: 10px;
		  border-radius: 100%;
		  margin-top: -5px;
		  margin-left: -5px;
		}
		
		/*刻度*/
		.line-hour li,
		.line-min li {
		  position: absolute;
		  left: 50%;
		  top: 50%;
		  transform-origin: 0 0;
		  background-color: #fff;
		}
		.line-hour li {
		  width: 10px;
		  height: 2px;
		}
		.line-min li {
		  width: 5px;
		  height: 2px;
		}
		
		/*数字*/
		.number {
		  position: absolute;
		  height: 150px;
		  width: 150px;
		  left: 50%;
		  top: 50%;
		  transform: translate(-50%, -50%);
		  font-size: 15px;
		  color: #fff;
		}
		.number li {
		  position: absolute;
		  transform: translate(-50%, -50%);
		}
		
		/*指针*/
		.pointer li {
		  position: absolute;
		  top: 50%;
		  left: 50%;
		  transform-origin: left center;
		  background: #fff;
		}
		.pointer li.hour {
		  width: 45px;
		  height: 3px;
		  margin-top: -1px;
		}
		.pointer li.min {
		  width: 60px;
		  height: 2px;
		  margin-top: -1px;
		}
		.pointer li.sec {
		  width: 90px;
		  height: 1px;
		  margin-top: -1px;
		  background-color: red;
		}
	</style>
	
</head>
<body>
<div id="header">
	<div class="header_title">
		<span class="title_con"><fmt:message key="system.pms"/></span>
	</div>
	<!-- 
	 <div class="clock">
	  <ul class="line-min"></ul>
	  <ul class="line-hour"></ul>
	  <ol class="number"></ol>
	  <ul class="pointer">
	 		<li class="hour"></li>
	    	<li class="min"></li>
	 		<li class="sec"></li>
	 		<li class="circle"></li>
	  </ul>
	</div>
 -->
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

<script type="text/javascript">
	function init(){
		  drawLines($('.line-min'), 60, 85);
		  drawLines($('.line-hour'), 12, 80);
		  drawNumbers($('.number'));
		  move();
		}
		init();


		/*
		 * 绘制钟表刻度线
		 * @param wrap 刻度线的父容器
		 * @param total 刻度线的总个数
		 * @param translateX 刻度线在x轴方向的偏移量
		 */
		function drawLines(wrap, total, translateX){
		  var gap = 360/total;
		  var strHtml = '';
		  for(var i=0; i<total; i++){
		    strHtml += '<li style="transform:rotate('+ (i*gap) + 'deg) translate(' + translateX + 'px,-50%)"></li>';
		  }
		  wrap.html(strHtml);
		}


		/* 
		 * 绘制时钟数字
		 * @param wrap 数字的父容器
		 */
		function drawNumbers(wrap){
		  var radius = wrap.width() / 2;

		  var strHtml = '';
		  for(var i=1; i<=12; i++){
		    var myAngle = (i-3)/6 * Math.PI;

		    var myX = radius + radius*Math.cos(myAngle), // x=r+rcos(θ)
		        myY = radius + radius*Math.sin(myAngle); // y=r+rsin(θ)

		    strHtml += '<li style="left:' + myX + 'px; top:'+ myY +'px">' + i + '</li>';
		  }
		  wrap.html(strHtml);
		}


		/*
		 * 钟表走动，转动秒针、分针、时针
		 */
		function move(){
		  var domHour = $(".hour"),
		      domMin = $(".min"),
		      domSec = $(".sec");

		  setInterval(function(){
		    var now = new Date(),
		        hour = now.getHours(),
		        min = now.getMinutes(),
		        sec = now.getSeconds();

		    var secAngle = sec*6 - 90,  // s*6-90
		        minAngle = min*6 + sec*0.1 - 90,  // m*6+s*0.1-90
		        hourAngle = hour*30 + min*0.5 - 90;  // h*30+m*0.5 - 90

		    domSec.css('transform', 'rotate(' + secAngle + 'deg)');
		    domMin.css('transform', 'rotate(' + minAngle + 'deg)');
		    domHour.css('transform', 'rotate(' + hourAngle + 'deg)');

		    document.title = hour + ':' + min + ':' + sec;
		 
		  },1000);

		}
	</script>
	
</html>
