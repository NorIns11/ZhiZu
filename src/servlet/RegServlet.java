package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public RegServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username,pwd,identity,tel,email;				//用户注册信息
		String epattern="^(\\w+)@([a-zA-Z0-9]+).([a-z]{2,})$";		//email格式
		String idpattern = "^[0-9]{17}([0-9]|X|x)$";						//身份证号格式
		String telpattern = "^1[3|4|5|7|8][0-9]{9}$"	;																//tel格式
		
		//用户名重名检测
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/zhizu";
			String dataname="root";
			String datapwd="7415369";
			Connection conn = DriverManager.getConnection(url,dataname,datapwd);
			Statement stmt = conn.createStatement();
			String sql = "select * from user where username='"+request.getParameter("username")+"'"; 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				rs.close();
				stmt.close();
				conn.close();
				out.print("<html><head><meta charset='UTF-8'></head><body>");
				out.print("<script language='javascript'>alert('用户名已被注册！');"
						+ "window.location.href='../register.jsp'</script>");
				out.print("</body></html>");
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		//身份证号码重复性检测
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/zhizu";
			String dataname="root";
			String datapwd="7415369";
			Connection conn = DriverManager.getConnection(url,dataname,datapwd);
			Statement stmt = conn.createStatement();
			String sql = "select * from user where identity='"+request.getParameter("identity")+"'"; 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				rs.close();
				stmt.close();
				conn.close();
				out.print("<html><head><meta charset='UTF-8'></head><body>");
				out.print("<script language='javascript'>alert('此身份信息已被注册，请确认您的身份证号码！');"
						+ "window.location.href='../register.jsp'</script>");
				out.print("</body></html>");
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		//用户名长度检验
		if(request.getParameter("username").length()<1||request.getParameter("username").length()>10){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('您输入的用户名不符合规定，"
										+ "请将用户名长度限定在1~10个字符');"
										+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//密码长度检验
		else if( request.getParameter("pwd").length()<6|| request.getParameter("pwd").length()>12){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('请将密码长度限定在6~12个字符');"
						+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//密码一致性检验
		else if(! request.getParameter("pwd").equals(request.getParameter("pwd2"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('您两次输入的密码不一致');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//身份证格式检验
		else if(!Pattern.matches(idpattern,request.getParameter("identity"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('您的身份证格式不正确！');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//手机号格式检验
		else if(!Pattern.matches(telpattern,request.getParameter("tel"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('您的手机号格式不正确！');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//邮箱格式检验
		else if(!Pattern.matches(epattern,request.getParameter("email"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('请输入正确的邮箱！');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//将注册信息添加到数据库
		else{
			username = request.getParameter("username");
			pwd = request.getParameter("pwd");
			identity = request.getParameter("identity");
			tel = request.getParameter("tel");
			email = request.getParameter("email");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/zhizu";
				String datauser="root";
				String datapwd = "7415369";
				Connection conn = DriverManager.getConnection(url,datauser,datapwd);
				String sql = "insert into user values(?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,username);
				ps.setString(2, pwd);
				ps.setString(3, identity);
				ps.setString(4, tel);
				ps.setString(5, email);
				ps.executeUpdate();
				ps.close();
				conn.close();
				response.sendRedirect("../success.jsp");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	/**
		 * Returns information about the servlet, such as 
		 * author, version, and copyright. 
		 *
		 * @return String information about this servlet
		 */
	public String getServletInfo() {
		return "This is my default servlet created by Eclipse";
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
