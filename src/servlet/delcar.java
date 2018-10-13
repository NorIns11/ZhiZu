package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delcar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public delcar() {
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
		// 获取车辆id
		String carID = String.valueOf(request.getParameter("carID"));
		try {
		// 加载数据库驱动，注册到驱动管理器
		Class.forName("com.mysql.jdbc.Driver");
		// 数据库连接字符串
		String url = "jdbc:mysql://localhost:3306/zhizu";
		// 数据库用户名
		String username = "root";
		// 数据库密码
		String password = "7415369";
		// 创建Connection连接
		Connection conn = DriverManager.getConnection(url,username,password);
		// 删除车辆信息的SQL语句
		String sql = "delete from car where carID=?";
		// 获取PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		// 对SQL语句中的第一个占位符赋值
		ps.setString(1, carID);
		// 执行更新操作
		ps.executeUpdate();
		// 关闭PreparedStatement
		ps.close();
		// 关闭Connection
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		} 
		// 重定向到
		response.sendRedirect("delfind");
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

		doGet(request, response);
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
