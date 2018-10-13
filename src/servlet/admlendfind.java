package servlet;

import ilk.Lend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admlendfind extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	

	/**
	 * Constructor of the object.
	 */
	public admlendfind() {
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

		try {
			// �������ݿ�������ע�ᵽ����������
			Class.forName("com.mysql.jdbc.Driver");
			// ���ݿ������ַ���
			String url = "jdbc:mysql://localhost:3306/zhizu";
			// ���ݿ��û���
			String username = "root";
			// ���ݿ�����
			String password = "7415369";
			// ����Connection����
			Connection conn = DriverManager.getConnection(url,username,password);
			// ��ȡStatement
			Statement stmt = conn.createStatement();
			// ��ѯ���п��г���
			String sql = "select * from lend";
			// ִ�в�ѯ
			ResultSet rs = stmt.executeQuery(sql);
			// ʵ����List����
			List<Lend> list = new ArrayList<Lend>();
			// �жϹ������ƶ������ж��Ƿ���Ч
			while(rs.next()){
				// ʵ��������
				Lend lend=new Lend();
				// ��id���Ը�ֵ
				lend.setCarID(rs.getString("carID"));
				// ��Ʒ�����Ը�ֵ
				lend.setUsername(rs.getString("username"));
				// ��price���Ը�ֵ
				lend.setLendtime(rs.getString("lendtime"));
				// ���ͺ����Ը�ֵ
				lend.setLasting(rs.getString("lasting"));			
				// ��������ӵ�������
				list.add(lend);
			}
			// ��ͼ�鼯�Ϸ��õ�request֮��
			request.setAttribute("list", list);
			rs.close();		// �ر�ResultSet
			stmt.close();	// �ر�Statement
			conn.close();	// �ر�Connection
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ����ת����
		request.getRequestDispatcher("../admlendfind.jsp").forward(request, response);
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
