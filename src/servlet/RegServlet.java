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
		String username,pwd,identity,tel,email;				//�û�ע����Ϣ
		String epattern="^(\\w+)@([a-zA-Z0-9]+).([a-z]{2,})$";		//email��ʽ
		String idpattern = "^[0-9]{17}([0-9]|X|x)$";						//���֤�Ÿ�ʽ
		String telpattern = "^1[3|4|5|7|8][0-9]{9}$"	;																//tel��ʽ
		
		//�û����������
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
				out.print("<script language='javascript'>alert('�û����ѱ�ע�ᣡ');"
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
		
		//���֤�����ظ��Լ��
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
				out.print("<script language='javascript'>alert('�������Ϣ�ѱ�ע�ᣬ��ȷ���������֤���룡');"
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
		
		//�û������ȼ���
		if(request.getParameter("username").length()<1||request.getParameter("username").length()>10){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('��������û��������Ϲ涨��"
										+ "�뽫�û��������޶���1~10���ַ�');"
										+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//���볤�ȼ���
		else if( request.getParameter("pwd").length()<6|| request.getParameter("pwd").length()>12){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('�뽫���볤���޶���6~12���ַ�');"
						+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//����һ���Լ���
		else if(! request.getParameter("pwd").equals(request.getParameter("pwd2"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('��������������벻һ��');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//���֤��ʽ����
		else if(!Pattern.matches(idpattern,request.getParameter("identity"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('�������֤��ʽ����ȷ��');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//�ֻ��Ÿ�ʽ����
		else if(!Pattern.matches(telpattern,request.getParameter("tel"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('�����ֻ��Ÿ�ʽ����ȷ��');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//�����ʽ����
		else if(!Pattern.matches(epattern,request.getParameter("email"))){
			out.print("<html><head><meta charset='UTF-8'></head><body>");
			out.print("<script language='javascript'>alert('��������ȷ�����䣡');"
					+ "window.location.href='../register.jsp'</script>");
			out.print("</body></html>");
		}
		
		//��ע����Ϣ��ӵ����ݿ�
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
