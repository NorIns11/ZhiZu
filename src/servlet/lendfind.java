package servlet;

import ilk.Car;
import ilk.LendDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class lendfind extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public lendfind() {
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
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 当前页码
		int currPage = 1;
		// 判断传递页码是否有效
		if(request.getParameter("page") != null){
		// 对当前页码赋值
		currPage = Integer.parseInt(request.getParameter("page"));
		}
		// 实例化LendDao
		LendDao dao = new LendDao();
		// 查询所有商品信息
		List<Car> list = dao.find(currPage);
		// 将list放置到request之中
		request.setAttribute("list", list);
		// 总页数
		int pages ;
		// 查询总记录数
		int count = dao.findCount();
		// 计算总页数
		if(count % Car.PAGE_SIZE == 0){
		// 对总页数赋值
		pages = count / Car.PAGE_SIZE;
		}else{
		// 对总页数赋值
		pages = count / Car.PAGE_SIZE + 1;
		}
		// 实例化StringBuffer
		StringBuffer sb = new StringBuffer();
		// 通过循环构建分页条
		for(int i=1; i <= pages; i++){
		// 判断是否为当前页
		if(i == currPage){
		// 构建分页条
		sb.append("『" + i + "』");
		}else{
		// 构建分页条
		sb.append("<a href='servlet/lendfind?page=" + i + "'>" + i + "</a>");
		}
		// 构建分页条
		sb.append("　");
		}
		// 将分页条的字符串放置到request之中
		request.setAttribute("bar", sb.toString());
		// 转发到product_list.jsp页面
		request.getRequestDispatcher("../lendcar.jsp").forward(request, response);
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
