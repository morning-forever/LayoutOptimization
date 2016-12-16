<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>工程列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="CSS/blue/pageCommon.css" />
<script type="text/javascript">
	
</script>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="CSS/images/title_arrow.gif" /> 工程列表
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
						<td><s:a action="project_openProject?id=%{id}">打开</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<a href="project_addUI.action"><img
					src="CSS/images/createNew.png" />
				</a>
			</div>
		</div>
	</div>
</body>
</html>
