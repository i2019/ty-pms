<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
	/** 编辑   **/
	$(".edit").fancybox({	
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : true,
	        'onClosed' : function() { 
	        	window.location.href = 'cause_list.action';
	        }
	 });
	/** 新增   **/
    $("#addBtn").fancybox({
    	'href'  : 'cause_edit.action',
    	'width' : 733,
        'height' : 530,
        'type' : 'iframe',
        'hideOnOverlayClick' : false,
        'showCloseButton' : true,
        'onClosed' : function() { 
        	window.location.href = 'cause_list.action';
        }
    });
});	
</script>
</head>
<body>
<hr class="solided notopMargin">
<form class="form-horizontal" role="form" method="post" action="cause_list.do">
       <div class="form-group">
           <label class="col-sm-2 text-muted control-label" for="ds_host">原因名称:</label>
           <div class="col-sm-3">
             <select id="causeCriteria_causeNameList" name="causeCriteria.causeNameList" class="mut_opt" multiple="multiple">
				<!-- 
				<c:forEach items="${causeList}" var="cause">	
					<option value="${cause.causeName}" 
					${fn:contains(causeCriteria.causeNameList, cause.causeName)?"selected":""}>${cause.causeName}</option>
				</c:forEach>
				 -->
				 <c:forEach items="${causeList}" var="cause">	
					<option value="${cause.causeName}">${cause.causeName}</option>
				</c:forEach>
			 </select>
           </div> 
           <label class="col-sm-2 text-muted control-label" for="ds_host">原因类型:</label>
           <div class="col-sm-3">
             <select id="causeCriteria_causeTypeList" name="causeCriteria.causeTypeList" class="mut_opt" multiple="multiple">	
				<c:forEach items="${causeTypeList}" var="causeType">	
					<option value="${causeType}" ${fn:contains(causeCriteria.causeTypeList, causeType)?"selected":""}>
					${causeType}
					</option>
				</c:forEach>
			 </select>
           </div>
       </div>
        <div class="form-group">
           <label class="col-sm-2 text-muted control-label" for="ds_host"><fmt:message key="business.criteria.remark"/></label>
           <div class="col-sm-3">
             <s:textfield name="cause.remark" cssClass="form-control w220" type="text"></s:textfield>
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
<div class="pannel_display">
	<display:table name="causeResult.resultList" id="causeList" sort="list" class="result_table" requestURI="" pagesize="20" size="causeResult.totalCount" partialList="true">
		<display:column property="causeName" title="原因名称" sortable="true"/>
		<display:column property="causeType" title="原因类别" sortable="true"/>
		
		<display:column titleKey="business.criteria.remark">
			<div id="" class="popover-hide" data-container="body" data-toggle="popover" data-placement="bottom" data-content="${causeList.remark}"> 
			    <a><label class="remarkLabel h20">${causeList.remark}</label></a></div></display:column>
		<display:column titleKey="business.criteria.operate">
			<a href="cause_edit.action?causeId=${causeList.causeId}" class="edit link mgR12"><fmt:message key="common.btn.edit"/></a>
			<a href="cause_del.action?causeId=${causeList.causeId}" class="del link"><fmt:message key="common.btn.delete"/></a>
		</display:column>	
	</display:table>
</div>
<hr class="solided notopMargin">
</body>
</html>