<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ page import="ilk.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">


  </head>
  
  </head>
  
  <body data="else">
  <h1 align="center">知租用户系统</h1>
  <hr>
  <div style="float:left;height:500px">
  	<div class="control"><h2>控制台</h2></div>
  	<div class="con now"><a>个人信息</a></div>
  	<div class="con"><a href="servlet/lendfind">去租车</a></div>
  	<div class="con"><a href="servlet/returnfind">去还车</a></div>
  	<div class="con"><a href="index.jsp">退出登录</a></div>
  	</div>
	<%
	request.setCharacterEncoding("UTF-8");
	String username=new String(request.getParameter("username").getBytes("iso-8859-1"),"UTF-8");
	System.out.println(username);
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	String tel=request.getParameter("tel");
	String identity=request.getParameter("identity");
	%>
	
	<center>
	<form action="servlet/Updateuser">
	<table id="updatetable">
	<tr align="center" class="ca">
	<td>用户名</td>
	<td><%=username %></td>
	</tr>
	<tr align="center"class="cb">
	<td>身份证号</td>
	<td><%=identity %></td>
	</tr>
	<tr align="center" class="ca">
	<td>密码</td>
	<td><input type="text" name="pwd" value="<%=pwd %>"></td>
	</tr>
	<tr align="center"class="cb">
	<td>电话</td>
	<td><input type="text" name="tel" value="<%=tel %>"></td>
	</tr>
	<tr align="center" class="ca">
	<td>邮箱</td>
	<td><input type="text" name="email" value="<%=email %>"></td>
	</tr>
	<tr class="cb">
	<td align="center" colspan="2">
	<input type="hidden" name="identity" value="<%=identity %>">
	</td>
	</tr>
	</table>
	<button class="button" data="info"style="vertical-align:middle"><span>提交</span></button>
	</form>
	</center>
	
	

  </body>
</html>
