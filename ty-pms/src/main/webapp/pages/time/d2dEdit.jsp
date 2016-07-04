<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
 <form class="form-horizontal" action="user_save.action" id="userEditForm" method="post">>
 		<s:hidden name="user.userId"></s:hidden>
 		<!-- 用户名 -->
        <div class="form-group">
           <label class="text-muted col-sm-2 control-label" for="ds_host">用户名:</label>
           <div class="col-sm-10">
              <s:textfield onchange="ajaxVerifyOnly()" type="text" id="user_userName" name="user.userName" class="text_value"/>	
		   </div>
       </div>
       <!-- 密	码 -->
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host"> 密	码:</label>
           <div class="col-sm-2">
           		<s:textfield type="text" id="user_password" name="user.password" class="text_value"/>
           </div>
       </div>
       <!-- 备注 -->
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host"> 备	注:</label>
           <div class="col-sm-2">
           	 <s:textarea type="text" id="user_remark" name="user.remark" class="text_value"/>	
           </div>
       </div>
       <hr class="solided notopMargin">
       <div class="form-group">
	      <div class="col-sm-offset-4 col-sm-10">
	         <button id="submitbutton" class="btn btn-default w120 mleft10">
	         		提交
			  </button>	
	         <button id="cancelbutton" class="btn btn-default w120">
	         	取消
	         </button>	
	      </div>
  	 </div>
</form>
</div>

</body>
</html>



