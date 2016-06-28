/**菜单跳转**/
function rightMain(url){
	$('#rightMain').attr('src', url);
}

/**退出系统**/
function logout(){
	if(confirm("您确定要退出本系统吗？")){
		window.location.href = "logout.jsp";
	}
}

/**获得当前日期**/
function  getDateNow(){
	var time = new Date();
	var myYear = time.getFullYear();
	var myMonth = time.getMonth()+1;
	var myDay = time.getDate();
	if(myMonth < 10){
		myMonth = "0" + myMonth;
	}
	document.getElementById("day_day").innerHTML =  myYear + "." + myMonth + "." + myDay;
}		


/** 日期函数，加几天，减几天 **/
function getNextDay(dd, dadd) {
	// 可以加上错误处理
	var a = new Date(dd);
	a = a.valueOf();
	a = a + dadd * 24 * 60 * 60 * 1000;
	a = new Date(a);
	var m = a.getMonth() + 1;
	if (m.toString().length == 1) {
		m = '0' + m;
	}
	var d = a.getDate();
	if (d.toString().length == 1) {
		d = '0' + d;
	}
	return a.getFullYear() + "-" + m + "-" + d;
}
