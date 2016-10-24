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
	$('#day2Day_owner').multiselect({
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
 <form class="form-horizontal" action="d2d_save.action" id="editForm" method="post">
 		<s:hidden name="day2Day.d2Id"></s:hidden>
 		<!-- 用户 -->
        <div class="form-group">
           <label class="text-muted col-sm-2 control-label" for="ds_host">用户:</label>
           <div class="col-sm-10">
		  	  <select id="day2Day_owner" name="day2Day.owner" class="mut_opt">
					<c:forEach items="${userList}" var="user">	
						<option value="${user.userId}" ${fn:contains(day2Day.owner, user.userId)?"selected":""}>${user.userName}</option>
					</c:forEach>
			 </select>
		   </div>
       </div>
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">发生时间 :</label>
           <div class="col-sm-2">
           		<input id="day2Day_occurrencedTime" name="day2Day.occurrencedTime" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${day2Day.occurrencedTime}' pattern='yyyy-MM-dd HH:mm'/>">
           </div>
       </div>
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">结束时间 :</label>
           <div class="col-sm-2">
           		<input id="day2Day_endTime" name="day2Day.endTime" class="timeformat1 form-control w220" 
							value="<fmt:formatDate value='${day2Day.endTime}' pattern='yyyy-MM-dd HH:mm'/>">
       	   </div>
       </div>
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">原因:</label>
           <div class="col-sm-2">
           	 <s:textarea type="text" id="day2Day_d2Descrip" name="day2Day.d2Descrip" class="text_value"/>	
           </div>
       </div>
       <div class="form-group">
           <label class="text-muted col-sm-1 control-label" for="ds_host">备注:</label>
           <div class="col-sm-2">
           	 <s:textarea type="text" id="day2Day_remark" name="day2Day.remark" class="text_value"/>	
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