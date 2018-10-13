<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>还车结果</title>
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
  	<div class="con"><a href="servlet/lendfind">去租车</a></div>
  	<div class="con"><a href="servlet/returnfind">去还车</a></div>
  	<div class="con"><a href="index.jsp">退出登录</a></div>
  </div>
  <center>
 	<div class="show"> 
      还车成功！ <br>
      </div>
    <a class="obvi" href="detail.jsp"><span id="jumpTo">10</span>秒后会自动跳转到首页，也可点击本处直接跳转</a>   
<script type="text/javascript">  
    countDown(10,'detail.jsp');  
</script>
</center>
  </body>
</html>
