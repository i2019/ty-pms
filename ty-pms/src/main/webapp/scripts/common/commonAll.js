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

//生成32位随机数字
function getRadomNum32(){
	//获取16位随机数
	var random='';
	for(var i=0;i<16;i++) { 
		/*
		 1.Math.random(); 结果为0-1间的一个随机数(包括0,不包括1) 
		 2.Math.floor(num); 参数num为一个数值，函数结果为num的整数部分。 
		 */
		random+=Math.floor(Math.random()*10); 
	} 
	//获取16位时间
	var date = new Date();
	this.year = date.getFullYear();
	this.month = date.getMonth() < 10 ? "0" + date.getMonth() : date.getMonth();
	this.date = date.getDate();
	this.day = "0"+date.getDay(); //星期
	this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
	var currentTime =this.year+this.month + this.date + this.hour + this.minute + this.second + this.day;
	//组合数据
	var num = currentTime + random;
	return num;
}

