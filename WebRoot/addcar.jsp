<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加汽车信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
  </head>
  
  <body data="else">
  <h1 align="center">知租管理员系统</h1>
  <hr>
  <div style="float:left;height:500px">
  	<div class="control"><h2>控制台</h2></div>
  	<div class="con now"><a>添加车辆信息</a></div>
  	<div class="con"><a href="servlet/delfind">删除车辆信息</a></div>
  	<div class="con"><a href="servlet/admlendfind">查看租借信息</a></div>
  	<div class="con"><a href="index.jsp">退出登录</a></div>
  </div>
  <center>
       <form action="addresult.jsp" method="post" onsubmit="return check(this);">
	<table id="addtable">
	<tr>
		<td  class="label">汽车编号</td>
		<td><input class="content1"type="text" name="carID" /></td>
	</tr>
	<tr>
		<td   class="label">品牌</td>
		<td><input class="content1" type="text" name="brand" /></td>
	</tr>
	<tr>
		<td   class="label">型号</td>
		<td><input class="content1" type="text" name="type" /></td>
	</tr>
	<tr>
		<td   class="label">价格</td>
		<td><input class="content1" type="text" name="price" /></td>
	</tr>
	<tr></tr>
	</table>
	<button class="button" style="vertical-align:middle"><span>添 加</span></button>
	</form></center>
  </body>
</html>
