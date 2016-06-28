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

</head>

<body>

<div class="pannel_out">
	<div class="pannel_form">		
		<s:form id="userForm" name="userForm" action="user_list.action" method="post">
			<div class="container_list">
				
				<div class="list_criteria">
				    <div class="criteria_label">
						用户名: (复选框)
					</div>
					<div class="criteria_value">
						<select id="userCriteria_userNameList" name="userCriteria.userNameList" class="text_value" multiple="multiple">
							<c:forEach items="${userNameList}" var="userName">	
								<option value="${userName}">${userName}</option>
							</c:forEach>
						</select>
					</div>	
				</div>
				<div class="list_criteria">
				    <div class="criteria_label">
						创建开始时间: (时间选择器  精确到小时或者分 推荐使用datetimepicker)
					</div>
					<div class="criteria_value">
						<s:textfield type="text" id="userCriteria_createdTimeBegin" name="userCriteria.createdTimeBegin" class="text_value"/>
					</div>	
				</div>
				<div class="list_criteria">
				    <div class="criteria_label">
						创建结束时间:  ( 时间选择器)
					</div>
					<div class="criteria_value">
						<s:textfield type="text" id="userCriteria_createdTimeEnd" name="userCriteria.createdTimeEnd" class="text_value"/>
					</div>	
				</div>
				<div class="list_criteria">
				    <div class="criteria_label">
						备注: (模糊查询  文本域)
					</div> 
					<div class="criteria_value">
						<s:textfield type="text" id="userCriteria_userName" name="userCriteria.remark" class="text_value"/>
					</div>	
				</div>
				
				<div class="list_button">
					<input type="submit" value="查询" class="button_search" id="searchBtn" /> 	
					<input type="button" value="新增" class="button_create" id="addBtn" /> 		
				</div>
			</div>
		</s:form>
	</div>
	<!--列表样式-->
	<div class="pannel_display">
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
</div>
	
</body>
</html>