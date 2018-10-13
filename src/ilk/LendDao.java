package ilk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LendDao {
	public Connection getConnection(){
		// 数据库连接
		Connection conn = null;
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
		conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		// 返回数据库连接
		return conn;
		}
		public List<Car> find(int page){
		// 创建List
		List<Car> list = new ArrayList<Car>();
		// 获取数据库连接
		Connection conn = getConnection();
		// 分页查询的SQL语句
		String sql = "select * from car where status=true order by carID asc limit ?,?";
		try {
		// 获取PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		// 对SQL语句中的第1个参数赋值
		ps.setInt(1, (page - 1) * Car.PAGE_SIZE);
		// 对SQL语句中的第2个参数赋值
		ps.setInt(2, Car.PAGE_SIZE);
		// 执行查询操作
		ResultSet rs = ps.executeQuery();
		// 光标向后移动，并判断是否有效
		while(rs.next()){
			// 实例化对象
			Car car = new Car();
			// 对id属性赋值
			car.setCarID(rs.getString("carID"));
			// 对品牌属性赋值
			car.setBrand(rs.getString("brand"));
			// 对price属性赋值
			car.setPrice(rs.getFloat("price"));
			// 对型号属性赋值
			car.setType(rs.getString("type"));
			// 对状态属性赋值
			car.setStatus(rs.getBoolean("status"));
			// 将图书对象添加到集合中
			list.add(car);
		}
		// 关闭ResultSet
		rs.close();
		// 关闭PreparedStatement
		ps.close();
		// 关闭Connection
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return list;
		}
		
		public int findCount(){
		// 总记录数
		int count = 0;
		// 获取数据库连接
		Connection conn = getConnection();
		// 查询总记录数SQL语句
		String sql = "select count(*) from car";
		try {
		// 创建Statement
		Statement stmt = conn.createStatement();
		// 查询并获取ResultSet
		ResultSet rs = stmt.executeQuery(sql);
		// 光标向后移动，并判断是否有效
		if(rs.next()){
		// 对总记录数赋值
		count = rs.getInt(1);
		}
		// 关闭ResultSet
		rs.close();
		// 关闭Connection
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		// 返回总记录数
		return count;
		}
}
