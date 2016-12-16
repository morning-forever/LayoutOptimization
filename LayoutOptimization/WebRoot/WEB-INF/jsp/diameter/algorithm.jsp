<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>布局优化遗传运算</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="JavaScript" src="JS/jquery.js"></script>

  <link rel="stylesheet" type="text/css" href="resources/css/calc_style.css" />
   
  <style>
	body {
		background: #e1c192 url(resources/images/form_page_bg.jpg) repeat;
	}
  </style>
</head>
<script>
	function start() {
		var start = document.getElementById("start");
		start.innerHTML = "暂停";
		var status = document.getElementById("status");
		status.innerHTML = "正在计算，请等待...";
		$.ajax({
		type : "POST",
		url : "layout_calculate.action",
		success : function(msg) {
			status.innerHTML="管网布局优化计算完成，请点击<a href=''>下一步</a>查看结果！";
			start.innerHTML="启动";
		}
		});
	}
</script>
<body>
	<br>
	<br>
	<body>
        <div class="container">
			<section class="main">
				<form class="form-2">
				
					<h1><span id="status" class="log-in">正在进行遗传运算，请等待....</span></h1>
					<p class="float">
						<label for="login"><i class="icon-user"></i>&nbsp</label>
						<label for="login"><i class="icon-user"></i>&nbsp</label>
						<label for="login"><i class="icon-user"></i>&nbsp</label>
					</p>
					<p class="float">
						<label for="password"><i class="icon-lock"></i>&nbsp</label>
						<label for="login"><i class="icon-user"></i>&nbsp</label>
						<label for="login"><i class="icon-user"></i>&nbsp</label>
					</p>
					<p class="clearfix"> 
						<button id="start" class="start-calc" onclick="start()">启动</button>
						<button id="stop"  class="stop-calc" >终止</button>
					</p>
				</form>
			</section>
        </div>
    </body>
</body>
</html>
