package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public login() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("pwd");
		String database="";
		String username="";
		
		//确定用户已选角色信息
		if(request.getParameter("choice") == null){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('请选择您的角色！');"
						+ "window.location.href='../index.jsp'</script>");
			out.print("</body></html>");
		}
		
		//判断是用户还是管理员
		int choice = Integer.valueOf(request.getParameter("choice"));		
		switch(choice){
		case 1:
			database = "user";
			username="username";
			break;
		case 2:
			database = "adm";
			username="admname";
			break;
		}
		
   	 	try{
   	 		Class.forName("com.mysql.jdbc.Driver");
   	 		String url = "jdbc:mysql://localhost:3306/zhizu";
   	 		String datauser = "root";
   	 		String datapwd = "7415369";
   	 		Connection conn = DriverManager.getConnection(url,datauser,datapwd);
   	 		Statement st = conn.createStatement();
   	 		String sql = "select * from " + database;
   	 		ResultSet rs = st.executeQuery(sql);
   	 		while(rs.next()){
   	 			if(rs.getString(username).equals(name)){
	   	 			if(!rs.getString("pwd").equals(password)){
	   	    	 		out.print("<html><head><meta charset='UTF-8'></head><body>");
		   	 			out.print("<script language='javascript'>alert('您输入的密码有误！');"
		   	 										+ "window.location.href='../index.jsp'</script>");
		   	 			out.print("</body></html>");
		   	    	 }
		   	    	 else{
		   	    		request.getSession().setAttribute("username",name);
		   	    		switch(choice){
		   	    		case 1:
		   	    			response.sendRedirect("../detail.jsp");
		   	    			break;
		   	    		case 2:
		   	    			response.sendRedirect("../manage.jsp");
		   	    			break;
		   	    		}
		   	    	 }
   	 			}
   	 		}
   	 		if(!rs.next()){
	 			out.print("<html><head><meta charset='UTF-8'></head><body>");
	 			out.print("<script language='javascript'>alert('您输入的用户名不存在 ！');"
	 										+ "window.location.href='../index.jsp'</script>");
	 			out.print("</body></html>");
	 		}
   	 		rs.close();
   	 		st.close();
   	 		conn.close();
   	 	}
   	 	catch(ClassNotFoundException e){
   	 		e.printStackTrace();
   	 	}
   	 	catch(SQLException e){
			e.printStackTrace();
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
