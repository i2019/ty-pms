<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
input.calendar{background-repeat: no-repeat; background-position: 96% 4px;}

</style>

<script type="text/javascript">

$(document).ready(function(){
	$(function () { $(".popover-hide").popover();});
	/*复选框*/
	$('.mut_opt').multiselect({
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
	 $(".timeformat1").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true
	 });	
	/** 编辑   **/
	$(".edit").fancybox({	
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : true,
	        'onClosed' : function() { 
	        	window.location.href = 'd2d_list.action';
	        }
	 });
	/** 新增   **/
    $("#addBtn").fancybox({
    	'href'  : 'd2d_edit.action',
    	'width' : 733,
        'height' : 530,
        'type' : 'iframe',
        'hideOnOverlayClick' : false,
        'showCloseButton' : true,
        'onClosed' : function() { 
        	window.location.href = 'd2d_list.action';
        }
    });
});	
</script>
</head>
<body>
<hr class="solided notopMargin">
<form class="form-horizontal" role="form" method="post" action="d2d_list.do">
        <div class="form-group">
           <!-- 发生开始时间-->
           <label class="col-sm-2 text-muted control-label" for="ds_name">
           		<fmt:message key="business.criteria.occurrencedTimeBegin"/>
           </label>
           <div class="col-sm-3">
             <input id="day2DayCriteria_occurrencedTimeBegin" name="day2DayCriteria.occurrencedTimeBegin" class="timeformat1 form-control w220" 
				value="<fmt:formatDate value='${day2DayCriteria.occurrencedTimeBegin }' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
           <!-- 发生结束时间 -->
           <label class="col-sm-2 text-muted control-label" for="ds_name">
           		 <fmt:message key="business.criteria.occurrencedTimeEnd"/>
           </label>
           <div class="col-sm-3"> 
           <input id="day2DayCriteria_occurrencedTimeEnd" name="day2DayCriteria.occurrencedTimeEnd" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${day2DayCriteria.occurrencedTimeEnd }' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
       </div>
        <div class="form-group">
           <!-- 创建开始时间-->
           <label class="col-sm-2 text-muted control-label" for="ds_name">
           		<fmt:message key="business.criteria.createdTimeBegin"/>
           </label>
           <div class="col-sm-3">
             <input id="day2DayCriteria_createdTimeBegin" name="day2DayCriteria.createdTimeBegin" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${day2DayCriteria.createdTimeBegin }' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
           <!-- 创建结束时间 -->
           <label class="col-sm-2 text-muted control-label" for="ds_name">
           		 <fmt:message key="business.criteria.createdTimeEnd"/>
           </label>
           <div class="col-sm-3">
           <input id="day2DayCriteria_createdTimeEnd" name="day2DayCriteria.createdTimeEnd" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${day2DayCriteria.createdTimeEnd }' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
       </div>
       
       <div class="form-group">
            <!-- 描述 -->
           <label class="col-sm-2 text-muted control-label" for="ds_host">
           		<fmt:message key="business.criteria.descript"/>
           </label>
           <div class="col-sm-3">
             <select id="day2DayCriteria_d2DescripList" name="day2DayCriteria.d2DescripList" class="mut_opt" multiple="multiple">
					<c:forEach items="${causeList}" var="cause">	
						<option value="${cause.causeId}" 
						${fn:contains(day2DayCriteria.d2DescripList, cause.causeId)?"selected":""}>${cause.causeName}</option>
					</c:forEach>
			 </select>
           </div>
            <!-- 备注 -->
           <label class="col-sm-2 text-muted control-label" for="ds_host">
           		<fmt:message key="business.criteria.remark"/>
           </label>
           <div class="col-sm-3">
             <s:textfield name="day2DayCriteria.remark" cssClass="form-control w220" type="text"></s:textfield>
           </div>
       </div>
       <div class="form-group">
       		<!-- 用户名 -->
           <label class="text-muted col-sm-2 control-label" for="ds_host"><fmt:message key="common.user.userName"/>:</label>
           <div class="col-sm-2">
              <select id="day2DayCriteria_ownerList" name="day2DayCriteria.ownerList" class="mut_opt" multiple="multiple">
					<c:forEach items="${userList}" var="user">	
						<option value="${user.userId}" 
						${fn:contains(day2DayCriteria.ownerList, user.userId)?"selected":""}>${user.userName}</option>
					</c:forEach>
			 </select>
           </div>
       </div>
       <hr class="solided notopMargin">
       <div class="form-group">
	      <div class="col-sm-offset-4 col-sm-10">
	         <button id="submitBtn" type="submit" class="btn btn-default w120 mleft10"><fmt:message key="common.btn.search"/></button>
	         <button id="addBtn" type="submit" class="btn btn-default w120"><fmt:message key="common.btn.add"/></button>
	      </div>
  	 </div>
</form>
<hr class="solided notopMargin">
<!--列表样式-->
<div class="pannel_display">
	<display:table name="day2DayResult.resultList" id="day2DayList" sort="list" 
		class="result_table" requestURI="" pagesize="20" size="day2DayResult.totalCount" partialList="true">
		<display:setProperty name="sort.amount" value="list" />
		<display:column property="owner" titleKey="common.user.userName" sortable="true"/>
		<display:column property="occurrencedTime" titleKey="business.criteria.occurrencedTime" format="{0,date,yyyy-MM-dd HH:mm:ss}" sortable="true"/>
		<display:column property="endTime" titleKey="business.criteria.endTime" format="{0,date,yyyy-MM-dd HH:mm:ss}" sortable="true"/>
		<display:column titleKey="business.criteria.descript">
			<div id="" class="popover-hide" 
			data-container="body" data-toggle="popover" data-placement="bottom" data-content="${day2DayList.d2Descrip}"> 
			    <a><label class="remarkLabel h20">${day2DayList.d2Descrip}</label></a>
	   		</div>
		</display:column>
		<display:column titleKey="business.criteria.remark">
			<div id="" class="popover-hide" 
			data-container="body" data-toggle="popover" data-placement="bottom" data-content="${day2DayList.remark}"> 
			    <a><label class="remarkLabel h20">${day2DayList.remark}</label></a>
	   		</div>
		</display:column>
		<display:column titleKey="business.criteria.operate">
			<a href="d2d_edit.action?d2Id=${day2DayList.d2Id}" class="edit link mgR12">
				<fmt:message key="common.btn.edit"/>
			</a>
			<a href="d2d_del.action?d2Id=${day2DayList.d2Id}" class="del link">
				<fmt:message key="common.btn.delete"/>
			</a>
		</display:column>	
	</display:table>
</div>
<hr class="solided notopMargin">
</body>
</html>