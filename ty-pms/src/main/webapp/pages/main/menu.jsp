<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/style.jsp"%>
<!DOCTYPE html>
<HTML>
<HEAD>
	<TITLE>PMS-Menu</TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link href="tools/zTree_v3-master/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">

	//配置
	var setting = {
			async: {
				enable: true,
				url: "menu_list.action",
				contentType: "application/json",
				dataType: "text",
				type: "post",
				autoParam: ["id", "name","pId","url","open","iconSkin"]
				
			},
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				drag: {
					autoExpandTrigger: true,
					prev: dropPrev,
					inner: dropInner,
					next: dropNext
				},
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			data: {
				simpleData: {
					enable: false
				},
				key: {
					name: "name",
					url : "url"
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRename: zTreeOnRename
			}
		};
		//节点数据 json
		var zNodes =[
			{ id:111, pId:0, url: "user_list2222.action",name:"父节点 1", open:true,iconSkin:"pIcon01"}
			/* 
			,
			{ id:11, pId:1, name:"叶子节点 1-1",iconSkin:"pIcon01"},
			{ id:12, pId:1, name:"叶子节点 1-2",iconSkin:"pIcon01"},
			{ id:13, pId:1, name:"叶子节点 1-3",iconSkin:"pIcon01"},
			{ id:2, pId:0, name:"父节点 2", open:true,iconSkin:"pIcon01"},
			{ id:21, pId:2, name:"叶子节点 2-1",iconSkin:"pIcon01"},
			{ id:22, pId:2, name:"叶子节点 2-2",iconSkin:"pIcon01"},
			{ id:23, pId:2, name:"叶子节点 2-3",iconSkin:"pIcon01"},
			{ id:3, pId:0, name:"父节点 3", open:true,iconSkin:"pIcon01"},
			{ id:31, pId:3, name:"叶子节点 3-1",iconSkin:"pIcon01"},
			{ id:32, pId:3, name:"叶子节点 3-2",iconSkin:"pIcon01"},
			{ id:33, pId:3, name:"叶子节点 3-3",iconSkin:"pIcon01"}
			*/
		];
		
		//确认框
		function beforeEditName(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeMenu");
			zTree.selectNode(treeNode);
			return confirm("进入节点[ " + treeNode.name + " ]的编辑状态吗？");
		}
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeMenu");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 [ " + treeNode.name + " ]吗？");
		}
		function beforeRename(treeId, treeNode, newName, isCancel) {
			if (newName=="" || newName.length == 0) {
				alert("节点名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeMenu");
				setTimeout(function(){zTree.editName(treeNode)}, 10);
				return false;
			}
			return true;
		}
		//新增 重命名 删除 拖拽
		function showRemoveBtn(treeId, treeNode) {
			//return !treeNode.isFirstNode;//第一个节点不可删除
			return (treeNode.id!=111); //顶级父节点 不可 删除
		}
		function showRenameBtn(treeId, treeNode) {
			//return !treeNode.isLastNode; //最后一个节点不可重命名
			return (treeNode.id!=111); //顶级父节点 不可 重命名
		}
		function zTreeOnRename(event, treeId, treeNode, isCancel) {
			var path=prompt("链接地址:",treeNode.url)
			treeNode.url=path;
			alert(treeNode.id);
		}
		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='新增子节点' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeMenu");
				var path=prompt("请输入节点链接地址:","");
				var name=prompt("请输入节点名称:","")
				zTree.addNodes(treeNode, { id:getRadomNum32(), pId:treeNode.id, name:name ,url:path });
				
				//zTree为json对象数组 提交到后台
				$("#menu").val(zTree);
				var menus=$("#menu").val();
				debugger;
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};
		function dropPrev(treeId, nodes, targetNode) {
			var pNode = targetNode.getParentNode();
			if (pNode && pNode.dropInner === false) {
				return false;
			} else {
				for (var i=0,l=curDragNodes.length; i<l; i++) {
					var curPNode = curDragNodes[i].getParentNode();
					if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
						return false;
					}
				}
			}
			return true;
		}
		function dropInner(treeId, nodes, targetNode) {
			if (targetNode && targetNode.dropInner === false) {
				return false;
			} else {
				for (var i=0,l=curDragNodes.length; i<l; i++) {
					if (!targetNode && curDragNodes[i].dropRoot === false) {
						return false;
					} else if (curDragNodes[i].parentTId && curDragNodes[i].getParentNode() !== targetNode && curDragNodes[i].getParentNode().childOuter === false) {
						return false;
					}
				}
			}
			return true;
		}
		function dropNext(treeId, nodes, targetNode) {
			var pNode = targetNode.getParentNode();
			if (pNode && pNode.dropInner === false) {
				return false;
			} else {
				for (var i=0,l=curDragNodes.length; i<l; i++) {
					var curPNode = curDragNodes[i].getParentNode();
					if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
						return false;
					}
				}
			}
			return true;
		}
		function beforeDrag(treeId, treeNodes) {
		
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					curDragNodes = null;
					return false;
				} else if (treeNodes[i].parentTId && treeNodes[i].getParentNode().childDrag === false) {
					curDragNodes = null;
					return false;
				}
			}
			curDragNodes = treeNodes;
			return true;
		}
	
		$(document).ready(function(){
			$.fn.zTree.init($("#treeMenu"), setting, zNodes);
			

			function ajaxUpdateMenu(zTree){
				$.ajax({
				   	 type:"POST",
				   	 async:false,
				     dataType : "json",
				   	 url:"menu_list.acton",
				   	 data:{"menu":zTree},
					 success:function(data){
						   
				     }
			    });
			}
			
		});
		//-->
	</SCRIPT>

	<style type="text/css">
	    /*.pIcon01 图标  open和close*/
		.ztree li span.button.pIcon01_ico_open{
			margin-right:2px; 
			background: url(tools/zTree_v3-master/css/metroStyle/img/diy/1_open.png) no-repeat scroll 0 0 transparent; 
			vertical-align:top; 
			*vertical-align:middle
		}
		.ztree li span.button.pIcon01_ico_close
			{margin-right:2px; 
			background: url(tools/zTree_v3-master/css/metroStyle/img/diy/1_close.png) no-repeat scroll 0 0 transparent; 
			vertical-align:top; 
			*vertical-align:middle
		}
		/*操作面板 */
		div.content_wrap {width: 900px;height:500px;}
		ul.ztree {
		    width: 800px;
		    height: 500px;
		}
		 /*字体大小*/
		.ztree * {
		    padding: 2;
		    margin: 3;
		    font-size: 20px;
		    font-family: Verdana, Arial, Helvetica, AppleGothic, sans-serif;
		}
	</style>
	
</HEAD>

<BODY>

<hr class="solided notopMargin">
<div class="center">
	<form class="form-horizontal" role="form" action="menu_list.action">
			<input type="text" id="menu" name="menu">
	       <div class="form-group">
	        	<div class="content_wrap">
					<div class="ztree_content">
						<ul id="treeMenu" class="ztree"></ul>
					</div>
				</div>
	       </div>
	       <hr class="solided notopMargin">
	       <div class="form-group">
				<button type="submit" class="btn btn-default w120">保存</button>
	  	 </div>
	</form>
</div>
<hr class="solided notopMargin">


</BODY>
</HTML>