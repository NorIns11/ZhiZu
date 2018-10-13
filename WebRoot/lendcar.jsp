<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="ilk.Car" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>租车</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
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
  	<div class="con"><a href="servlet/personfind">个人信息</a></div>
  	<div class="con now"><a>去租车</a></div>
  	<div class="con"><a href="servlet/returnfind">去还车</a></div>
  	<div class="con"><a href="index.jsp">退出登录</a></div>
  </div><center>
    <table id="lendtable">
<tr align="center">
<td class="ca"><b>品牌</b></td>
<td class="cb"><b>型号</b></td>
<td class="ca"><b>价格</b></td>
<td class="cb"><b></b></td>
</tr>
<%
// 获取车辆信息集合


List<Car> list = (List<Car>)request.getAttribute("list");

// 判断集合是否有效
if(list == null || list.size() < 1){
out.print("没有数据！");
}else{
// 遍历集合中的数据
for(Car car : list){
%>
<tr align="center" >
<td class="ca"><%=car.getBrand()%></td>
<td class="cb"><%=car.getType()%></td>
<td class="ca"><%=car.getPrice()%></td>
<td class="cb">
<a class="del" href="pay.jsp?carID=<%=car.getCarID()%>">租借</a>
</td>
</tr>
<%
}
}
%>
<tr>
<td class="page" colspan="6">
<%=request.getAttribute("bar")%>
</td>
</tr>

</table>
   </center>    
  </body>
</html>
