<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Ttpe" content="text/html;charset=utf-8">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
	
  </head>
  <body>
  <div class="ldiv">
    <h1 data="login"align="center">知租登录系统</h1>
    <form id="loginform" name="loginform" method="post" action="servlet/login">
    <table id="table1">
    	<tr>
    		<td class="content1"><input type="text" name="username" placeholder=" 用户名" maxlength="10" /></td>
    	</tr>
    	<tr>
    		<td class="content1"><input type="password" name="pwd"  placeholder=" 登录密码" maxlength="15"/></td>
    	</tr>
    	<tr>
    		<td>&nbsp;<input  type = "radio" name="choice"  value= "1"/>用户&nbsp;&nbsp;
    							  <input  type = "radio" name="choice" value= "2"/>管理员</td>
    	</tr>
    	<tr><td><button class="button" onclick="choose()"data="m1"style="vertical-align:middle"><span>登 录</span></button></td></tr>
    	<tr><td class="a1">还没有账号？点击<a href="register.jsp">这里</a>立即注册</td></tr>
   	</table>
    </form>
    </div>
  </body>
</html>
