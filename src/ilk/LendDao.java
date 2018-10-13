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
		// ���ݿ�����
		Connection conn = null;
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
		conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		// �������ݿ�����
		return conn;
		}
		public List<Car> find(int page){
		// ����List
		List<Car> list = new ArrayList<Car>();
		// ��ȡ���ݿ�����
		Connection conn = getConnection();
		// ��ҳ��ѯ��SQL���
		String sql = "select * from car where status=true order by carID asc limit ?,?";
		try {
		// ��ȡPreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		// ��SQL����еĵ�1��������ֵ
		ps.setInt(1, (page - 1) * Car.PAGE_SIZE);
		// ��SQL����еĵ�2��������ֵ
		ps.setInt(2, Car.PAGE_SIZE);
		// ִ�в�ѯ����
		ResultSet rs = ps.executeQuery();
		// �������ƶ������ж��Ƿ���Ч
		while(rs.next()){
			// ʵ��������
			Car car = new Car();
			// ��id���Ը�ֵ
			car.setCarID(rs.getString("carID"));
			// ��Ʒ�����Ը�ֵ
			car.setBrand(rs.getString("brand"));
			// ��price���Ը�ֵ
			car.setPrice(rs.getFloat("price"));
			// ���ͺ����Ը�ֵ
			car.setType(rs.getString("type"));
			// ��״̬���Ը�ֵ
			car.setStatus(rs.getBoolean("status"));
			// ��ͼ�������ӵ�������
			list.add(car);
		}
		// �ر�ResultSet
		rs.close();
		// �ر�PreparedStatement
		ps.close();
		// �ر�Connection
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return list;
		}
		
		public int findCount(){
		// �ܼ�¼��
		int count = 0;
		// ��ȡ���ݿ�����
		Connection conn = getConnection();
		// ��ѯ�ܼ�¼��SQL���
		String sql = "select count(*) from car";
		try {
		// ����Statement
		Statement stmt = conn.createStatement();
		// ��ѯ����ȡResultSet
		ResultSet rs = stmt.executeQuery(sql);
		// �������ƶ������ж��Ƿ���Ч
		if(rs.next()){
		// ���ܼ�¼����ֵ
		count = rs.getInt(1);
		}
		// �ر�ResultSet
		rs.close();
		// �ر�Connection
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		// �����ܼ�¼��
		return count;
		}
}
