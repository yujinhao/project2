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
			//1.注册驱动程序
			Class.forName(driver);
			//2.创建数据库的链接
			conn = DriverManager.getConnection
					(url,user,password );
			}catch (ClassNotFoundException e) {
				System.out.println("找不到链接类，估计是jar包没有添加");
				e.printStackTrace();
			}catch (SQLException e) {
				System.out.println("SQL语句异常");
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