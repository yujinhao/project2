package cn.edu.lingnan.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import cn.edu.lingnan.util.XmlParser;
import cn.edu.lingnan.util.XmlValidator;

public class CourseSelectionDataAccess {
	public static String driver=null;
	public static String url=null;
	public static String user=null;
	public static String password=null;
	public static Connection conn=null;
	private static String xmlPath="database.conf.xml";
	private static String xsdPath="database.conf.xsd";
	
	public static Connection getConnection() {
		if(XmlValidator.validator(xmlPath, xsdPath)){
			HashMap<String,String> hm=XmlParser.parser(xmlPath);
			driver=hm.get("driver");
			url=hm.get("url");
			user=hm.get("user");
			password=hm.get("password");	
		}	
		try {
			Class.forName(driver);//��һ����ע������
		    conn=DriverManager.getConnection(url, user, password);//�ڶ�����ȡ���ݿ�����
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ�jar������ʧ��......");
		} catch (SQLException e) {
			System.out.println("���ݿ����ӻ�ȡʧ��......");
		}
		return conn;
	}
	
	public static void closeconn(Connection conn,Statement stat,PreparedStatement prep,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(prep!=null){
				prep.close();
				prep=null;
			}
			if(stat!=null){
				stat.close();
				stat=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeconn(Connection conn,Statement stat,PreparedStatement prep){
		try {
			if(prep!=null){
				prep.close();
				prep=null;
			}
			if(stat!=null){
				stat.close();
				stat=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public static void closeconn(Connection conn,PreparedStatement prep,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(prep!=null){
				prep.close();
				prep=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeconn(Connection conn,Statement stat,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(stat!=null){
				stat.close();
				stat=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeconn(Connection conn,PreparedStatement prep){
		try {
			if(prep!=null){
				prep.close();
				prep=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public static void closeconn(Connection conn,Statement stat){
		try {
			if(stat!=null){
				stat.close();
				stat=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeconn(Connection conn,CallableStatement cs){
		try {
			if(cs!=null){
				cs.close();
				cs=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
