<%@ page language="java" errorPage="" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/base.jsp"%>
<%@ include file="/style.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>PMS-Main</title>
		<script type="text/javascript">
		/*二级菜单*/
		$(document).ready(function(){
			$(document).ajaxStart(onStart).ajaxSuccess(onStop);
			/** 默认异步加载"业务模块"目录  **/
			 loadMenu('YEWUMOKUAI', "dleft_tab1");
			// 默认展开所有节点
			if( zTree ){
				// 默认展开所有节点
				//zTree.expandAll(true);
			}
		});
		</script>
</head>
<body onload="getDateNow()">
    <div id="top">
		<div id="top_logo">
		<!--  
			<img alt="logo" src="images/common/logo.jpg" width="274" height="49" style="vertical-align:middle;">
		-->
		</div>
		<div id="top_links">
			<div id="top_op">
				<ul>
					<li>
						<img alt="当前用户" src="images/common/user.jpg">：
						<span id="loginUserName">${user.userName }</span>
					</li>
					<li>
						<img alt="今天是" src="images/common/date.jpg">：
						<span id="day_day"></span>
					</li>
				</ul> 
			</div>
			<div id="top_close">
				<a href="javascript:void(0);" onclick="logout();" target="_parent">
					<img alt="退出系统" title="退出系统" src="images/common/close.jpg" style="position: relative; top: 10px; left: 25px;">
				</a>
			</div>
		</div>
	</div>
    <!-- side menu start -->
	<div id="side">
		<div id="left_menu">
		    <!-- 一级菜单 -->
		 	<ul id="TabPage2" style="height:200px; margin-top:50px;">
				<li id="left_tab1" class="selected" onClick="javascript:switchTab('TabPage2','left_tab1');" title="业务模块">
					<img alt="业务模块" title="业务模块" src="images/common/1_hover.jpg" width="33" height="31">
				</li>
				<li id="left_tab2" onClick="javascript:switchTab('TabPage2','left_tab2');" title="系统管理">
					<img alt="系统管理" title="系统管理" src="images/common/2.jpg" width="33" height="31">
				</li>		
				<li id="left_tab3" onClick="javascript:switchTab('TabPage2','left_tab3');" title="其他">
					<img alt="其他" title="其他" src="images/common/3.jpg" width="33" height="31">
				</li>
			</ul>
			<!-- 显示或隐藏二级菜单  -->
			<div id="nav_show" style="position:absolute; bottom:0px; padding:10px;">
				<a href="javascript:;" id="show_hide_btn">
					<img alt="显示/隐藏" title="显示/隐藏" src="images/common/nav_hide.png" width="35" height="35">
				</a>
			</div>

		 </div>
		 <div id="left_menu_cnt">
		 	<div id="nav_module">
		 		<img src="images/common/module_1.png" width="210" height="58"/>
		 	</div>
		 	<div id="nav_resource">
		 		<ul id="dleft_tab1" class="ztree" style="display: none;"></ul>
		 		<ul id="dleft_tab2" class="ztree" style="display: none;"></ul>
		 		<ul id="dleft_tab3" class="ztree" style="display: none;"></ul>
		 	</div>
		 </div>
	</div>
	 <!-- side content-->
    <div id="main">
      	<iframe name="right" id="rightMain" 
      	frameborder="no" scrolling="auto" width="100%" height="100%" allowtransparency="true">
      	</iframe>
    </div>
</body>
</html>
   
 