<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" language="javascript">
function resizeFrame(){
    var vH=document.getElementById("middle").offsetHeight;
    var y=(parseInt(document.documentElement.clientHeight)-vH)/2;
    var vW=document.getElementById("middle").offsetWidth;
    var x=(parseInt(document.documentElement.clientWidth)-vW)/2;
    document.getElementById("middle").setAttribute("style", "margin-top:"+y+"px;margin-left:"+x+"px;");
}
window.onresize=resizeFrame;
window.onload=resizeFrame;
</script>
 <style>
	body {
		background: #e1c192 url(resources/images/form_page_bg.jpg) repeat;
	}
  </style>
</head> 
<body > 
<div id="middle" style="position:absolute;">
	<font>请先打开一个工程！</font>
</div>
</html>