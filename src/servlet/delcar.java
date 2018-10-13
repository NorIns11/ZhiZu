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
		// ��ȡ����id
		String carID = String.valueOf(request.getParameter("carID"));
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
		// ɾ��������Ϣ��SQL���
		String sql = "delete from car where carID=?";
		// ��ȡPreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		// ��SQL����еĵ�һ��ռλ����ֵ
		ps.setString(1, carID);
		// ִ�и��²���
		ps.executeUpdate();
		// �ر�PreparedStatement
		ps.close();
		// �ر�Connection
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		} 
		// �ض���
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
