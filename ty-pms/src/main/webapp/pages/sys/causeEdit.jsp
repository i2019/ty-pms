<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript">
$(document).ready(function() {
	$("#cancelbutton").click(function() {
		window.parent.$.fancybox.close();/**  关闭弹出iframe  **/
	});
	$("#submitbutton").click(function() {
		window.parent.$.fancybox.close();
		$('#editForm').submit();
	});
	
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
	
	/*时间控件*/
	 $(".timeformat1").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true  
	 });
});
</script>
</head>
<body>
<div id="container" class="center-in-center">
 <form class="form-horizontal" action="cause_save.action" id="editForm" method="post">
 	   <s:hidden name="cause.causeId"></s:hidden>
 	    <div class="form-group">
           <label class="text-muted col-sm-3 control-label" for="ds_host">原因类别:</label>
           <div class="col-sm-10">
		  	 <select id="cause_causeType" name="cause.causeType" class="mut_opt">
				<c:forEach items="${causeTypeList}" var="causeType">	
					<option value="${causeType}" ${fn:contains(cause.causeType, causeType)?"selected":""}>
						<c:choose> 
						  <c:when test="${empty causeType}">   
						           无可用选项
						  </c:when> 
						  <c:when test="${causeType==1}">   
						   	 消费原因
						  </c:when> 
						    <c:when test="${causeType==2}">   
						   	 收入原因
						  </c:when> 
						    <c:when test="${causeType==3}">日事原因</c:when> 
						  <c:otherwise>其他原因</c:otherwise> 
						</c:choose>
					</option>
				</c:forEach>
			 </select>
		   </div>
       </div>
 	    <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">原因名称:</label>
           <div class="col-sm-2">
           	 <s:textarea type="text" id="cause_causeName" name="cause.causeName" class="text_value"/>	
           </div>
       </div>
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">原因备注:</label>
           <div class="col-sm-2">
           	 <s:textarea type="text" id="cause_remark" name="cause.remark" class="text_value"/>	
           </div>
       </div>
       <hr class="solided notopMargin">
       <div class="form-group">
	      <div class="col-sm-offset-4 col-sm-10">
	         <button id="submitbutton" class="btn btn-default w120 mleft10">提交</button>	
	         <button id="cancelbutton" class="btn btn-default w120">取消</button>	
	      </div>
  	 </div>
</form>
</div>
</body>
</html>