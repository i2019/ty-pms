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
	$('#expenditureCriteria_ownerList').multiselect({
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
	 $(".timeformat1").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true  
	 });
	
	/** 编辑   **/
	$(".edit").fancybox({	
			//'href'  : 'user_edit.action?userId='+$(this).attr("id"),
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : true,
	        'onClosed' : function() { 
	        	window.location.href = 'expenditure_list.action';
	        }
	 });
	
	/** 新增   **/
    $("#addBtn").fancybox({
    	'href'  : 'expenditure_edit.action',
    	'width' : 733,
        'height' : 530,
        'type' : 'iframe',
        'hideOnOverlayClick' : false,
        'showCloseButton' : true,
        'onClosed' : function() { 
        	window.location.href = 'expenditure_list.action';
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
           <label class="text-muted col-sm-2 control-label" for="ds_host">支出用户:</label>
           <div class="col-sm-3">
              <select id="expenditureCriteria_ownerList" name="expenditureCriteria.ownerList" class="mut_opt" multiple="multiple">
					<c:forEach items="${ownerList}" var="userName">	
						<option value="${userName}" 
						${fn:contains(expenditureCriteria.ownerList, userName)?"selected":""}>${userName}</option>
					</c:forEach>
			 </select>
           </div>
            <!-- 备注 -->
           <label class="col-sm-2 text-muted control-label" for="ds_host">支出原因说明:</label>
           <div class="col-sm-3">
             <s:textfield name="expenditureCriteria.remark" cssClass="form-control w220" type="text"></s:textfield>
           </div>
       </div>
       <div class="form-group"> 	  
            <!-- 支出金额 -->
           <label class="col-sm-2 text-muted control-label" for="ds_host">支出金额开始:</label>
           <div class="col-sm-3">
             <s:textfield name="expenditureCriteria.expenditureAmountBegin" cssClass="form-control w220" type="text"></s:textfield>
           </div>
           <label class="col-sm-2 text-muted control-label" for="ds_host">支出金额结束:</label>
           <div class="col-sm-3">
             <s:textfield name="expenditureCriteria.expenditureAmountEnd" cssClass="form-control w220" type="text"></s:textfield>
           </div>
       </div>
       <!-- 支出时间-->
       <div class="form-group">
           <label class="col-sm-2 text-muted control-label" for="ds_name">支出发生时间开始:</label>
           <div class="col-sm-3">
             <input id="expenditureCriteria_occurrencedTimeBegin" name="expenditureCriteria.occurrencedTimeBegin" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.occurrencedTimeBegin}' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
            <label class="col-sm-2 text-muted control-label" for="ds_name">支出发生时间结束:</label>
            <div class="col-sm-3">
              <input id="expenditureCriteria_occurrencedTimeEnd" name="expenditureCriteria.occurrencedTimeEnd" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.occurrencedTimeEnd}' pattern='yyyy-MM-dd HH:mm'/>">
            </div>
       </div>
       <div class="form-group">
           <label class="col-sm-2 text-muted control-label" for="ds_name">支出结束时间开始:</label>
           <div class="col-sm-3">
             <input id="expenditureCriteria_endTimeBegin" name="expenditureCriteria.endTimeBegin" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.endTimeBegin}' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
            <label class="col-sm-2 text-muted control-label" for="ds_name">支出结束时间结束:</label>
            <div class="col-sm-3">
              <input id="expenditureCriteria_endTimeEnd" name="expenditureCriteria.endTimeEnd" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${expenditureCriteria.endTimeEnd }' pattern='yyyy-MM-dd HH:mm'/>">
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

<div class="pannel_display">
	<display:table name="expenditureResult.resultList" id="expenditureList" sort="list" class="result_table" requestURI="" pagesize="20" size="expenditureResult.totalCount" partialList="true">
		<display:setProperty name="sort.amount" value="list" />
		
		<display:column property="owner" title="支出用户"/>
		<display:column property="expenditureAmount" sortable="true" title="支出金额"/>
		<!-- titleKey="ccm.ReservationUpdateDate"  -->
		<display:column property="occurrencedTime" title="支出开始时间" sortable="true" format="{0,date,yyyy-MM-dd HH:mm:ss}" headerClass="sorted" class="scroll-content-item"/>
		<display:column property="endTime" title="支出结束时间" sortable="true" format="{0,date,yyyy-MM-dd HH:mm:ss}" headerClass="sorted" class="scroll-content-item"/>
		<display:column title="支出原因说明">
			<div class="popover-hide" data-container="body" data-toggle="popover" data-placement="bottom" data-content="${userList.remark}"> 
			    <a><label class="remarkLabel h20">${expenditureList.remark}</label></a>
	   		</div>
		</display:column>
		<display:column title="操作">
			<a href="expenditure_edit.action?expenditureId=${expenditureList.expenditureId}" class="edit link mgR12">
				<fmt:message key="common.btn.edit"/></a>
			<a href="expenditure_del.action?expenditureId=${expenditureList.expenditureId}" class="del link">
				<fmt:message key="common.btn.delete"/></a>
		</display:column>
		
	</display:table>
</div>
<hr class="solided notopMargin">
</body>
</html>