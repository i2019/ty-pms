<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>

<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>

<style type="text/css">
.bt_wp{ border-top:#c1cfd9 1px solid;}
.result_table{ width:100%;}
.result_table th{ border:#c1cfd9 1px solid; border-top-color:#f6f8fa; background:#d3dde4; font-weight:normal; padding:6px 6px;}
.result_table td{ border:#c1cfd9 1px solid; text-align:center;padding:6px 6px; background:#fff;}
.result_table th.sortable{ cursor:pointer;}
.result_table th.sortable:hover{ background:#c1cfd9;}
.result_table th.sortable.sorted a,
.result_table th.sortable.sorted.order1 a,
.result_table th.sortable.sorted.order2 a{ display:inline-block; background-image:url(../img/sortable_sort_bg.png); background-repeat:no-repeat; padding-right:12px; text-decoration:none; color:#4e5663;}
.result_table th.sortable.sorted a{ background-position:right 4px;}
.result_table th.sortable.sorted.order1 a{background-position:right -26px;}
.result_table th.sortable.sorted.order2 a{background-position:right -56px;}
.result_table th.weekend{background:#9eb2c0;}
.result_table td.off_fs,
.result_table td.off_room{ color:#e10000; font-weight:bold; background:#fff4d2;}
.result_table td.td_ia{ cursor:pointer;}
.result_table td.td_ia:hover{ background:#e5f3e5;}
.result_table td.off_room:hover{background:#ffeebb;}
.result_table td span.price{font-size:14px; padding-right:20px; background:url(../img/price_arrow.png) no-repeat right 0; display:inline-block; line-height:20px;}
.result_table td span.price.hover{ background-position:right -50px;}
.result_table td .p_hover{ position:absolute;left:71px; top:15px; background:#fff; border-top:#4e5663 2px solid; width:120px; font-size:12px; padding:6px; display:none;}
.result_table td .p_hover p{ line-height:20px; margin:0; padding:0; text-align:left;}
a.link:link,
a.link:visited{color:#067ab4;}
a.link:hover{color:#0066cc;}
a.link_1:link,
a.link_1:visited{color:#4e5663; text-decoration:none;}
a.link_1:hover{color:#0066cc; text-decoration:underline;}
.mgR12 { margin-right:12px; }
</style>

<script type="text/javascript">
 
$(document).ready(function(){

	/** 编辑   **/
	$(".editUser").fancybox({	
//			'href'  : 'user_edit.action?userId='+$(this).attr("id"),
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : true,
	        'onClosed' : function() { 
	        	console.log('user_edit.action?userId='+$("#userId").val());
	        	window.location.href = 'user_list.action';
	        }
	 });
	
	/** 新增   **/
    $("#addBtn").fancybox({
    	'href'  : 'user_edit.action',
    	'width' : 733,
        'height' : 530,
        'type' : 'iframe',
        'hideOnOverlayClick' : false,
        'showCloseButton' : true,
        'onClosed' : function() { 
        	window.location.href = 'user_list.action';
        }
    });
});
 
</script>
</head>
<body>

<form id="userForm" name="userForm" action="user_list.action" method="post">
	<div id="container">
		<div class="ui_content">
			<div class="ui_text_indent">
				<div id="box_border">
					<div id="box_center">
						用户名:	
						<s:textfield type="text" id="userCriteria_userName" name="userCriteria.userName" class="ui_input_txt02"/>
					</div>
					<br>
					<div id="box_bottom">
						<input type="submit" value="查询" class="ui_input_btn01" id="searchBtn" /> 	
						<input type="button" value="新增" class="ui_input_btn01" id="addBtn" /> 		
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

<!--列表样式-->
<div class="bt_wp">
	<display:table name="userResult.resultList" id="userList" sort="list" 
	class="result_table" requestURI="" pagesize="20" size="userResult.totalCount" partialList="true">
		<display:setProperty name="sort.amount" value="list"/>
		<display:column property="userName" title="用户名"/>
		<display:column property="remark"  title="备注" />
		<display:column title="操作">
			<input type="hidden" id="userId_${userList.userId}" value="${userList.userId}"/>
			<a href="user_edit.action?userId=${userList.userId}" class="editUser link mgR12">
				编辑</a>
			<c:if test="${loginUser.userId != userList.userId }">
				<a href="user_del.action?userId=${userList.userId}" class="delUser link">
					删除</a>
			</c:if>	
		</display:column>
	</display:table>
</div>
	
</body>
</html>