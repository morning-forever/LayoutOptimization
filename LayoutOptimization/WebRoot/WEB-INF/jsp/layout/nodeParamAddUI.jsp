<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>添加节点</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/jquery.ui.draggable.js"charset="utf-8"></script>
<script language="javascript" src="JS/jquery.alerts.js" charset="utf-8"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="CSS/jquery.alerts.css" media="screen"/>
<link title="style1" rel="stylesheet"
	href="resources/css/form_style.css" type="text/css" />

<script type="text/javascript">
	function beforeSubmit(){
		try{
			var noOfProj=jQuery("#noOfProj").val();
			var projectId=$("#projectId").val();
			
			
			$.post("layout_nodeIsExist.action", {noOfProj:noOfProj,projectId:projectId},function(data,textStatus){
			if(data==1){
				jAlert("这个节点已存在！","提示信息");
			}else {
				jAlert("检查成功！","提示信息");
			};
		});
		}catch(e){
			alert(e.message);
			return false;
		}
		return false;
		
		}
</script>
</head>
<body>&nbsp; 
 
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="CSS/images/title_arrow.gif" /> 添加节点
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div class="form_content" id=MainArea >
		
		<form id="test" action="layout_saveNodeParam.action" method="get">
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
		<input type="hidden" id="projectId" name="projectId" value="${project.projectId }">
	<fieldset>
        <div class="form-row">
            <div class="field-label"><label for="field1">节点编号</label>:</div>
            <div class="field-widget"><input name="noOfProj" id="noOfProj" class="required" title="请输入" /></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">X坐标</label>:</div>
            <div class="field-widget"><input name="nodeX" id="field2" class="required" title="请输入"  /></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field3">Y坐标</label>:</div>
            <div class="field-widget"><input name="nodeY" id="field3" class="required" title="请输入" /></div>
        </div>
        <div class="form-row">
            <div class="field-label"><label for="field4">冷负荷需求</label>:</div>
            <div class="field-widget"><input name="nodeL" id="field4"  title="请输入" /></div>
        </div>
         <div class="form-row">
            <div class="field-label"><label for="field5">热负荷需求</label>:</div>
            <div class="field-widget"><input name="nodeR" id="field5"  title="请输入" /></div>
        </div>
        <div class="form-row">
            <div class="field-label"><label for="field6">压力需求</label>:</div>
            <div class="field-widget"><input name="nodePp" id="field6"  title="请输入" /></div>
        </div>
         <div class="form-row">
            <div class="field-label"><label for="field7">冷负荷流量需求</label>:</div>
            <div class="field-widget"><input name="nodeQl" id="field7"  title="请输入" /></div>
        </div>
         <div class="form-row">
            <div class="field-label"><label for="field8">热负荷流量需求</label>:</div>
            <div class="field-widget"><input name="nodeQr" id="field8"  title="请输入" /></div>
        </div>
    </fieldset>
				
				
				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image" src="CSS/images/save.png" /> <a
					onclick="beforeSubmit()"><img
					src="CSS/images/goBack.png" /> </a>
			</div>

		</form>
	</div>
 <script type="text/javascript">
        function formCallback(result, form) {
            window.status = "valiation callback for form '" + form.id + "': result = " + result;
        }
        
        var valid = new Validation('test', {immediate : true, onFormValidate : formCallback});
        Validation.addAllThese([
            ['validate-password', '密码长度要大于6', {
                minLength : 7,
                notOneOf : ['password','PASSWORD','1234567','0123456'],
                notEqualToField : 'field1'
            }],
            ['validate-password-confirm', '请重试', {
                equalToField : 'field8'
            }]
        ]);
    </script>

</body>
</html>