package cn.edu.lingnan.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.TeachersDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

     public class TeachersDAO {	
		public Vector<TeachersDTO> findAllTeachers() {
			Vector<TeachersDTO> v = new Vector<TeachersDTO>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = CourseSelectionDataAccess.getConnection();
				stat = conn.createStatement();//创建SQL语句对象并执行
				String sql = "select * from Teachers";
				stat.executeQuery(sql);
				rs = stat.executeQuery(sql);
				while(rs.next()){//处理结果集
					TeachersDTO t = new TeachersDTO();
					t.setTeacherId(rs.getString("TeacherId"));
					t.setDeptId(rs.getString("DeptId"));
					t.setTeacherName(rs.getString("TeacherName"));
					t.setTeacherSex(rs.getString("TeacherSex"));					
					t.setTeacherTitle(rs.getString("TeacherTitle"));
					t.setTeacherPassw(rs.getString("TeacherPassw"));
					v.add(t);														
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, stat,rs);
			return v;
		}
		
		public Vector<TeachersDTO> findTeacherByTeacherId(String TeacherId) {
			Vector<TeachersDTO> v = new Vector<TeachersDTO>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = CourseSelectionDataAccess.getConnection();
				stat = conn.createStatement();//创建SQL语句对象并执行
				String sql = "select * from Teachers where TeacherId='"+TeacherId+"'";
				stat.executeQuery(sql);
				rs = stat.executeQuery(sql);
				while(rs.next()){//处理结果集
					TeachersDTO t = new TeachersDTO();
					t.setTeacherId(rs.getString("TeacherId"));
					t.setDeptId(rs.getString("DeptId"));
					t.setTeacherName(rs.getString("TeacherName"));
					t.setTeacherSex(rs.getString("TeacherSex"));					
					t.setTeacherTitle(rs.getString("TeacherTitle"));
					t.setTeacherPassw(rs.getString("TeacherPassw"));
					v.add(t);														
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, stat,rs);
			return v;
		}
		
		public boolean addTeacherInfo(TeachersDTO tdto){
			boolean flag = false;
			String TeacherId = tdto.getTeacherId();
			String DeptId = tdto.getDeptId();
			String TeacherName = tdto.getTeacherName();
			String TeacherSex = tdto.getTeacherSex();			
			String TeacherTitle = tdto.getTeacherTitle();
			String TeacherPassw = tdto.getTeacherPassw();
			String sql = "exec Teachers_Insert "
					+ "'"+TeacherId+"','"+DeptId+"','"+TeacherName+"','"+TeacherSex+"','"+TeacherTitle+"','"+TeacherPassw+"'";
			Connection conn = null;
			Statement stat = null;
			try {
				conn = CourseSelectionDataAccess.getConnection();
				stat = conn.createStatement();//创建SQL语句对象并执行
				stat.executeUpdate(sql);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, stat);
			return flag;
		}
		
		public boolean updateTeacherInfo(TeachersDTO tdto){
			boolean flag = false;			
			String TeacherId = tdto.getTeacherId();
			String DeptId = tdto.getDeptId();
			String TeacherName = tdto.getTeacherName();
			String TeacherSex = tdto.getTeacherSex();			
			String TeacherTitle = tdto.getTeacherTitle();
			String TeacherPassw = tdto.getTeacherPassw();			
			String sql = "update Teachers set DeptId='"+DeptId+"',TeacherName='"+TeacherName+"',TeacherSex='"+TeacherSex+"',TeacherTitle='"+TeacherTitle+"',TeacherPassw='"+TeacherPassw+"' where TeacherId='"+TeacherId+"'";						
			Connection conn = null;
			Statement stat = null;
			try {
				conn = CourseSelectionDataAccess.getConnection();
				stat = conn.createStatement();//创建SQL语句对象并执行
				stat.executeUpdate(sql);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, stat);
			return flag;
		}
				
		public boolean deleteTeacherByTeacherId(String TeacherId){
			boolean flag = false;
			Connection conn = null;
			Statement stat = null;
			try { 
				conn = CourseSelectionDataAccess.getConnection();
				stat = conn.createStatement();//创建SQL语句对象并执行			
				String sql = "exec Delete_Teachers '"+TeacherId+"'";				
				stat.executeUpdate(sql);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, stat);
			return flag;
		}		
	}

