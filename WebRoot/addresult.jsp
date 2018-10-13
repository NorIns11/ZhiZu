<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>汽车添加结果</title>
    
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
  	<div class="con"><a href="addcar.jsp">添加车辆信息</a></div>
  	<div class="con"><a href="servlet/delfind">删除车辆信息</a></div>
  	<div class="con"><a href="servlet/admlendfind">查看租借信息</a></div>
  	<div class="con"><a href="index.jsp">退出登录</a></div>
  </div>
  <jsp:useBean id="car" class="ilk.Car"></jsp:useBean>
 <jsp:setProperty property="*" name="car"/>
 <div class="show">
    <%
try {
	// 加载数据库驱动，注册到驱动管理器
	Class.forName("com.mysql.jdbc.Driver");
	// 数据库连接字符串
	String url = "jdbc:mysql://localhost:3306/zhizu?useUnicode=true&characterEncoding=UTF-8";
	// 数据库用户名
	String username = "root";
	// 数据库密码
	String password = "7415369";
	// 创建Connection连接
	Connection conn = DriverManager.getConnection(url,username,password);
	// 添加图书信息的SQL语句
	String sql = "insert into car(carID,brand,type,price) values(?,?,?,?)";
	// 获取PreparedStatement
	PreparedStatement ps = conn.prepareStatement(sql);
	// 对SQL语句中的第1个参数赋值
	ps.setString(1, car.getCarID());
	// 对SQL语句中的第2个参数赋值
	ps.setString(2, car.getBrand());
	// 对SQL语句中的第3个参数赋值
	ps.setString(3,car.getType());
	// 对SQL语句中的第5个参数赋值
	ps.setFloat(4, car.getPrice());
	// 执行更新操作，返回所影响的行数
	int row = ps.executeUpdate();
	// 判断是否更新成功
	if(row > 0){
	// 更新成输出信息
	out.print("成功添加了 " + row + "条数据！");
	}
	// 关闭PreparedStatement，释放资源
	ps.close();
	// 关闭Connection，释放资源
	conn.close();
	} catch (Exception e) {
	out.print("汽车信息添加失败！");
	e.printStackTrace();
}
%>
<br>
</div>
  </body>
</html>
