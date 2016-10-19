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

$(document).ready(function(){

	$(function () { $(".popover-hide").popover();});
	
	/*复选框*/
	//$('select[class=\'mut_opt\']').multiselect({});
	$('#userCriteria_userNameList').multiselect({
		numberDisplayed: 1,
		dropRight: true,
        enableCaseInsensitiveFiltering: true,
		maxHeight: 300,
		maxWidth:200,
		buttonWidth: '202px',
		includeSelectAllOption: true,
		allSelectedText:'已全选',
		selectAllText:'全选',
		dSelectAllText: '反选',
		nonSelectedText: '请选择'
    });
	
	 /*时间控件*/
	 $("#userCriteria_createdTimeBegin").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true  
	 });
	
	 $("#userCriteria_createdTimeEnd").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true
	 });
	
	
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
<form class="form-horizontal" role="form" method="post">
        <div class="form-group">
           <!-- 用户名 -->
           <label class="text-muted col-sm-1 control-label" for="ds_host">
			支出用户:
			</label>
           <div class="col-sm-3">
              <select id="expenditureCriteria_userNameList" name="expenditureCriteria.userNameList" class="mut_opt" multiple="multiple">
					<c:forEach items="${userNameList}" var="userName">	
						<option value="${userName}" 
						${fn:contains(expenditureCriteria.userNameList, userName)?"selected":""}>${userName}</option>
					</c:forEach>
			 </select>
           </div>
            <!-- 备注 -->
           <label class="col-sm-1 text-muted control-label" for="ds_host">支出原因说明:</label>
           <div class="col-sm-3">
             <s:textfield name="expenditureCriteria.remark" cssClass="form-control w220" type="text"></s:textfield>
           </div>
       </div>
       <div class="form-group"> 	  
            <!-- 支出金额 -->
           <label class="col-sm-1 text-muted control-label" for="ds_host">支出金额开始:</label>
           <div class="col-sm-3">
             <s:textfield name="expenditureCriteria.expenditureAmount" cssClass="form-control w220" type="text"></s:textfield>
           </div>
            <!-- 支出金额 -->
           <label class="col-sm-1 text-muted control-label" for="ds_host">支出金额结束:</label>
           <div class="col-sm-3">
             <s:textfield name="expenditureCriteria.expenditureAmount" cssClass="form-control w220" type="text"></s:textfield>
           </div>
       </div>
       <div class="form-group">
           <!-- 支出开始时间-->
           <label class="col-sm-2 text-muted control-label" for="ds_name">支出发生时间开始:</label>
           <div class="col-sm-3">
             <input id="expenditureCriteria_occurrencedTime" name="expenditureCriteria.createdTimeBegin" class="form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.createdTimeBegin }' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
        	<!-- 支出结束时间 -->
            <label class="col-sm-2 text-muted control-label" for="ds_name">支出发生时间结束:</label>
            <div class="col-sm-3">
              <input id="expenditureCriteria_createdTimeEnd" name="expenditureCriteria.createdTimeEnd" class="form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.createdTimeEnd }' pattern='yyyy-MM-dd HH:mm'/>">
            </div>
       </div>
       <div class="form-group">
           <!-- 支出开始时间-->
           <label class="col-sm-2 text-muted control-label" for="ds_name">支出结束时间开始:</label>
           <div class="col-sm-3">
             <input id="expenditureCriteria_occurrencedTime" name="expenditureCriteria.createdTimeBegin" class="form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.createdTimeBegin }' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
        	<!-- 支出结束时间 -->
            <label class="col-sm-2 text-muted control-label" for="ds_name">支出结束时间结束:</label>
            <div class="col-sm-3">
              <input id="expenditureCriteria_createdTimeEnd" name="expenditureCriteria.createdTimeEnd" class="form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.createdTimeEnd }' pattern='yyyy-MM-dd HH:mm'/>">
            </div>
       </div>
       
      
       <hr class="solided notopMargin">
       <div class="form-group">
	      <div class="col-sm-offset-4 col-sm-10">
	         <button type="submit" class="btn btn-default w120 mleft10">查询</button>
	         <button id="addBtn" type="submit" class="btn btn-default w120">新增</button>
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
				<fmt:message key="common.btn.edit"/></a>
			<c:if test="${loginUser.userId != userList.userId }">
				<a href="user_del.action?userId=${userList.userId}" class="delUser link">
					<fmt:message key="common.btn.delete"/></a>
			</c:if>	
		</display:column>
		
		<display:column title="备注">
			<div id="" class="popover-hide" 
			data-container="body" data-toggle="popover" data-placement="bottom" data-content="${userList.remark}"> 
			    <a>
			    	<label class="remarkLabel h20">${userList.remark}</label> 
			    </a>
	   		</div>
		</display:column>
		
	</display:table>
</div>
<hr class="solided notopMargin">
</body>
</html>