<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新建工程</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/jquery.ui.draggable.js"charset="utf-8"></script>
<script language="javascript" src="JS/jquery.alerts.js" charset="utf-8"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="CSS/jquery.alerts.css" media="screen"/>
<link type="text/css" rel="stylesheet" href="CSS/blue/pageCommon.css" />
<script type="text/javascript">
	function delete_confirm(id) {
		jConfirm('您确定删除该工程？', '提示信息', function(r) {
			if(r){
				window.location.href="project_delete.action?id="+id;
			}
		});
	}
</script>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="CSS/images/title_arrow.gif" /> 新建工程
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td>工程编号</td>
					<td>工程名称</td>
					<td>工程类型</td>
					<td>操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
				<s:iterator value="#request.projects" status="status">
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<td>${projectId}</td>
						<td>${projectName}</td>
						<td>${projectKind}</td>
						<td><a onclick="delete_confirm(${id})">删除</a> <s:a
								action="project_editUI?id=%{id}">修改</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="project_addUI.action"><img src="CSS/images/createNew.png" /></a>
			</div>
		</div>
	</div>
</body>
</html>
