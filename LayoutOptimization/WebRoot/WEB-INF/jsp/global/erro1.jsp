<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../public/common.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<TITLE>没有权限</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="text/css" rel="stylesheet" href="CSS/blue/menu.css" />
	</head>
	
	<BODY>
	
		<DIV ID="Title_bar">
		    <DIV ID="Title_bar_Head">
		        <DIV ID="Title_Head"></DIV>
		        <DIV ID="Title"><!--页面标题-->
		            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="CSS/images/title_arrow.gif"/> 提示
		        </DIV>
		        <DIV ID="Title_End"></DIV>
		    </DIV>
		</DIV>
		
		
		<!--显示表单内容-->
		<DIV ID="MainArea">
				<DIV CLASS="ItemBlock_Title1">
		        </DIV> 
		
		        <DIV CLASS="ItemBlockBorder" STYLE="margin-left: 15px;">
		            <DIV CLASS="ItemBlock" STYLE="text-align: center; font-size: 16px; font:italic;">
		             	请先打开一个工程
		            </DIV>
		        </DIV>
		        
		        <!-- 操作 -->
		        <DIV ID="InputDetailBar">
		            <A HREF="javascript:history.go(-1);"><IMG SRC="CSS/images/goBack.png"/></A>
		        </DIV>
		    
		</DIV>
	
	</BODY>
</html>
