<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="ext/html;charset=utf-8">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
	<script type="text/javascript">
	var b = "";
		function codes(n){
			var a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			var b = "";
			for(i=0;i<n;i++){
				var index = Math.floor(Math.random()*62);
				b += a.charAt(index);
			}
			return b;
		 }
		function show(){
			document.getElementById("checkdiv").value = codes(4);
		}
		window.onload = show;
		function check1(){
	    var inputstr = document.getElementById("check").value.toUpperCase();
	   	var str = document.getElementById("checkdiv").value.toUpperCase();
		if(str!=inputstr){
			alert("您输入的验证码有误");
			form2.action="";
	  		window.location.href="index.jsp";
	  	}
	} 
	</script>
  </head>
  
  <body data="else">
    <center>
    <h1 align="center">欢迎注册知租</h1>
    <hr>
    <form id="form2" name="form2" method="post" action="servlet/RegServlet">
    	<table >
    		<tr>
    		    <td class="content2"><input type="text" name="username"placeholder=" 用户名"/></td>
    			<td class="hint">请输入1~10个字符</td>
    		</tr>
    		<tr>
    			<td class="content2"><input type="password"  name="pwd"placeholder=" 密码"/></td>
    			<td class="hint">请输入6~12个字符</td>
    		</tr>
    		<tr>
    			<td class="content2"><input type="password"  name="pwd2"placeholder=" 二次输入密码"></td>
    			<td class="hint">请再次输入您的密码</td>
    		</tr>
    		<tr>
    			<td class="content2"><input type="text"  name="identity"placeholder=" 身份证号码"/></td>
    			<td class="hint">请输入您的身份证号码</td>
    		</tr>
    		<tr>
    			<td class="content2"><input type="text"  name="tel" placeholder=" 手机号"/></td>
    			<td class="hint">请输入您的手机号码</td>
    		</tr>
    		<tr>
    			<td class="content2"><input type="email"  name="email" placeholder=" 电子邮箱"/></td>
    			<td class="hint">请输入您的邮箱地址</td>
    		</tr>
    		<tr>
    			<td class="content2"><input type="text" name="check" id="check" placeholder=" 下图验证码"/></td>
    			<td class="hint">请输入验证码</td>
    		</tr>
    		<tr>
    			<td class="content2">
 				<input id="checkdiv" type="button" onclick="show()">
 				<span class="hint">点击刷新验证码</span>
    			</td>
    		</tr>
    		<tr>
    			<td class="content2">
 				<button class="button" onclick="check1()"data="m2"style="vertical-align:middle"><span>注 册</span></button>
    			</td>
    		</tr>
    	</table>
    </form>
    </center>
  </body>
</html>
