package servlet;

import java.io.IOException;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
 
/**
 * Servlet implementation class Updateuser
 */
public class Updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;  
	Statement ps=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String name=new String(request.getParameter("username").getBytes("iso-8859-1"),"UTF-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd"); 
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String identity=request.getParameter("identity");
		try{
		// �������ݿ�������ע�ᵽ����������
		Class.forName("com.mysql.jdbc.Driver");
		// ���ݿ������ַ���
		String url = "jdbc:mysql://localhost:3306/zhizu";
		// ���ݿ��û���
		String dataname = "root";
		// ���ݿ�����
		String password = "7415369";
		// ����Connection����
		Connection conn = DriverManager.getConnection(url,dataname,password);
		String sql = "update user set pwd='"+pwd+"',tel='"+tel+"',email='"+email+"' where identity='"+identity+"'";
		Statement st=conn.createStatement();
		System.out.println(sql);
		st.executeUpdate(sql);
		System.out.println(name);
		System.out.println(tel);
		st.close();
		conn.close();

		} catch (Exception e) {
		e.printStackTrace();
		} 
		// �ض���
		response.sendRedirect("personfind");

	}

}
