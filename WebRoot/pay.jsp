<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="ilk.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
	<script>
		function checkd(){
			var day = document.getElementById("lasting").value;
			if(!day||isNaN(day)){
				alert("您输入的天数信息有误,请重新选车！");
				lendform.action="servlet/lendfind";
			}
		}
	</script>
  </head>
  <body data="else">
  <h1 align="center">知租用户系统</h1>
  <hr>
  <div style="float:left;height:500px">
  	<div class="control"><h2>控制台</h2></div>
  	<div class="con"><a href="servlet/personfind">个人信息</a></div>
  	<div class="con now"><a>去租车</a></div>
  	<div class="con"><a href="servlet/returnfind">去还车</a></div>
  	<div class="con"><a href="index.jsp">退出登录</a></div>
  </div>
  <%
		String carID = String.valueOf(request.getParameter("carID"));
		session.setAttribute("carID", carID);
   %>
   <div class="pay">
  <form id="lendform" name="lendform"action="servlet/lendcar" method="get">
<b>请输入您要租借的天数：  </b>
<input  type="text" id="lasting" name="lasting"/><br>
<img class="pay"src="image/pay.jpg"><br>
<button class="button"onclick="checkd()"><span>已确认支付</span></button><br>
<a href="servlet/lendfind">返回重新选车</a>
</form>    
</div> 
  </body>
</html>
