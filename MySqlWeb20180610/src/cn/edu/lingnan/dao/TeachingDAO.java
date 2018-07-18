package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.TeachingDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

public class TeachingDAO {
	//查询所有的授课情况信息
	public  Vector<TeachingDTO> findAllTeachingInfo() {
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from teaching";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				TeachingDTO teachingdto=new TeachingDTO();
				teachingdto.setTeacherId(rs.getString("TeacherId"));
				teachingdto.setCourseId(rs.getString("CourseId"));
				teachingdto.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(teachingdto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	
	//根据教师id查询
	public  Vector<TeachingDTO> findTeachingByTeacherId(String _id){
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("select * from teaching where TeacherId=?");
		    prep.setString(1, _id);
			rs=prep.executeQuery();
			while(rs.next())
			{
				TeachingDTO teachingdto=new TeachingDTO();
				teachingdto.setTeacherId(rs.getString("TeacherId"));
				teachingdto.setCourseId(rs.getString("CourseId"));
				teachingdto.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(teachingdto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep, rs);
		return v;
	}
	
	//根据课程id查询
	public  Vector<TeachingDTO> findTeachingByCourseId(String _id){
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("select * from teaching where CourseId=?");
		    prep.setString(1, _id);
			rs=prep.executeQuery();
			while(rs.next())
			{
				TeachingDTO teachingdto=new TeachingDTO();
				teachingdto.setTeacherId(rs.getString("TeacherId"));
				teachingdto.setCourseId(rs.getString("CourseId"));
				teachingdto.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(teachingdto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep, rs);
		return v;
	}
	
	//根据教师id和课程id查询
	public  Vector<TeachingDTO> findTeachingByTeacherIdandCourseId(String _TeacherId,String _CourseId){
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("select * from teaching where TeacherId=? and CourseId=?");
		    prep.setString(1, _TeacherId);
		    prep.setString(2, _CourseId);
			rs=prep.executeQuery();
			while(rs.next())
			{
				TeachingDTO teachingdto=new TeachingDTO();
				teachingdto.setTeacherId(rs.getString("TeacherId"));
				teachingdto.setCourseId(rs.getString("CourseId"));
				teachingdto.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(teachingdto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep, rs);
		return v;
	}
	
	//添加授课情况信息
	public boolean addTeachingInfo(TeachingDTO teachingdto){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
			prep=conn.prepareStatement("exec Teaching_Insert ?,?,?");
			prep.setString(1, teachingdto.getTeacherId());
			prep.setString(2, teachingdto.getCourseId());
			prep.setInt(3, teachingdto.getStudentsNumber());
			prep.execute();		    
			flag=true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CourseSelectionDataAccess.closeconn(conn,prep);
		return flag;
	}
	
	//根据教师id删除记录
	public boolean deleteTeachingByTeacherId(String _TeacherId){
        Connection conn=null;
        boolean flag=false;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("delete from teaching where TeacherId=?");
		    prep.setString(1,_TeacherId);
		    prep.execute();
			flag=true;
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}	
	
	//根据课程id号删除记录
	public boolean deleteTeachingByCourseId(String _CourseId){
        Connection conn=null;
        boolean flag=false;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("delete from teaching where CourseId=?");
		    prep.setString(1,_CourseId);
		    prep.execute();
			flag=true;
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}	
	
	//根据教师id和课程id号删除记录
	public boolean deleteTeachingByTeacherIdandCourseId(String _TeacherId,String _CourseId){
        Connection conn=null;
        boolean flag=false;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("delete from teaching where TeacherId=? and CourseId=?");
		    prep.setString(1,_TeacherId);
		    prep.setString(2,_CourseId);
		    prep.execute();
			flag=true;
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}	
	
	//更新授课情况信息
	public boolean updateTeachingInfo(TeachingDTO teachingdto){		
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();		    
		    prep=conn.prepareStatement("update teaching set StudentsNumber=? where TeacherId=? and CourseId=?");
			prep.setInt(1, teachingdto.getStudentsNumber());
		    prep.setString(2, teachingdto.getTeacherId());
			prep.setString(3, teachingdto.getCourseId());
			prep.execute();
			flag=true;			
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}
	
	//查询所有的授课情况信息
	public  Vector<TeachingDTO> findAllTeachingviewInfo() {
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from teachingview";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				TeachingDTO teachingdto=new TeachingDTO();
				teachingdto.setTeacherId(rs.getString("TeacherId"));
				teachingdto.setTeacherName(rs.getString("TeacherName"));
				teachingdto.setCourseId(rs.getString("CourseId"));
				teachingdto.setCourseName(rs.getString("CourseName"));
				teachingdto.setCourseDesc(rs.getString("CourseDesc"));
				teachingdto.setClassTime(rs.getString("ClassTime"));
				teachingdto.setAddress(rs.getString("Address"));
				teachingdto.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(teachingdto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	//查询老师个人的授课情况信息
	public  Vector<TeachingDTO> findTeachingviewInfoByTeacherId(String TeacherId) {
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from teachingview where TeacherId='"+TeacherId+"'";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				TeachingDTO teachingdto=new TeachingDTO();
				teachingdto.setTeacherId(rs.getString("TeacherId"));
				teachingdto.setTeacherName(rs.getString("TeacherName"));
				teachingdto.setCourseId(rs.getString("CourseId"));
				teachingdto.setCourseName(rs.getString("CourseName"));
				teachingdto.setCourseDesc(rs.getString("CourseDesc"));
				teachingdto.setClassTime(rs.getString("ClassTime"));
				teachingdto.setAddress(rs.getString("Address"));
				teachingdto.setStudentsNumber(rs.getInt("StudentsNumber"));
				v.add(teachingdto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
}
