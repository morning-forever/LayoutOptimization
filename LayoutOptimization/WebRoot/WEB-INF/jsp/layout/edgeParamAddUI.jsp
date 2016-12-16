<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>添加管道</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/jquery.ui.draggable.js"charset="utf-8"></script>
<script language="javascript" src="JS/jquery.alerts.js" charset="utf-8"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="CSS/jquery.alerts.css" media="screen"/>
<link title="style1" rel="stylesheet"
	href="resources/css/form_style.css" type="text/css" />


<script type="text/javascript">
		function beforeSubmit(){
		try{
			var snode=jQuery("#snode").val();
			var enode=jQuery("#enode").val();
			var projectId=$("#projectId").val();
			
			if(snode>enode){
				jAlert("起始节点编号不能大于终止节点编号!","提示信息");
				return ;
			}else if(snode<=0||enode<=0){
				jAlert("节点编号只能大于0","提示信息");
				return ;
			}
			
			$.post("layout_nodeNotExist.action", {snode:snode,enode:enode,projectId:projectId},function(data,textStatus){
			if(data==4){
				jAlert("这根管道已存在！","提示信息");
			}else if(data==3){
				jAlert("这两个节点不存在！","提示信息");
			}else if(data==2){
				jAlert("终止节点不存在！","提示信息");
			}else if(data==1){
				jAlert("起始节点不存在！","提示信息");
			}else if(data==5){
				/* jQuery("#tijiao").disable=false; */
				jAlert("检查成功！","提示信息");
			}else if(data==6){
				jAlert("起始节点和终止节点不能相同！","提示信息");
			};
		});
		}catch(e){
			alert(e.message);
			return false;
		}
		return false;
		
		}
</script>
</head>
<body>
<script>
</script>
	&nbsp;

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="CSS/images/title_arrow.gif" /> 添加管道
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div class="form_content" id=MainArea>
		<form id="test" action="layout_saveEdgeParam.action" method="get">
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<input id="projectId" type="hidden" name="projectId" value="${project.projectId }">
					<fieldset>

						<div class="form-row">
							<div class="field-label">
								<label for="field2">管道起始节点编号</label>:
							</div>
							<div class="field-widget">
								<input name="snode" id="snode" class="required" title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field3">管道终止节点编号</label>:
							</div>
							<div class="field-widget">
								<input name="enode" id="enode" class="required" title="请输入" />
							</div>
						</div>
					</fieldset>

				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input id="tijiao" type="image" src="CSS/images/save.png" > <a
					onclick="beforeSubmit()" ><img src="CSS/images/goBack.png" />
				</a>
			</div>
		</form>
	</div>



</body>
</html>