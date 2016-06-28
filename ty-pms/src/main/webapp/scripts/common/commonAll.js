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

