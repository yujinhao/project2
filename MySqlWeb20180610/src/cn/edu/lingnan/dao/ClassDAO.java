package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.ClassDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

public class ClassDAO {
    //��ѯ���а༶����Ϣ
	public Vector<ClassDTO> findClass() {
		Vector<ClassDTO> v = new Vector<ClassDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "select * from Class";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//��������
				ClassDTO s = new ClassDTO();
				s.setClassId(rs.getString("ClassId"));
				s.setMajorId(rs.getString("MajorId"));
				s.setClassName(rs.getString("ClassName"));
				s.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(s);										
			}			
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
    //���ݰ༶ID��ѯ��Ϣ
	public Vector<ClassDTO> findClassByClassid(String Classid) {
		Vector<ClassDTO> v = new Vector<ClassDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "select * from Class where Classid='"+Classid+"'";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//��������
				ClassDTO s = new ClassDTO();
				s.setClassId(rs.getString("ClassId"));
				s.setMajorId(rs.getString("MajorId"));
				s.setClassName(rs.getString("ClassName"));
				s.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(s);											
			}			
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}

    //��Ӱ༶��Ϣ	
	public boolean addClassInfo(ClassDTO cdto){
		boolean flag = false;
		String ClassId = cdto.getClassId();
		String MajorId = cdto.getMajorId();
		String ClassName = cdto.getClassName();
		int StudentsNumber = cdto.getStudentsNumber();
		String sql = "insert into Class values "
				+ "('"+ClassId+"','"+MajorId+"','"+ClassName+"','"+StudentsNumber+"')";
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
		CourseSelectionDataAccess.closeconn(conn, stat);
		return flag;
	}
	
    //���°༶��Ϣ	
	public boolean updateClassInfo(ClassDTO cdto){
		boolean flag = false;
		String ClassId = cdto.getClassId();
		String MajorId = cdto.getMajorId();
		String ClassName = cdto.getClassName();
		int StudentsNumber = cdto.getStudentsNumber();
		String sql = "update Class set MajorId='"+MajorId+"',ClassName='"+ClassName+"',StudentsNumber='"+StudentsNumber+"' where ClassId='"+ClassId+"'";
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
		CourseSelectionDataAccess.closeconn(conn, stat);	
		return flag;
	}
	
    //���ݰ༶idɾ���༶��Ϣ	
	public boolean deleteClassByClassId(String ClassId){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "delete from Class where ClassId = '"+ClassId+"'";
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat);
		return flag;
	}
}