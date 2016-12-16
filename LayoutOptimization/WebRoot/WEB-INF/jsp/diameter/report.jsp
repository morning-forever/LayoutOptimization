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
<base href="<%=basePath%>">

<title>结果输出</title>
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
					src="CSS/images/title_arrow.gif" /> 结果输出
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td>方案编号</td>
					<td>工程编号</td>
					<td>方案</td>
					<td>年度折旧费用</td>
				</tr>
			</thead>
			<tbody id="TableData" class="dataContainer">
				
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<td>1</td>
						<td>1</td>
						<td>1,2,3,5,10,11,13,19,20</td>
						<td>60</td>
					</tr>
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<td>2</td>
						<td>1</td>
						<td>1,2,3,5,6,8,17,18,20</td>
						<td>70</td>
					</tr>
				
			</tbody>
			<%-- <!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
				<s:iterator value="#roleList">
					<tr class="TableDetail1 template">
						<td>${name}</td>
						<td>${description}</td>
						<td><s:a action="roleAction_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
							<s:a action="roleAction_editUI?id=%{id}">修改</s:a>
							<s:a action="roleAction_setPrivilegeUI?id=%{id}">设置权限</s:a> 
						</td>
					</tr>
				</s:iterator>
			</tbody> --%>
		</table>
		<div id="TableTail">
			
		</div>
	</div>
</body>
</html>

</html>
