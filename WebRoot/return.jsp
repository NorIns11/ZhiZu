<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="ilk.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>还车</title>
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
  	<div class="con"><a href="servlet/lendfind">去租车</a></div>
  	<div class="con now"><a>去还车</a></div>
  	<div class="con"><a href="index.jsp">退出登录</a></div>
  </div><center>
    <table id="returntable">
<tr class="page">
<td align="center" colspan="7">
<h2>已租车辆信息</h2>
</td>
</tr>
<tr align="center">
<td class="ca"><b>品牌</b></td>
<td class="cb"><b>型号</b></td>
<td class="ca"><b>价格</b></td>
<td class="cb"><b>租借日期</b></td>
<td class="ca"><b>租借天数</b></td>
<td class="cb"><b>归还日期</b></td>
<td class="ca"><b>归还</b></td>
</tr>
<%
// 获取车辆信息集合



List<Lend> list = (List<Lend>)request.getAttribute("list");
List<Car> list1 = (List<Car>)request.getAttribute("list1");
// 判断集合是否有效
if(list == null || list.size() < 1){
out.print("没有数据！");
}else{
// 遍历汽车集合中的数据
for(int i=0;i<list.size();i++){
%>
<tr align="center">
<td class="ca"><%=((Car)list1.get(i)).getBrand() %></td>
<td class="cb"><%=((Car)list1.get(i)).getType() %></td>
<td class="ca"><%=((Car)list1.get(i)).getPrice() %></td>
<td class="cb"><%=((Lend)list.get(i)).getLendtime() %></td>
<td class="ca"><%=((Lend)list.get(i)).getLasting() %></td>
<% String carID=((Car)list1.get(i)).getCarID(); %>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    Date date = sdf.parse(((Lend)list.get(i)).getLendtime());  
	long lastTime =date.getTime()+Integer.parseInt(((Lend)list.get(i)).getLasting())*86400000;
    Date lastDate1 = new Date(lastTime);
    String lastDate=sdf.format(lastDate1);
 %>
<td class="cb"><%=lastDate.toString() %></td>
<td class="ca"><a href="servlet/returncar?carID=<%=carID%>">归还</a></td>

</tr>
<%
}
}
%>
</table>
</center>    
  </body>
</html>
