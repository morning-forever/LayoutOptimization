<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>管道系统参数</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>

<script src="resources/scripts/scriptaculous/lib/prototype.js" type="text/javascript"></script>
<script src="resources/scripts/scriptaculous/src/effects.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/scripts/form_validation.js"></script>
<link title="style1" rel="stylesheet" href="resources/css/form_style.css" type="text/css" />

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
					src="CSS/images/title_arrow.gif" /> 管道系统参数
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div class="form_content" id=MainArea >
		<form id="test" action="layout_saveProjectParam.action" method="get">
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
		
	<fieldset>
		<input type="hidden" name="projectId" value="${project.projectId }">
        <div class="form-row">
            <div class="field-label"><label for="field1">回归系数a</label>:</div>
            <div class="field-widget"><input name="a" id="field1" class="required" title="请输入" value="${pp.a}"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">回归系数b</label>:</div>
            <div class="field-widget"><input name="b" id="field2" class="required" title="请输入"  value="${pp.b}"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field3">管道允许最低经济流速</label>:</div>
            <div class="field-widget"><input name="vmin" id="field3" class="required" title="请输入" value="${pp.vmin }"/></div>
        </div>
        
    </fieldset>
				
				
				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image" src="CSS/images/save.png" /> <a
					href="javascript:history.go(-1);"><img
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