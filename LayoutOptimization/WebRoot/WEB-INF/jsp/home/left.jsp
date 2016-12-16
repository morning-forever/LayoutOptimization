<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/jquery.alerts.js" charset="utf-8"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="CSS/jquery.alerts.css"
	media="screen" />
<link type="text/css" rel="stylesheet" href="CSS/blue/pageCommon.css" />
<!-- jQuery Configuration -->
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
</head>
<script type="text/javascript">
	/* function judge(projectId){
		if(projectId==null){
			jAlert('请先打开一个工程','提示信息');
			return false;
		}
		return true;
	} */
</script>
<body style="margin: 0">
<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <ul id="main-nav">
<!-- <div id="Menu">
    <ul id="MenuUl"> -->
        <!-- <li class="level1"> -->
        <li> <a href="#" class="nav-top-item">工程管理</a>
          <ul style="display: none;" class="MenuLevel2">
         	<li><a href="project_list.action" target="right" >打开工程</a></li>
            <li><a href="project_newProject.action"  target="right" >新建工程</a></li>
          </ul>  
        </li>
        
        <li> <a href="#" class="nav-top-item">布局优化</a>
          <ul style="display: none;" class="MenuLevel2">
                 <li class="level2">
                    <div class="level2Style"> <a target="right" href="layout_nodeParam.action" href="l" >节点参数</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="layout_edgeParam.action">管道编号</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="layout_projectParam.action">管道系统参数</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="layout_algorithmParam.action">遗传算法参数</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="layout_algorithm.action">遗传运算</a></div>
                </li>
                <li class="level2"> 
                	<div class="level2Style"> <a target="right" href="layout_report.action">结果输出</a></div>
                </li>
          		 <li class="level2">
                    <div class="level2Style"> <a href="diameter_continueAlgorithmUI.action" target="right" >继续管径优化</a></div>
                </li>
           <!-- <li > <a href="layout_nodeParam.action" target="right" >节点参数</a> </li>
           <li > <a target="right" href="layout_edgeParam.action">管道编号</a> </li>
           <li > <a target="right" href="layout_projectParam.action">管道系统参数</a></li>
           <li > <a target="right" href="layout_algorithmParam.action">遗传算法参数</a> </li>
           <li > <a target="right" href="layout_algorithm.action">遗传运算</a>  </li>
           <li > <a target="right" href="layout_report.action">结果输出</a> </li> -->
          </ul>
        </li>
        
        <li> <a href="#" class="nav-top-item">管径优化</a>
          <ul style="display: none;" class="MenuLevel2">
                <li class="level2">
                    <div class="level2Style"> <a href="diameter_nodeParam.action" target="right" >节点参数</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="diameter_edgeParam.action">管道编号</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="diameter_projectParam.action">管道系统参数</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="diameter_algorithmParam.action">遗传算法参数</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"> <a target="right" href="diameter_algorithm.action">遗传运算</a></div>
                </li>
                <li class="level2"> <div class="level2Style"> <a target="right" href="diameter_report.action">结果输出</a></div>
                </li>
          </ul>  
        </li>
        
        
        <li> <a href="#" class="nav-top-item">使用说明</a>
          <ul style="display: none;" class="MenuLevel2">
           
             <li class="level2">
                    <div class="level2Style"> <a target="right" href="help_about.action">系统简介</a></div>
             </li>
             <li class="level2">
                    <div class="level2Style"> <a target="right" href="help_help.action">操作手册</a></div>
             </li>
 
          </ul>  
        </li>
    </ul>
</div>
</div>
</div>
</body>
</html>
