<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>区域供热供冷优化与设计系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="home_top.action" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="248,*" id="resize">
        <frame noresize name="menu" src="home_left.action" scrolling="no" />
        <frame noresize name="right" src="home_right.action" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="home_bottom.action" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>