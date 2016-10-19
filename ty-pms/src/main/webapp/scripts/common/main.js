
/* zTree插件加载目录的处理  */
var zTree;
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		//expandSpeed: ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast"
		expandSpeed: (false && parseInt($.browser.version)<=6)?"":"fast"
	},
	data: {
		key: {
			name: "name"
		},
		simpleData: {
			enable:true,
			idKey: "idKey",
			pIdKey: "pIdKey",
			rootPId: ""
		}
	},
	callback: {
		beforeExpand: beforeExpand,
		onExpand: onExpand,
		onClick: zTreeOnClick			
	}
};

/* 侧边栏 隐藏显示控制*/
$(function(){
	$('#TabPage2 li').click(function(){
		var index = $(this).index();
		$(this).find('img').attr('src', 'images/common/'+ (index+1) +'_hover.jpg');
		$(this).css({background:'#fff'});
		$('#nav_module').find('img').attr('src', 'images/common/module_'+ (index+1) +'.png');
		$('#TabPage2 li').each(function(i, ele){
			if( i!=index ){
				$(ele).find('img').attr('src', 'images/common/'+ (i+1) +'.jpg');
				$(ele).css({background:'#044599'});
			}
		});
		// 显示侧边栏
		switchSysBar(true);
	});
	
	// 显示隐藏侧边栏
	$("#show_hide_btn").click(function() {
        switchSysBar();
    });
});

var curExpandNode = null;
function beforeExpand(treeId, treeNode) {
	var pNode = curExpandNode ? curExpandNode.getParentNode():null;
	var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
	for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
		if (treeNode !== treeNodeP.children[i]) {
			zTree.expandNode(treeNodeP.children[i], false);
		}
	}
	while (pNode) {
		if (pNode === treeNode) {
			break;
		}
		pNode = pNode.getParentNode();
	}
	if (!pNode) {
		singlePath(treeNode);
	}

}

function singlePath(newNode) {
	if (newNode === curExpandNode) return;
	if (curExpandNode && curExpandNode.open==true) {
		if (newNode.parentTId === curExpandNode.parentTId) {
			zTree.expandNode(curExpandNode, false);
		} else {
			var newParents = [];
			while (newNode) {
				newNode = newNode.getParentNode();
				if (newNode === curExpandNode) {
					newParents = null;
					break;
				} else if (newNode) {
					newParents.push(newNode);
				}
			}
			if (newParents!=null) {
				var oldNode = curExpandNode;
				var oldParents = [];
				while (oldNode) {
					oldNode = oldNode.getParentNode();
					if (oldNode) {
						oldParents.push(oldNode);
					}
				}
				if (newParents.length>0) {
					for (var i = Math.min(newParents.length, oldParents.length)-1; i>=0; i--) {
						if (newParents[i] !== oldParents[i]) {
							zTree.expandNode(oldParents[i], false);
							break;
						}
					}
				}else {
					zTree.expandNode(oldParents[oldParents.length-1], false);
				}
			}
		}
	}
	curExpandNode = newNode;
}

function onExpand(event, treeId, treeNode) {
	curExpandNode = treeNode;
}

/** 用于捕获节点被点击的事件回调函数  **/
function zTreeOnClick(event, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("dleft_tab1");
	zTree.expandNode(treeNode, null, null, null, true);
	//zTree.expandNode(treeNode);
	// 规定：如果是父类节点，不允许单击操作
	if(treeNode.isParent){
		return false;
	}
	// 如果节点路径为空或者为"#"，不允许单击操作
	if(treeNode.accessPath=="" || treeNode.accessPath=="#"){
		return false;
	}
    // 跳到该节点下对应的路径
    rightMain(treeNode.accessPath);
	//window.location.href = treeNode.accessPath;  
};
		
/* 上方菜单 */
function switchTab(tabpage,tabid){
    var oItem = document.getElementById(tabpage).getElementsByTagName("li"); 
    for(var i=0; i<oItem.length; i++){
        var x = oItem[i];    
        x.className = "";
	}
	if('left_tab1' == tabid){
		$(document).ajaxStart(onStart).ajaxSuccess(onStop);
		// 异步加载"业务模块"下的菜单
	  	loadMenu('YEWUMOKUAI', 'dleft_tab1');
	}else  if('left_tab2' == tabid){
		$(document).ajaxStart(onStart).ajaxSuccess(onStop);
		// 异步加载"系统管理"下的菜单
		loadMenu('XITONGMOKUAI', 'dleft_tab2');
	}else  if('left_tab3' == tabid){
		$(document).ajaxStart(onStart).ajaxSuccess(onStop);
		// 异步加载"其他"下的菜单
		loadMenu('QITAMOKUAI', 'dleft_tab3');
	} 
}

/**隐藏或者显示侧边栏**/
function switchSysBar(flag){
	var side = $('#side');
    var left_menu_cnt = $('#left_menu_cnt');
	if( flag==true ){	// flag==true
		left_menu_cnt.show(500, 'linear');
		side.css({width:'280px'});
		$('#top_nav').css({width:'77%', left:'304px'});
    	$('#main').css({left:'280px'});
	}else{
        if ( left_menu_cnt.is(":visible") ) {
			left_menu_cnt.hide(10, 'linear');
			side.css({width:'60px'});
        	$('#top_nav').css({width:'100%', left:'60px', 'padding-left':'28px'});
        	$('#main').css({left:'60px'});
        	$("#show_hide_btn").find('img').attr('src', 'images/common/nav_show.png');
        } else {
			left_menu_cnt.show(500, 'linear');
			side.css({width:'280px'});
			$('#top_nav').css({width:'77%', left:'304px', 'padding-left':'0px'});
        	$('#main').css({left:'280px'});
        	$("#show_hide_btn").find('img').attr('src', 'images/common/nav_hide.png');
        }
	}
}

