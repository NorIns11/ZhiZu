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
    
    <title>租车结果</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
	<script type="text/javascript">       
		function countDown(secs,surl){           
		 var jumpTo = document.getElementById('jumpTo');  
		 jumpTo.innerHTML=secs;    
		 if(--secs>0){       
		     setTimeout("countDown("+secs+",'"+surl+"')",1000);       
		     }       
		 else{         
		     location.href=surl;       
		     -ma  
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
  	 </div><center>
  
    <table id="lendtable2">
<tr class="page">
<td align="center" colspan="6">
<h2>您的租车信息</h2>
</td>
</tr>
<tr align="center" >
<td class="ca"><b>品牌</b></td>
<td class="cb"><b>型号</b></td>
<td class="ca"><b>价格</b></td>
<td class="cb"><b>租借日期</b></td>
<td class="ca"><b>租借天数</b></td>
<td class="cb"><b>归还日期</b></td>
</tr>
<%
// 获取车辆信息集合



List<Lend> list = (List<Lend>)request.getAttribute("list");
List<Car> list1 = (List<Car>)request.getAttribute("list1");
// 判断集合是否有效
if(list == null || list.size() < 1){
out.print("没有数据！");
}else{
// 遍历集合中的数据
for(int i=0;i<list.size();i++){
%>
<tr align="center">
<td class="ca"><%=((Car)list1.get(i)).getBrand() %></td>
<td class="cb"><%=((Car)list1.get(i)).getType() %></td>
<td class="ca"><%=((Car)list1.get(i)).getPrice() %></td>
<td class="cb"><%=((Lend)list.get(i)).getLendtime() %></td>
<td class="ca"><%=((Lend)list.get(i)).getLasting() %></td>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    Date date = sdf.parse(((Lend)list.get(i)).getLendtime());  
	long lastTime =date.getTime()+Integer.parseInt(((Lend)list.get(i)).getLasting())*86400000;
    Date lastDate1 = new Date(lastTime);
    String lastDate=sdf.format(lastDate1);
 %>
<td class="cb"><%=lastDate.toString() %></td>
</tr>
<%
}
}
%>
</table>
<a class="obvi"href="detail.jsp" align="center"><span id="jumpTo">10</span>秒后会自动跳转到首页，也可点击本处直接跳转</a>   
<script type="text/javascript">  
    countDown(10,'detail.jsp');  
</script>
</center>
  </body>
</html>
