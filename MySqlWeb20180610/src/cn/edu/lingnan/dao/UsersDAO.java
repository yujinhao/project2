package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.UsersDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;


public class UsersDAO {
	PreparedStatement pre = null;
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	//��ѯ�����û���Ϣ
	public Vector<UsersDTO> findAllUsers() {
		Vector<UsersDTO> v = new Vector<UsersDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "select * from Users";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//��������
				UsersDTO u = new UsersDTO();
				u.setUserId(rs.getString("UserId"));
				u.setUserName(rs.getString("UserName"));
				u.setUserPassw(rs.getString("UserPassw"));
				u.setUserRoot(rs.getInt("UserRoot"));
				v.add(u);													
			}			
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}
		CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
		return v;
	}
	//����Id��ѯ�û���Ϣ
	public Vector<UsersDTO> findUserByUserId(String UserId) {
		Vector<UsersDTO> v = new Vector<UsersDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "select * from Users where UserId='"+UserId+"'";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//��������
				UsersDTO u = new UsersDTO();
				u.setUserId(rs.getString("UserId"));
				u.setUserName(rs.getString("UserName"));
				u.setUserPassw(rs.getString("UserPassw"));
				u.setUserRoot(rs.getInt("UserRoot"));
				v.add(u);							
//				System.out.print(rs.getString("UserId")+" ");
//				System.out.print(rs.getString("UserName")+" ");
//				System.out.print(rs.getString("UserPassw")+" ");
//				System.out.println(rs.getInt("UserRoot")+" ");							
			}			
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}
		CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
		return v;
	}
	//�����û�ID�������ѯ�û������ж�Ȩ��Ϊ����
	public int findUserByIdAndPassword(String UserId, String UserPassw){
		int UserRoot = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			prep = conn.prepareStatement
					("select * from Users where UserId = ? and UserPassw = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			prep.setString(1, UserId);
			prep.setString(2, UserPassw);
			rs = prep.executeQuery();
			if(rs.first()){
				UserRoot = Integer.parseInt(rs.getString("UserRoot"));
				System.out.println("---Ȩ��---"+UserRoot);
			}	
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
		return UserRoot;
	}
	public String findUserNameByIdAndPassword(String UserId, String UserPassw){
		String UserName = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			prep = conn.prepareStatement
					("select * from Users where UserId = ? and UserPassw = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			prep.setString(1, UserId);
			prep.setString(2, UserPassw);
			rs = prep.executeQuery();
			if(rs.first()){
				UserName = rs.getString("UserName");
				System.out.println("---�û���---"+UserName);
			}	
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
		return UserName;
	}
	//����û�
	public boolean addUserInfo(UsersDTO udto){
		boolean flag = false;
		String UserId = udto.getUserId();
		String UserName = udto.getUserName();
		String UserPassw = udto.getUserPassw();
		int UserRoot = udto.getUserRoot();
		String sql = "insert into Users values "
				+ "('"+UserId+"','"+UserName+"','"+UserPassw+"','"+UserRoot+"')";
		Connection conn = null;
		Statement stat = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
		return flag;
	}
	//�����û���Ϣ
	public boolean updateUserInfo(UsersDTO udto){
		boolean flag = false;
		String UserId = udto.getUserId();
		String UserName = udto.getUserName();
		String UserPassw = udto.getUserPassw();
		int UserRoot = udto.getUserRoot();
		String sql = "update Users set UserName='"+UserName+"',UserPassw='"+UserPassw+"',UserRoot='"+UserRoot+"' where UserId='"+UserId+"'";
		Connection conn = null;
		Statement stat = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
		return flag;
	}
	//�����û�IDɾ���û�
	public boolean deleteUserByUserId(String UserId){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "delete from Users where UserId = '"+UserId+"'";
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
		return flag;
	}
}
