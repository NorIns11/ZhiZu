<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"
		pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<meta http-equiv="Refresh" content="5;url=index.jsp">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">


  </head>
  
  <body>
  <h1 align="center">欢迎注册知租</h1>
  <hr>
  	<center>
    <table>
    	<tr align="center"><td>恭喜您已成功注册</td></tr>
    	<tr align="center"><td>将在5秒后跳转到登录页面，或点击<a href="index.jsp">这里</a>立即跳转</td></tr>
    </table></center>
  </body>
</html>
