<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../public/common.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
    <META http-equiv=Content-Type CONTENT="text/html; charset=gbk" />
	<TITLE>区域供热供冷优化与设计系统</TITLE>
	<LINK HREF="CSS/blue/login.css" type=text/css rel=stylesheet />
</HEAD>
<script type="text/javascript">
	$(document).ready(function(){
		document.forms[0].loginName.focus();
	});
	if(window.parent!=window){
		window.parent.location.reload(true);
	}
</script>
<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<s:form  method="post"  name="actForm" action="user_login.action">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><IMG BORDER="0" SRC="CSS/blue/images/logo.png" /></DIV>
            <DIV ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="CSS/blue/images/login/userId.gif" /></TD>
                        <TD><s:textfield size="20"  cssClass="TextField"  name="userName" /></TD>
                        <TD ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="CSS/blue/images/login/userLogin_button.gif"/></TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="CSS/blue/images/login/password.gif" /></TD>
                        <TD><s:password size="20" cssClass="TextField" showPassword="false" name="password" /></TD>
                    </TR>
                </TABLE>
               <font color="red"><s:fielderror fieldName="loginError" /></font> 
            </DIV>
            <center>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">湖南湖大瑞格能源科技有限公司版权所有</A></DIV>
       		</center>
        </DIV>
    </DIV>
</s:form>
</BODY>

</HTML>

