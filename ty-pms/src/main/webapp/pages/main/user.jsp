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

<script type="text/javascript" src="scripts/jquery/jquery-1.12.3.js"></script>

<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<script src="bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet" href="bootstrap/bootstrap-select/css/bootstrap-select.css">
<script src="bootstrap/bootstrap-select/js/bootstrap-select.js"></script>

<style type="text/css">
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


</style>

</head>
<body>

	
<s:form action="" method="post">
	<ul>
		<li>
		
		</li>
	</ul>
</s:form>

<display:table name="userList" pagesize="2" size="userList.size()" class="result_table" partialList="true">
			<display:column property="userName" title="用户名"/>
			<display:column property="userId"  title="用户id" />
</display:table>


</body>
</html>



