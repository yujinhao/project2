package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.ClassDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

public class ClassDAO {
    //查询所有班级的信息
	public Vector<ClassDTO> findClass() {
		Vector<ClassDTO> v = new Vector<ClassDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from Class";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//处理结果集
				ClassDTO s = new ClassDTO();
				s.setClassId(rs.getString("ClassId"));
				s.setMajorId(rs.getString("MajorId"));
				s.setClassName(rs.getString("ClassName"));
				s.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(s);										
			}			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
    //根据班级ID查询信息
	public Vector<ClassDTO> findClassByClassid(String Classid) {
		Vector<ClassDTO> v = new Vector<ClassDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from Class where Classid='"+Classid+"'";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//处理结果集
				ClassDTO s = new ClassDTO();
				s.setClassId(rs.getString("ClassId"));
				s.setMajorId(rs.getString("MajorId"));
				s.setClassName(rs.getString("ClassName"));
				s.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(s);											
			}			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}

    //添加班级信息	
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
			stat = conn.createStatement();//创建SQL语句对象并执行
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat);
		return flag;
	}
	
    //更新班级信息	
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
			stat = conn.createStatement();//创建SQL语句对象并执行
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat);	
		return flag;
	}
	
    //根据班级id删除班级信息	
	public boolean deleteClassByClassId(String ClassId){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//创建SQL语句对象并执行
			String sql = "delete from Class where ClassId = '"+ClassId+"'";
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat);
		return flag;
	}
}