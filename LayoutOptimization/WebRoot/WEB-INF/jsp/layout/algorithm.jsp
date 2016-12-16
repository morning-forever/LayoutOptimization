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

<title>布局优化遗传运算</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page"> -->

  <script language="javascript" src="JS/jquery.js"></script>

  <link rel="stylesheet" type="text/css" href="resources/css/calc_style.css" />
   
  <style>
	body {
		background: #e1c192 url(resources/images/form_page_bg.jpg) repeat;
	}
  </style>
</head>
<script type="text/javascript">
	function myStart(){
		/* var start=$("#start").val(); */
		var projectId=${project.projectId};
		
		$.post("layout_calculate.action", {projectId:projectId},function(data,textStatus){
			
		});
     /*   alert("点了");
      var params = $('#userform').serialize();//利用jquery将表单序列化
      //jquery发送ajax请求
      $.ajax({
        url: '/LayoutOptimization/myCalculate.action',
        type: 'post',
        dataType: 'json',
        data: params,
        success: doCheckSuccess
      });
    } */
    /* function doCheckSuccess(data){
      //start.innerHTML = "暂停";
       alert(data.success); */
     /* var start = document.getElementById("start");
	start.innerHTML = "暂停";
	var status = document.getElementById("status");
	status.innerHTML = "正在计算，请等待..."; */
    }
</script>
<script>
	/* function startFunc() {
		var start = document.getElementById("start");
		start.innerHTML = "暂停";
		var status = document.getElementById("status");
		status.innerHTML = "正在计算，请等待..."; */
		/* $.post("layout_calculate.action",{a:5},function(data,textStatus){
			alert(data);
		},"text");
		 */
			
		
		/* $.ajax({
		type : "POST",
		data :"a=5",
		url : "layout_calculate.action",
		success : function(msg) {
			if(msg=="true"){
				status.innerHTML="管网布局优化计算完成，请点击<a href=''>下一步</a>查看结果！";
				/* start.innerHTML="启动"; 
			}
			
		}
		}); */
		
/* function GetXmlHttpObject()
{
  var xmlHttp=null;
  try
    {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
    }
  catch (e)
    {
    // Internet Explorer
    try
      {
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }
    catch (e)
      {
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
    }
  return xmlHttp;
}
	var xmlHttp=GetXmlHttpObject();
		xmlHttp.onreadystatechange=function(){
  	if(xmlHttp.readyState==4)
    {
    var text=xmlHttp.responseText;
    alert(text);
    }
 }
 
  xmlHttp.open("GET","layout_calculate.action",true);
  xmlHttp.send(null);
  
		
	} */
</script>
<body>
	<br>
	<br>
	<body>
        <div class="container">
			<section class="main">
				<form class="form-2" id="userform" action="" method="post" name="testlogin" >
				
					<h1><span id="status" class="log-in"></span></h1>
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
						<input type="button" id="start" class="start-calc" value="启动" onclick="myStart();"/>
        				<input type="button" class="stop-calc" value="终止" onclick="login1();"/>
					
					</p>
				</form>
			
				
			</section>
        </div>
    </body>
</body>
</html>
