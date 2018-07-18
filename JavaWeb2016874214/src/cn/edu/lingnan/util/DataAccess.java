package cn.edu.lingnan.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/movie";
	public static String user = "root";
	public static String password = "123456";
	public static Connection conn = null;
	
	public static Connection getConnection(){
		
		try {
			//1.ע����������
			Class.forName(driver);
			//2.�������ݿ������
			conn = DriverManager.getConnection
					(url,user,password );
			}catch (ClassNotFoundException e) {
				System.out.println("�Ҳ��������࣬������jar��û�����");
				e.printStackTrace();
			}catch (SQLException e) {
				System.out.println("SQL����쳣");
				e.printStackTrace();
			}finally{
					
			}
		return conn;
	}
	public static void closeConnection(Connection conn){
		
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}