<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>遗传算法参数</title>
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
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<img border="0" width="13" height="13"
					src="CSS/images/title_arrow.gif" /> 遗传算法参数
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<!-- <div id=MainArea> -->		  
	<div class="form_content" id=MainArea >
		<form id="test" action="layout_saveAlgorithmParam.action" method="post">
			<div class="ItemBlock_Title1">
				<div class="ItemBlock_Title1">
		<input type="hidden" name="projectId" value="${project.projectId }">
    <!-- 表单内容显示 -->
	<fieldset>
        <div class="form-row">
            <div class="field-label"><label for="field1">群体规模</label>:</div>
            <div class="field-widget"><input name="popsize" id="field1" class="required" title="输入群体规模，为整数" value="${lgp.popsize }"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">遗传代数</label>:</div>
            <div class="field-widget"><input name="maxgen" id="field2" class="required" title="输入遗传代数，为整数" value="${lgp.maxgen }"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field3">选择率</label>:</div>
            <div class="field-widget"><input name="ps" id="field3" class="required" title="输入选择率，为0-1之间的小数" value="${lgp.ps }"/></div>
        </div>
        
         <div class="form-row">
            <div class="field-label"><label for="field4">换位率</label>:</div>
            <div class="field-widget"><input name="pt" id="field4" class="required" title="输入换位率，为0-1之间的小数" value="${lgp.pt}"></div>
        </div>
    </fieldset>
   </div>
  </div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image" src="CSS/images/save.png" /> <!-- <a
					href="javascript:history.go(-1);"><img
					src="CSS/images/goBack.png" /> </a> -->
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