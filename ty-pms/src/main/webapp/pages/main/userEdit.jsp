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

 .center-in-center{   
     position: absolute;   
     top: 50%;   
     left: 50%;   
     -webkit-transform: translate(-50%, -50%);   
     -moz-transform: translate(-50%, -50%);   
     -ms-transform: translate(-50%, -50%);   
     -o-transform: translate(-50%, -50%);   
     transform: translate(-50%, -50%);   
 }   
        
</style>

<script type="text/javascript">

function ajaxVerifyOnly(){
	if($('#userCriteria_userName').val()){
		var userName=$('#userCriteria_userName').val();
		$.ajax({
		   	 type:"POST",
		   	 async:false,
		     dataType : "json",
		   	 url:"/ty-pms/user_ajaxVerifyOnly.action",
		   	 data:{"userName":userName},
			 success:function(data){
				  if(data.length > 0){	
					  var repeatedUserName=data[0].repeatedUserName;
					  alert("用户名"+repeatedUserName+"已存在!");
				  }
		     }
	    });	
	}	
}

$(document).ready(function() {
	
	
	
	$("#cancelbutton").click(function() {
		/**  关闭弹出iframe  **/
		window.parent.$.fancybox.close();
	});
	
	$("#submitbutton").click(function() {
		/**  关闭弹出iframe  **/
		window.parent.$.fancybox.close();
		$('form').submit();
	});
	
});



</script>

</head>
<body>

<div id="container" class="center-in-center">
	<form method="post" action="user_save.action">
		<s:hidden name="userCriteria.userId"></s:hidden>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt">用户名</td>
					<td class="ui_text_lt">
						<s:textfield onchange="ajaxVerifyOnly()" type="text" id="userCriteria_userName" name="userCriteria.userName" class="ui_input_txt02"/>
						
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td class="ui_text_rt">密码</td>
					<td class="ui_text_lt">
						<s:textfield type="text" id="userCriteria_password" name="userCriteria.password" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td class="ui_text_rt">备注</td>
					<td class="ui_text_lt">
						<s:textfield type="text" id="userCriteria_remark" name="userCriteria.remark" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="button" value="提交" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>


</body>
</html>



