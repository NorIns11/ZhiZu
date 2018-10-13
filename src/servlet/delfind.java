package servlet;

import ilk.Car;
import ilk.CarDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delfind extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public delfind() {
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
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// ��ǰҳ��
	int currPage = 1;
	// �жϴ���ҳ���Ƿ���Ч
	if(request.getParameter("page") != null){
	// �Ե�ǰҳ�븳ֵ
	currPage = Integer.parseInt(request.getParameter("page"));
	}
	// ʵ����CarDao
	CarDao dao = new CarDao();
	// ��ѯ������Ʒ��Ϣ
	List<Car> list = dao.find(currPage);
	// ��list���õ�request֮��
	request.setAttribute("list", list);
	// ��ҳ��
	int pages ;
	// ��ѯ�ܼ�¼��
	int count = dao.findCount();
	// ������ҳ��
	if(count % Car.PAGE_SIZE == 0){
	// ����ҳ����ֵ
	pages = count / Car.PAGE_SIZE;
	}else{
	// ����ҳ����ֵ
	pages = count / Car.PAGE_SIZE + 1;
	}
	// ʵ����StringBuffer
	StringBuffer sb = new StringBuffer();
	// ͨ��ѭ��������ҳ��
	for(int i=1; i <= pages; i++){
	// �ж��Ƿ�Ϊ��ǰҳ
	if(i == currPage){
	// ������ҳ��
	sb.append("��" + i + "��");
	}else{
	// ������ҳ��
	sb.append("<a href='servlet/delfind?page=" + i + "'>" + i + "</a>");
	}
	// ������ҳ��
	sb.append("��");
	}
	// ����ҳ�����ַ������õ�request֮��
	request.setAttribute("bar", sb.toString());
	// ת����product_list.jspҳ��
	request.getRequestDispatcher("../delcar.jsp").forward(request, response);
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