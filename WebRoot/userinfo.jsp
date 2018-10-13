<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"contentType="text/html;charset=utf-8"%>
<%@ page import="ilk.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="ext/html;charset=utf-8">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">

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
	// 获取图书信息集合
	List<User> list = (List<User>)request.getAttribute("list");
	// 判断集合是否有效
	if(list == null || list.size() < 1){
	out.print("没有数据！");
	}else{
	// 遍历集合中的数据
	for(User user : list){
	%>
	<%
	String name=(String)request.getSession().getAttribute("username");
	String pwd="";
	String identity="";
	String tel="";
	String email="";
	if(name.equals(user.getUsername())){
		pwd=user.getPwd();
		identity=user.getIdentity();
		tel=user.getTel();
		email=user.getEmail();
	}
	else{continue;}
	
	 %>
	 <center>
	<table id="infotable">
	<tr align="center" class="ca">
	<td>用户名</td>
	<td><%=name %></td>
	</tr>
	<tr align="center" class="cb" >
	<td>密码</td>
	<td><%=pwd %></td>
	</tr>
	<tr align="center" class="ca" >
	<td>身份证号</td>
	<td><%=identity %></td>
	</tr>
	<tr align="center" class="cb">
	<td>电话</td>
	<td><%=tel %></td>
	</tr>
	<tr align="center" class="ca" >
	<td>邮箱</td>
	<td><%=email %></td>
	</tr>
	</table>
<form action="updateuser.jsp" accept-charset="UTF-8">
	<input type="hidden" name="username" value="<%=name%>">
	<input type="hidden" name="tel" value="<%=tel %>">
	<input type="hidden" name="identity" value="<%=identity%>">
	<input type="hidden" name="pwd" value="<%=pwd %>">
	<input type="hidden" name="email" value="<%=email %>">
	<button class="button" data="info"style="vertical-align:middle"><span>修改个人信息</span></button>
</form>
</center>
<%
	}
	}
	%>
  </body>
</html>
