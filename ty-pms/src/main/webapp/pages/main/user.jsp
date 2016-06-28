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


$(function () { $('.popover-show').popover('show');});
$(function () { $('.popover-hide').popover('hide');});
$(function () { $('.popover-destroy').popover('destroy');});
$(function () { $('.popover-toggle').popover('toggle');});
$(function () { $(".popover-options a").popover({html : true });});
$(function () { $('.popover-show').on('shown.bs.popover', function () {
   //alert("当显示时警告消息");
 })});
 
$(document).ready(function(){

	/** 编辑   **/
	$(".editUser").fancybox({	
			//'href'  : 'user_edit.action?userId='+$(this).attr("id"),
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : true,
	        'onClosed' : function() { 
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

<style type="text/css">



</style>

</head>
<body>
<div id="LinkDIV"></div>
<hr class="solided notopMargin">
<form class="form-horizontal" role="form">
        <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">用户名:</label>
           <div class="col-sm-2">
              <s:textfield name="userCriteria.userName" cssClass="form-control w220" type="text"></s:textfield>
           </div>
           <label class="text-muted col-sm-1 control-label" for="ds_name">数据库名</label>
           <div class="col-sm-2">
              <s:textfield name="userCriteria.userName" cssClass="form-control w220" type="text"></s:textfield>
           </div>
            <label class="text-muted col-sm-1 control-label" for="ds_name">数据库名</label>
           <div class="col-sm-2">
              <s:textfield name="userCriteria.userName" cssClass="form-control w220" type="text"></s:textfield>
           </div>
       </div>
       <hr class="solided notopMargin">
       <div class="form-group">
	      <div class="col-sm-offset-4 col-sm-10">
	         <button type="submit" class="btn btn-default w120 mleft10"><a class="nodecoration">查询</a></button>
	         <button type="submit" class="btn btn-default w120"><a class="nodecoration">重置</a></button>
	      </div>
  	 </div>
</form>
<hr class="solided notopMargin">

<!--列表样式-->
<div class="pannel_display">
	<display:table name="userResult.resultList" id="userList" sort="list" 
		class="result_table" requestURI="" pagesize="20" size="userResult.totalCount" partialList="true">
		<display:setProperty name="sort.amount" value="list" />
		<display:column property="userName" title="用户名"/>
		
		<display:column title="操作">
			<input type="hidden" id="userId_${userList.userId}" value="${userList.userId}"/>
			<a href="user_edit.action?userId=${userList.userId}" class="editUser link mgR12">
				编辑</a>
			<c:if test="${loginUser.userId != userList.userId }">
				<a href="user_del.action?userId=${userList.userId}" class="delUser link">
					删除</a>
			</c:if>	
		</display:column>
		
		<display:column title="备注">
			<div type="button" class="popover-hide" title="备注详情" style="z-index: 9999999;"
				data-container="body" data-toggle="popover" 
			      data-placement="bottom" data-content="${userList.remark}"> 
			      <label class="remarkLabel h20">${userList.remark}</label>
			      <span></span>   
	   		</div>
		</display:column>
		
	</display:table>
</div>
<hr class="solided notopMargin">
</body>
</html>