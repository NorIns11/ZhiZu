package servlet;

import ilk.Car;
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
import javax.servlet.http.HttpSession;

public class returnfind extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public returnfind() {
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
		HttpSession session =request.getSession();
		String user=(String) session.getAttribute("username");
		
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
			
			Statement stmt1 = conn.createStatement();

			String sql = "select * from lend  where username='"+user+"'";
			String sql1 = "select * from car where carID in(select carID from lend where username='"+user+"');";
			// ִ�в�ѯ
			ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs1 = stmt1.executeQuery(sql1);
			// ʵ����List����
			List<Lend> list = new ArrayList<Lend>();
			List<Car> list1 = new ArrayList<Car>();
//			// �жϹ������ƶ������ж��Ƿ���Ч
			while(rs1.next()){
				rs.next();
				// ʵ��������
				Lend lend=new Lend();
				Car car=new Car();
				car.setCarID(rs1.getString("carID"));
				car.setBrand(rs1.getString("brand"));
				car.setType(rs1.getString("type"));
				car.setPrice(rs1.getFloat("price"));
				// ��id���Ը�ֵ
				lend.setCarID(rs.getString("carID"));
				lend.setUsername(rs.getString("username"));
				lend.setLasting(rs.getString("lasting"));
				lend.setLendtime(rs.getString("lendtime"));
				// ��������ӵ�������
				list.add(lend);
				list1.add(car);
			}
			// �����Ϸ��õ�request֮��
			request.setAttribute("list", list);
			request.setAttribute("list1",list1);
			rs.close();		// �ر�ResultSet
			rs1.close();
			stmt.close();	// �ر�Statement
			conn.close();	// �ر�Connection
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ����ת����
		request.getRequestDispatcher("../return.jsp").forward(request, response);
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
