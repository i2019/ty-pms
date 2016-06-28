<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
 
</style>

<script type="text/javascript">

$(document).ready(function() {
	
	$("#cancelbutton").click(function() {
		/**  关闭弹出iframe  **/
		window.parent.$.fancybox.close();
		
	});
	$("#submitbutton").click(function() {
		var loginUserName=$("#loginUserName").val();
		var loginUserId=$("#loginUserId").val();
		var editUserId=$("#editUserId").val();
		var editUserName=$("#user_userName").val();
		//如果当前登录用户的用户名发生修改则需要重新登录
		if((loginUserId==editUserId) && (loginUserName!=editUserName)){
			top.document.location.href='/ty-pms/index.jsp';
			//window,location.href="logout.jsp";
			alert('当前登录用户名已经修改，请用新的用户名重新登录！');
		}
		window.parent.$.fancybox.close();
		$('#userEditForm').submit();
	});
});

/*验证用户名唯一*/
function ajaxVerifyOnly(){
	if($('#user_userName').val()){
		var userName=$('#user_userName').val();
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

</script>

</head>
<body>
<!--  type="hidden" -->
<input type="hidden" id="loginUserName" value="${LoginUserName }"/>
<input type="hidden" id="loginUserId" value="${LoginUserId }"/>
<input type="hidden" id="editUserId" value="${userId }"/>
 
<div id="container" class="center-in-center">
	<form method="post" action="user_save.action" id="userEditForm">
		<s:hidden name="user.userId"></s:hidden>
		
			<div class="container_list">
				<div class="list_criteria">
				    <div class="criteria_label">
						用户名:
					</div>
					<div class="criteria_value">
						<s:textfield onchange="ajaxVerifyOnly()" type="text" id="user_userName" name="user.userName" class="text_value"/>	
					</div>	
				</div>
				
				<div class="list_criteria">
				    <div class="criteria_label">
						密码:
					</div>
					<div class="criteria_value">
						<s:textfield type="text" id="user_password" name="user.password" class="text_value"/>	
					</div>	
				</div>
				<div class="list_criteria">
				    <div class="criteria_label">
						确认密码: (仅当新建用户时显示)
					</div>
					<div class="criteria_value">
						<s:textfield type="text" id="re_password" class="text_value"/>	
					</div>	
				</div>
				
				<div class="list_criteria">
				    <div class="criteria_label">
						备注:
					</div>
					<div class="criteria_value">
						<s:textfield type="text" id="user_remark" name="user.remark" class="text_value"/>	
					</div>	
				</div>
			</div>
			
			<div class="list_button">
				<input type="submit" value="提交" class="button_search" id="submitbutton" /> 	
				<input type="button" value="取消" class="button_create" id="cancelbutton" /> 		
			</div>
			
	</form>
</div>


</body>
</html>



