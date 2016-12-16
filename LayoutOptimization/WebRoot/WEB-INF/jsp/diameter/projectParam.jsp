<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管道系统参数</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="JS/jquery.js"></script>
<script language="javascript" src="JS/pageCommon.js" charset="utf-8"></script>
<script language="javascript" src="JS/PageUtils.js" charset="utf-8"></script>

<script src="resources/scripts/scriptaculous/lib/prototype.js"
	type="text/javascript"></script>
<script src="resources/scripts/scriptaculous/src/effects.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="resources/scripts/form_validation.js"></script>
<link title="style1" rel="stylesheet"
	href="resources/css/form_style.css" type="text/css" />

<script type="text/javascript">
	
</script>
</head>
<body>
	&nbsp;

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="CSS/images/title_arrow.gif" />管道系统参数
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div class="form_content" id=MainArea>
		<form id="test" action="diameter_saveProjectParams.action" method="get">
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<fieldset>
						<input type="hidden" name="projectId" value="${projectId }">
						<div class="form-row">
							<div class="field-label">
								<label for="field1">工程名称</label>:
							</div>
							<div class="field-widget">株洲神龙</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field2">折算总年数</label>:
							</div>
							<div class="field-widget">
								<input name="zst" id="field2" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field3">电价</label>:
							</div>
							<div class="field-widget">
								<input name="ce" id="field3" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field4">冷水密度</label>:
							</div>
							<div class="field-widget">
								<input name="density" id="field4" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field5">保温材料导热系数</label>:
							</div>
							<div class="field-widget">
								<input name="lumda" id="field5" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field6">系统能效比</label>:
							</div>
							<div class="field-widget">
								<input name="cop" id="field6" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field7">折旧率</label>:
							</div>
							<div class="field-widget">
								<input name="alpha" id="field7" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field8">水泵的机电效率</label>:
							</div>
							<div class="field-widget">
								<input name="pumpN" id="field8" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field9">水泵的年最大工作时间</label>:
							</div>
							<div class="field-widget">
								<input name="pumpT" id="field9" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field10">K系数</label>:
							</div>
							<div class="field-widget">
								<input name="pumpK" id="field10" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field11">T系数</label>:
							</div>
							<div class="field-widget">
								<input name="pumpTao" id="field11" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field12">管网外土壤的平均温度</label>:
							</div>
							<div class="field-widget">
								<input name="pipeTs" id="field12" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field13">管网内冷水回水的平均温度</label>:
							</div>
							<div class="field-widget">
								<input name="pipeTcs" id="field13" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field14">管网内冷水供水的平均温度</label>:
							</div>
							<div class="field-widget">
								<input name="pipeTcr" id="field14" class="required"
									title="请输入" />
							</div>
						</div>

						<div class="form-row">
							<div class="field-label">
								<label for="field15">管道T系数</label>:
							</div>
							<div class="field-widget">
								<input name="pipeT" id="field15" class="required"
									title="请输入" />
							</div>
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
			window.status = "valiation callback for form '" + form.id
					+ "': result = " + result;
		}

		var valid = new Validation('test', {
			immediate : true,
			onFormValidate : formCallback
		});
		Validation.addAllThese([ [ 'validate-password', '密码长度要大于6', {
			minLength : 7,
			notOneOf : [ 'password', 'PASSWORD', '1234567', '0123456' ],
			notEqualToField : 'field1'
		} ], [ 'validate-password-confirm', '请重试', {
			equalToField : 'field8'
		} ] ]);
	</script>

</body>
</html>

