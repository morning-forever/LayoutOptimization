<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>新建工程</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>

<script src="resources/scripts/scriptaculous/lib/prototype.js" type="text/javascript"></script>
<script src="resources/scripts/scriptaculous/src/effects.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/scripts/form_validation.js"></script>
<link title="style1" rel="stylesheet" href="resources/css/form_style.css" type="text/css" />


<!-- <link type="text/css" rel="stylesheet" href="CSS/blue/pageCommon.css" /> -->
<script type="text/javascript">
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
					src="CSS/images/title_arrow.gif" /> 新建工程
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div class="form_content" id=MainArea >
		<form id="test" action="project_save.action" method="get">
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
	<fieldset>
		<div class="form-row">
            <div class="field-label"><label for="field1">工程编号</label>:</div>
            <div class="field-widget"><input name="projectId" id="field1" class="required" title="请输入"  value="${proj.projectId }"/></div>
        </div>
        <div class="form-row">
            <div class="field-label"><label for="field1">工程名称</label>:</div>
            <div class="field-widget"><input name="projectName" id="field1" class="required" title="请输入"  value="${proj.projectName}"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">工程类型</label>:</div>
            <div class="field-widget"><input name="projectKind" id="field2" class="required" title="请输入" value="${proj.projectKind}"/></div>
        </div>+
        
    </fieldset>
				
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image" src="CSS/images/save.png" /> <a
					href="layout_edgeParam.action"><img
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