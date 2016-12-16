<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>修改管道</title>
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
					src="CSS/images/title_arrow.gif" /> 修改管道
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div class="form_content" id=MainArea >
		<form id="test" action="diameter_editEdgeParam.action" method="get">
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
		<input type="hidden" name="id" value="${de.id }">
		<input type="hidden" name="projectId" value="1">
	<fieldset>
        <div class="form-row">
            <div class="field-label"><label for="field1">管道编号</label>:</div>
            <div class="field-widget"><input name="noOfProj" id="field1" class="required" title="请输入" value="${de.noOfProj}"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">管道起始节点</label>:</div>
            <div class="field-widget"><input name="snode" id="field2" class="required" title="请输入"  value="${de.snode}"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">管道终止节点</label>:</div>
            <div class="field-widget"><input name="enode" id="field3" class="required" title="请输入" value="${de.enode }"/></div>
        </div>
        <div class="form-row">
            <div class="field-label"><label for="field2">管道长度</label>:</div>
            <div class="field-widget"><input name="edgeLnd" id="field4" class="required" title="请输入" value="${de.edgeLnd }"/></div>
        </div>
         <div class="form-row">
            <div class="field-label"><label for="edgeQnd">管道流量</label>:</div>
            <div class="field-widget"><input name="edgeQnd" id="field5" class="required" title="请输入" value="${de.edgeQnd }"/></div>
        </div>
    </fieldset>
				
				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image" src="CSS/images/save.png" /> <a
					href="diameter_edgeParam.action"><img
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