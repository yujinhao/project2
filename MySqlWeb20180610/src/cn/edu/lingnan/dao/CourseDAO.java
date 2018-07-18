package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.CourseDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

public class CourseDAO {	
	public Vector<CourseDTO> findAllCourse() {
		Vector<CourseDTO> v = new Vector<CourseDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from Course";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//处理结果集
				CourseDTO cou = new CourseDTO();
				cou.setCourseId(rs.getString("CourseId"));
				cou.setCourseName(rs.getString("CourseName"));
				cou.setCourseCredit(rs.getInt("CourseCredit"));
				cou.setCourseClass(rs.getInt("CourseClass"));
				cou.setCourseDesc(rs.getString("CourseDesc"));
				cou.setClassTime(rs.getString("ClassTime"));
				cou.setAddress(rs.getString("Address"));
				cou.setVolume(rs.getInt("Volume"));
				cou.setRemain(rs.getInt("Remain"));
				v.add(cou);							
			}			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	//找到所有剩余课程
	public Vector<CourseDTO> findAllRemainCourse() {
		Vector<CourseDTO> v = new Vector<CourseDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from CourseRemainview";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//处理结果集
				CourseDTO cou = new CourseDTO();
				cou.setCourseId(rs.getString("CourseId"));
				cou.setCourseName(rs.getString("CourseName"));
				cou.setCourseCredit(rs.getInt("CourseCredit"));
				cou.setCourseClass(rs.getInt("CourseClass"));
				cou.setCourseDesc(rs.getString("CourseDesc"));
				cou.setClassTime(rs.getString("ClassTime"));
				cou.setAddress(rs.getString("Address"));
				cou.setVolume(rs.getInt("Volume"));
				cou.setRemain(rs.getInt("Remain"));
				v.add(cou);							
			}			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	public Vector<CourseDTO> findCourseByCourseId(String CourseId) {
		Vector<CourseDTO> v = new Vector<CourseDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//创建SQL语句对象并执行
			String sql = "select * from Course where CourseId='"+CourseId+"'";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//处理结果集
				CourseDTO cou = new CourseDTO();
				cou.setCourseId(rs.getString("CourseId"));
				cou.setCourseName(rs.getString("CourseName"));
				cou.setCourseCredit(rs.getInt("CourseCredit"));
				cou.setCourseClass(rs.getInt("CourseClass"));
				cou.setCourseDesc(rs.getString("CourseDesc"));
				cou.setClassTime(rs.getString("ClassTime"));
				cou.setAddress(rs.getString("Address"));
				cou.setVolume(rs.getInt("Volume"));
				cou.setRemain(rs.getInt("Remain"));
				v.add(cou);							
			}			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	public boolean addCourseInfo(CourseDTO cdto){
		boolean flag = false;
		String CourseId = cdto.getCourseId();
		String CourseName = cdto.getCourseName();
		int CourseCredit = cdto.getCourseCredit();
		int CourseClass = cdto.getCourseClass();
		String CourseDesc = cdto.getCourseDesc();
		String ClassTime = cdto.getClassTime();
		String Address = cdto.getAddress();
		int Volume = cdto.getVolume();
		int Remain = cdto.getRemain();
		String sql = "exec Course_Insert "
				+ "'"+CourseId+"','"+CourseName+"','"+CourseCredit+"','"+CourseClass+"','"+CourseDesc+"','"+ClassTime+"','"+Address+"','"+Volume+"','"+Remain+"'";
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
	
	public boolean updateCourseInfo(CourseDTO cdto){
		boolean flag = false;
		String CourseId = cdto.getCourseId();
		String CourseName = cdto.getCourseName();
		int CourseCredit = cdto.getCourseCredit();
		int CourseClass = cdto.getCourseClass();
		String CourseDesc = cdto.getCourseDesc();
		String ClassTime = cdto.getClassTime();
		String Address = cdto.getAddress();
		int Volume = cdto.getVolume();
		int Remain = cdto.getRemain();
		String sql = "update Course set CourseName='"+CourseName+"',CourseCredit='"+CourseCredit+"',CourseClass='"+CourseClass+"',CourseDesc='"+CourseDesc+"',ClassTime='"+ClassTime+"',Address='"+Address+"',Volume='"+Volume+"',Remain='"+Remain+"' where CourseId='"+CourseId+"'";
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
	
	public boolean deleteCourseByCourseId(String CourseId){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//创建SQL语句对象并执行
			String sql = "exec Delete_Course '"+CourseId+"'";
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