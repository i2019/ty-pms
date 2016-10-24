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
	$('#expenditure_owner').multiselect({
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
 <form class="form-horizontal" action="expenditure_save.action" id="editForm" method="post">
 		<s:hidden name="expenditure.expenditureId"></s:hidden>
 		<!-- 支出用户 -->
        <div class="form-group">
           <label class="text-muted col-sm-2 control-label" for="ds_host">支出用户:</label>
           <div class="col-sm-10">
           	  <!-- 
              <s:textfield type="text" id="expenditure_owner" name="expenditure.owner" class="text_value"/>	
		  	  -->
		  	  <select id="expenditure_owner" name="expenditure.owner" class="mut_opt">
					<c:forEach items="${ownerList}" var="userName">	
						<option value="${userName}" 
						${fn:contains(expenditure.owner, userName)?"selected":""}>${userName}</option>
					</c:forEach>
			 </select>
		   </div>
       </div>
       <!-- 支出金额 -->
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">支出金额 :</label>
           <div class="col-sm-2">
           		<s:textfield type="text" id="expenditure_expenditureAmount" name="expenditure.expenditureAmount" class="text_value"/>元
           </div>
       </div>
       <!-- 支出开始时间 支出结束时间 -->
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">支出开始时间 :</label>
           <div class="col-sm-2">
           		<input id="expenditure_occurrencedTime" name="expenditure.occurrencedTime" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${expenditure.occurrencedTime}' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
       </div>
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">支出结束时间 :</label>
           <div class="col-sm-2">
           		<input id="expenditure_endTime" name="expenditure.endTime" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${expenditure.endTime}' pattern='yyyy-MM-dd HH:mm'/>">
       	   </div>
       </div>
           
       <!-- 支出原因说明 -->
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">支出原因说明:</label>
           <div class="col-sm-2">
           	 <s:textarea type="text" id="expenditure_remark" name="expenditure.remark" class="text_value"/>	
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



