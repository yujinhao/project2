package cn.edu.lingnan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.ScoreDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;


public class ScoreDAO {
	//查询所有的选课情况信息
	public  Vector<ScoreDTO> findAllScoreInfo() {
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from score";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setGrade(rs.getInt("Grade"));
				scoredto.setGradePoint(rs.getFloat("GradePoint"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	//根据学生id查询
	public  Vector<ScoreDTO>  findScoreByStudentId(String _id){
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("select * from score where StudentId=?");
		    prep.setString(1, _id);
			rs=prep.executeQuery();
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setGrade(rs.getInt("Grade"));
				scoredto.setGradePoint(rs.getFloat("GradePoint"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep, rs);
		return v;
	}
	
	//根据课程id查询
	public  Vector<ScoreDTO>  findScoreByCourseId(String _id){
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("select * from score where CourseId=?");
		    prep.setString(1, _id);
			rs=prep.executeQuery();
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setGrade(rs.getInt("Grade"));
				scoredto.setGradePoint(rs.getFloat("GradePoint"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep, rs);
		return v;
	}
	
	//根据学生id和课程id查询
	public  Vector<ScoreDTO>  findScoreByStudentIdandCourseId(String _StudentId,String _CourseId){
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("select * from score where StudentId=? and CourseId=?");
		    prep.setString(1, _StudentId);
		    prep.setString(2, _CourseId);
			rs=prep.executeQuery();
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setGrade(rs.getInt("Grade"));
				scoredto.setGradePoint(rs.getFloat("GradePoint"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep, rs);
		return v;
	}
	
	//添加选课情况信息(成绩和绩点不添，直接为空)
	public boolean addScoreInfo(ScoreDTO scoredto){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();		    
		    prep=conn.prepareStatement("exec Sore_Insert ?,?,?,?,?");
		    prep.setString(1, scoredto.getStudentId());
		    prep.setString(2, scoredto.getCourseId());
		    prep.setString(3,scoredto.getSchool());
		    prep.setInt(4,scoredto.getSemester());
		    prep.setInt(5,scoredto.getSign());
		    prep.execute();		    
		    flag=true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CourseSelectionDataAccess.closeconn(conn,prep);
		return flag;
	}
	
	//根据学生id删除记录
	public boolean deleteScoreByStudentId(String _StudentId){
        Connection conn=null;
        boolean flag=false;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("delete from score where StudentId=?");
		    prep.setString(1,_StudentId);
		    prep.execute();
			flag=true;
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}	
	
	//根据课程id删除记录
	public boolean deleteScoreByCourseId(String _CourseId){
        Connection conn=null;
        boolean flag=false;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("delete from score where CourseId=?");
		    prep.setString(1,_CourseId);
		    prep.execute();
			flag=true;
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}	
	
	//根据学生id和课程id号删除记录
	public boolean deleteScoreByStudentIdandCourseId(String _StudentId,String _CourseId){
        Connection conn=null;
        boolean flag=false;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    prep=conn.prepareStatement("delete from score where StudentId=? and CourseId=?");
		    prep.setString(1,_StudentId);
		    prep.setString(2,_CourseId);
		    prep.execute();
			flag=true;
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}	
	
	//更新选课情况（成绩绩点除外）信息
	public boolean updateScoreInfo(ScoreDTO scoredto){		
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();		      
		    prep=conn.prepareStatement("update score set School=?,Semester=?,Sign=? where StudentId=? and CourseId=?");
		    prep.setString(1,scoredto.getSchool());
		    prep.setInt(2,scoredto.getSemester());
		    prep.setInt(3,scoredto.getSign());
		    prep.setString(4, scoredto.getStudentId());
		    prep.setString(5, scoredto.getCourseId());
		    prep.execute();
			flag=true;			
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, prep);
		return flag;
	}
	
	//查询所有学生的选课情况信息视图
	public  Vector<ScoreDTO> findAllScoreViewInfo(){
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from scoreview";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setSchool(rs.getString("School"));
				scoredto.setSemester(rs.getInt("Semester"));
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setStudentName(rs.getString("StudentName"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setCourseName(rs.getString("CourseName"));
				scoredto.setCourseCredit(rs.getInt("CourseCredit"));
				scoredto.setCourseClass(rs.getInt("CourseClass"));
				scoredto.setCourseDesc(rs.getString("CourseDesc"));
				scoredto.setClassTime(rs.getString("ClassTime"));
				scoredto.setAddress(rs.getString("Address"));
				scoredto.setSign(rs.getInt("Sign"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	//查询学生的选课情况信息视图
	public  Vector<ScoreDTO> findAllScoreViewInfo(String id) {
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from scoreview where StudentId='"+id+"'";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setSchool(rs.getString("School"));
				scoredto.setSemester(rs.getInt("Semester"));
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setStudentName(rs.getString("StudentName"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setCourseName(rs.getString("CourseName"));
				scoredto.setCourseCredit(rs.getInt("CourseCredit"));
				scoredto.setCourseClass(rs.getInt("CourseClass"));
				scoredto.setCourseDesc(rs.getString("CourseDesc"));
				scoredto.setClassTime(rs.getString("ClassTime"));
				scoredto.setAddress(rs.getString("Address"));
				scoredto.setSign(rs.getInt("Sign"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	//查看学生成绩
	public  Vector<ScoreDTO> findAllGradeViewInfo() {
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from Gradeview";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setSchool(rs.getString("School"));
				scoredto.setSemester(rs.getInt("Semester"));
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setStudentName(rs.getString("StudentName"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setCourseName(rs.getString("CourseName"));
				scoredto.setCourseDesc(rs.getString("CourseDesc"));
				scoredto.setCourseCredit(rs.getInt("CourseCredit"));
				scoredto.setGrade(rs.getInt("Grade"));
				scoredto.setGradePoint(rs.getFloat("GradePoint"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
	
	//查看学生个人成绩
	public  Vector<ScoreDTO> findAllGradeViewInfo(String id) {
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
        Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
		    conn=CourseSelectionDataAccess.getConnection();
		    stat=conn.createStatement();
			String sql="select * from Gradeview where StudentId='"+id+"'";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				ScoreDTO scoredto=new ScoreDTO();
				scoredto.setSchool(rs.getString("School"));
				scoredto.setSemester(rs.getInt("Semester"));
				scoredto.setStudentId(rs.getString("StudentId"));
				scoredto.setStudentName(rs.getString("StudentName"));
				scoredto.setCourseId(rs.getString("CourseId"));
				scoredto.setCourseName(rs.getString("CourseName"));
				scoredto.setCourseDesc(rs.getString("CourseDesc"));
				scoredto.setCourseCredit(rs.getInt("CourseCredit"));
				scoredto.setGrade(rs.getInt("Grade"));
				scoredto.setGradePoint(rs.getFloat("GradePoint"));
				v.add(scoredto);
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}

	//根据CourseId查询
		public  Vector<ScoreDTO>  findRegisterGradeviewByCourseId(String CourseId){
			Vector<ScoreDTO> v=new Vector<ScoreDTO>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			    conn=CourseSelectionDataAccess.getConnection();
			    prep=conn.prepareStatement("select * from RegisterGradeview where CourseId=?");
			    prep.setString(1, CourseId);
				rs=prep.executeQuery();
				while(rs.next())
				{
					ScoreDTO scoredto=new ScoreDTO();
					scoredto.setStudentId(rs.getString("StudentId"));
					scoredto.setStudentName(rs.getString("StudentName"));
					scoredto.setCourseId(rs.getString("CourseId"));
					scoredto.setCourseName(rs.getString("CourseName"));
					scoredto.setGrade(rs.getInt("Grade"));
					scoredto.setGradePoint(rs.getFloat("GradePoint"));
					v.add(scoredto);
				}	
			} catch (SQLException e) {
					e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, prep, rs);
			return v;
		}


	//录入成绩
		public boolean updateGrade(ScoreDTO scoredto){		
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			try {
			    conn=CourseSelectionDataAccess.getConnection();		    
			    prep=conn.prepareStatement("update Score set Grade=?,GradePoint=? where StudentId=? and CourseId=?");
			    prep.setInt(1,scoredto.getGrade());
			    prep.setFloat(2, scoredto.getGradePoint());
			    prep.setString(3, scoredto.getStudentId());
			    prep.setString(4, scoredto.getCourseId());
			    prep.execute();
				flag=true;			
			} catch (SQLException e) {
					e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, prep);
			return flag;
		}
		
		//统计学期总学分
		public String countCourseCredit(String _StudentId,String _School,int _Semester ){		
			String AllCourseCredit="";
			Connection conn=null;
			CallableStatement cs=null;
			try {
			    conn=CourseSelectionDataAccess.getConnection();		    
			    cs=conn.prepareCall("declare @AllCourseCredit int exec Count_CourseCredit ?,?,?,?");
			    cs.setString(1, _StudentId);			
			    cs.setString(2, _School);
			    cs.setInt(3,_Semester);
			    cs.registerOutParameter(4,java.sql.Types.INTEGER);
			    cs.execute();
			    AllCourseCredit=cs.getString(4);			    		
			} catch (SQLException e) {
					e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, cs);
			return AllCourseCredit;
		}
		
		//查看学生个人学年的成绩
		public  Vector<ScoreDTO> findAllGradeViewInfo(String id,String _School,int _Semester) {
			Vector<ScoreDTO> v=new Vector<ScoreDTO>();
	        Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try {
			    conn=CourseSelectionDataAccess.getConnection();
			    stat=conn.createStatement();
				String sql="select * from Gradeview where StudentId='"+id+"' and School='"+_School+"' and Semester='"+_Semester+"'";
				rs=stat.executeQuery(sql);
				while(rs.next())
				{
					ScoreDTO scoredto=new ScoreDTO();
					scoredto.setSchool(rs.getString("School"));
					scoredto.setSemester(rs.getInt("Semester"));
					scoredto.setStudentId(rs.getString("StudentId"));
					scoredto.setStudentName(rs.getString("StudentName"));
					scoredto.setCourseId(rs.getString("CourseId"));
					scoredto.setCourseName(rs.getString("CourseName"));
					scoredto.setCourseDesc(rs.getString("CourseDesc"));
					scoredto.setCourseCredit(rs.getInt("CourseCredit"));
					scoredto.setGrade(rs.getInt("Grade"));
					scoredto.setGradePoint(rs.getFloat("GradePoint"));
					v.add(scoredto);
				}	
			} catch (SQLException e) {
					e.printStackTrace();
			} 
			CourseSelectionDataAccess.closeconn(conn, stat, rs);
			return v;
		}
}
