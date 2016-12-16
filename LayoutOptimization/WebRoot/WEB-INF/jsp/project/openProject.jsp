<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>工程图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  
  <!--   <link rel="stylesheet" href="resources/css/style.css"> -->
    <script src="JS/jquery.js"></script>
    <script src="resources/scripts/d3.v3.min.js"></script>

    <style>
      .curve, .line {
        fill: none;
        stroke-width: 1px;
      }
      .curve {
        stroke: red;
        stroke-width: 3px;
      }
      .control {
        fill: #ccc;
        stroke: #000;
        stroke-width: .5px;
      }
      .t, .controltext {
        font-size: .6em;
      }
    </style>
 </head>
 <body>

<div id="title"><h1>初始模型</h1></div>
<div id="vis"></div>

<script type="text/javascript">
/* var nodes = ${nodesJSON };
var edges = ${edgesJSON }; 
alert(nodes);
alert(edges);	 */   
var w = 750,
    h = 750,
    padding = 30,
   
    line = d3.svg.line().x(x).y(y),
    stroke = d3.scale.category20b();
    
var sNodeObj, eNodeObj; 
var nodes = ${nodesJSON };
var edges = ${edgesJSON }; 

/* var nodes = [{no:"1", x: 10, y: 250}, {no:"2", x: 0, y: 0}, {no:"3", x: 100, y: 0}, {no:"4", x: 200, y: 250}, {no:"5", x: 225, y: 125},{no:"6", x: 200, y: 225}];
var edges = [{no:"1", sNode:"1",eNode:"2"}, {no:"2", sNode:"1",eNode:"3"}, {no:"3", sNode:"1",eNode:"4"},
			{no:"4", sNode:"1",eNode:"5"} ,{no:"5", sNode:"1",eNode:"6"}]; */

var lines  = [[{x: 10, y: 250}, {x: 0, y: 0}], 
			  [{x: 10, y: 250}, {x: 100, y: 0}], 
			  [{x: 10, y: 250}, {x: 200, y: 250}], 
			  [{x: 10, y: 250}, {x: 225, y: 125}]];  
drawModel();
function drawModel() {
	/* 生成SVG图形容器 */ 
	var vis = d3.select("#vis").append("svg")
    	.attr("width", w + 2 * padding)
    	.attr("height", h + 2 * padding)
    	.append("g")
    	.attr("transform", "translate(" + padding + "," + padding + ")");
 	
 	/* 获取管道线 */ 
 	var interpolation = vis.selectAll("g")
      .data(function(d) { return  getLevels(); });
      
    /* 设置管道的样式 */  
  	interpolation.enter().append("g")
      .style("fill", colour)
      .style("stroke", colour);
	
	/* 绘制管道线 */
  	var path = interpolation.selectAll("path")
      .data(function(d) { return [d]; });
  	path.enter().append("path")
      .attr("class", "line")
      .attr("d", line);
  	path.attr("d", line);
  	
  	
  	/* 生成节点层  */
	var circlesEnter = vis.selectAll("circle.control")
    	.data(function(d) { return nodes.slice(0, d); })
    	.enter();
    	
    /* 显示节点的圆 */
	circlesEnter.append("circle")
    	.attr("class", "control")
    	.attr("r", 20)
    	.attr("cx", function(d) {return x(d);})
    	.attr("cy", function(d) {return y(d);});

	/* 显示节点的编号 */
	circlesEnter.append("text")
  		.attr("class", "t")
  		.attr("x", function(d) {return x(d);})
  		.attr("y", function(d) {return y(d);})
  		.attr("text-anchor", "middle")
  		.attr("dy", ".4em")
  		.text(function(d) { return no(d); });
}  

function noOfEdge(d)   	  { return d.no; }
function noOfStartNode(d) { return d.sNode; } 
function noOfEndNode(d)   { return d.eNode; }
			
function NodeListToNodeArray(lNodes) {
 	var aNodes = [];
   for(var i=0;i<lNodes.length;i++){
  		aNodes.push({no:noOfProj ,x: lNodes[i].nodeXnd, y: lNodes[i].nodeYnd});
   }
}			
			  
/* 生成顶点对数组,参数两个顶点 */
function interpolate(d1, d2) {
  var r = [];
  
  r.push({x: d1.x, y: d1.y});
  r.push({x: d2.x, y: d2.y});
  
  return r;
}

/* 获取包含所有管道线对应节点的坐标数组.
      返回一个包含顶点坐标对的数组，即每个元素为一个坐标对数组,参见lines定义*/
function getLevels() {
  var sNodeNo, eNodeNo;
  var objOfStartNode=null, objOfEndNode = null;

  var x = [];
  for(var i=0; i<edges.length; i++) {
  	sNodeNo = noOfStartNode(edges[i]);
  	eNodeNo = noOfEndNode(edges[i]);
  	
  	for(var j=0; j<nodes.length; j++) {
  		if(sNodeNo == no(nodes[j])) {
  			objOfStartNode = nodes[j];
  			break;
  		}
  	}
  	
  	for(var j=0; j<nodes.length; j++) {
  		if(eNodeNo == no(nodes[j])) {
  			objOfEndNode = nodes[j];
  			break;
  		}
  	}
  	
   x.push(interpolate(objOfStartNode, objOfEndNode));
 
  }
  
  return x;
}

function no(d) { return d.no; }
function x(d) { return d.x; }
function y(d) { return d.y; }
function colour(d, i) {
  stroke(-i);
  return d.length > 1 ? stroke(i) : "red";
}
      
</script>

 
  </body>
</html>