//ajax start function
function onStart(){
	$("#ajaxDialog").show();
}

//ajax stop function
function onStop(){
	//$("#ajaxDialog").dialog("close");
	$("#ajaxDialog").hide();
}

//菜单 增加菜单表 menu ajax请求菜单数据
function loadMenu(resourceType, treeObj){
 var data=null;
 //业务模块
 if('dleft_tab1' == treeObj){		
 data = [
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1,"resourceCode":"","resourceDesc":"","resourceGrade":2,"idKey":1121,"name":"理财记账","resourceOrder":0,"resourceType":""},
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1121,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":112131,"name":"基础设置","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112131,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11213141,"name":"资金单位","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112131,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11213142,"name":"产生事由","resourceOrder":0,"resourceType":""},
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1121,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":112132,"name":"收支记录","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112132,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11213241,"name":"收入记录","resourceOrder":0,"resourceType":""},
	{"accessPath":"expenditure_list.action","checked":false,"delFlag":0,"pIdKey":112132,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11213242,"name":"支出记录","resourceOrder":0,"resourceType":""},
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1121,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":112133,"name":"财务报表","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112133,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11213341,"name":"财务汇总报表","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112133,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11213342,"name":"财务详细报表","resourceOrder":0,"resourceType":""},
	
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1,"resourceCode":"","resourceDesc":"","resourceGrade":2,"idKey":1122,"name":"时间管理","resourceOrder":0,"resourceType":""},
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1122,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":112231,"name":"基础设置","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112231,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11223141,"name":"时间单位","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112231,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11223142,"name":"产生事由","resourceOrder":0,"resourceType":""},
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1122,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":112232,"name":"日程记录","resourceOrder":0,"resourceType":""},
	{"accessPath":"d2d_list.action","checked":false,"delFlag":0,"pIdKey":112232,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":2213241,"name":"日事记","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112232,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":2213242,"name":"大事记","resourceOrder":0,"resourceType":""},
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1122,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":112233,"name":"时间报表","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112233,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11223341,"name":"时间汇总报表","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112233,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11223342,"name":"时间详细报表","resourceOrder":0,"resourceType":""},

	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1,"resourceCode":"","resourceDesc":"","resourceGrade":2,"idKey":1123,"name":"健康管理","resourceOrder":0,"resourceType":""},
	
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1123,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":112331,"name":"健康记录","resourceOrder":0,"resourceType":""},
	{"accessPath":"","checked":false,"delFlag":0,"pIdKey":112331,"resourceCode":"","resourceDesc":"","resourceGrade":4,"idKey":11223141,"name":"小红","resourceOrder":0,"resourceType":""},
	];
		 
	 $("#dleft_tab1").show();
	 $("#dleft_tab2").hide();
	 $("#dleft_tab3").hide();
	 
	 //系统管理
	}else  if('dleft_tab2' == treeObj){
						
		 data = [
			{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1,"resourceCode":"","resourceDesc":"","resourceGrade":2,"idKey":2221,"name":"用户管理","resourceOrder":0,"resourceType":""},
			{"accessPath":"user_list.action","checked":false,"delFlag":0,"pIdKey":2221,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":222131,"name":"系统用户","resourceOrder":0,"resourceType":""},
			{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":2222,"name":"系统配置","resourceOrder":0,"resourceType":""},
			{"accessPath":"menu_list.action","checked":false,"delFlag":0,"pIdKey":2222,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":22213241,"name":"菜单管理","resourceOrder":0,"resourceType":""},
			];
		 
		 $("#dleft_tab2").show();
		 $("#dleft_tab1").hide();
		 $("#dleft_tab3").hide();
	//其他
	}else  if('dleft_tab3' == treeObj){
		
		 data = [
			{"accessPath":"","checked":false,"delFlag":0,"pIdKey":1,"resourceCode":"","resourceDesc":"","resourceGrade":2,"idKey":3321,"name":"个人积累","resourceOrder":0,"resourceType":""},
			{"accessPath":"","checked":false,"delFlag":0,"pIdKey":3321,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":332131,"name":"学习日志","resourceOrder":0,"resourceType":""},
			{"accessPath":"","checked":false,"delFlag":0,"pIdKey":3321,"resourceCode":"","resourceDesc":"","resourceGrade":3,"idKey":332132,"name":"分享资源","resourceOrder":0,"resourceType":""},
		];
		 
		 $("#dleft_tab3").show();
		 $("#dleft_tab1").hide();
		 $("#dleft_tab2").hide();
	} 
	
	// 如果返回数据不为空，加载"业务模块"目录
	if(data != null){
	
	    // 将返回的数据赋给zTree
	    $.fn.zTree.init($("#"+treeObj), setting, data);
	    zTree = $.fn.zTree.getZTreeObj(treeObj);
	    if( zTree ){
	        // 默认展开所有节点
	       //  zTree.expandAll(true);
	    }
	}	
       
}
