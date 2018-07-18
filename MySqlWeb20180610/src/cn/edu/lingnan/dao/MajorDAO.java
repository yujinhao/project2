package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.MajorDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

public class MajorDAO {
	boolean flag=false;
	Connection conn=null;
	PreparedStatement pre=null;
	ResultSet rs=null;
	Statement stat=null;
	
	//��ѯ����רҵ��Ϣ
	public Vector<MajorDTO> findAllMajorInfo(){
		Vector<MajorDTO> v=new Vector<MajorDTO>();
		try{
			conn=CourseSelectionDataAccess.getConnection();
			stat=conn.createStatement();
	    	 String sql="select * from major";
	    	 rs=stat.executeQuery(sql);
	    	 while(rs.next()){
	    		 MajorDTO majordto=new MajorDTO();
	    		 majordto.setMajorId(rs.getString("MajorId"));
	    		 majordto.setDeptId(rs.getString("DeptId"));
	    		 majordto.setMajorName(rs.getString("MajorName"));
	    		 majordto.setClassNumber(rs.getInt("ClassNumber"));
	    		 v.add(majordto);
	    	 }
		}catch (SQLException e) {
			System.out.println("���������ִ���");
			e.printStackTrace();
			} 
	     finally{
	    	 CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
	     }	
		return v;
	}
	
	//����רҵ��Id�Ų�ѯĳ��רҵ����Ϣ
	public Vector<MajorDTO> findMajorByMajorId(String MajorId){
		Vector<MajorDTO> v=new Vector<MajorDTO>();
		try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="select * from major where MajorId='"+MajorId+"'";
	    	 rs=stat.executeQuery(sql);
	    	 while(rs.next()){
	    		 MajorDTO majordto=new MajorDTO();
	    		 majordto.setMajorId(rs.getString("MajorId"));
	    		 majordto.setDeptId(rs.getString("DeptId"));
	    		 majordto.setMajorName(rs.getString("MajorName"));
	    		 majordto.setClassNumber(rs.getInt("ClassNumber"));
	    		 v.add(majordto);
	    	 }
		}catch (SQLException e) {
			System.out.println("���������ִ���");
			e.printStackTrace();
			} 
	     finally{
	    	 CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
	     }	
		return v;
	}
	
	
	//���רҵ��Ϣ
	public boolean addMajorInfo(MajorDTO majordto){
		try {
	    	   conn=CourseSelectionDataAccess.getConnection();
	    	   pre=conn.prepareStatement("insert into major values(?,?,?,?)");
			   pre.setString(1, majordto.getMajorId());
			   pre.setString(2, majordto.getDeptId());
			   pre.setString(3, majordto.getMajorName());
			   pre.setInt(4,majordto.getClassNumber());
			   pre.execute();
			   flag=true;
	    } catch (SQLException e) {
			System.out.println("���������ִ���");
			e.printStackTrace();
			} 
	     finally{
	    	 CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
	     }	
		return flag;	
	}

	//����רҵ��Ϣ
	public boolean updateMajorInfo(MajorDTO majordto){
		boolean flag=false;
		String MajorId=majordto.getMajorId();
		String DeptId=majordto.getDeptId();
                String MajorName=majordto.getMajorName();
		int ClassNumber = majordto.getClassNumber();
		String sql="update major set DeptId='"+DeptId+"', MajorName='"+MajorName+"',"
				+ "ClassNumber='"+ClassNumber+"' where MajorId='"+MajorId+"'";
		 try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
			 stat.executeUpdate(sql);
			 flag=true;		
	    } catch (SQLException e) {
			System.out.println("���������ִ���");
			e.printStackTrace();
			} 
	     finally{
	    	 CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
	     }	
		 return flag;
    }
	
	//����רҵ��Id��ɾ��ĳ��רҵ��Ϣ
	public boolean deleteMajorByMajorId(String MajorId){
		try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="delete from major where MajorId='"+MajorId+"'";
			 stat.executeUpdate(sql);
			 flag=true;		
	    } catch (SQLException e) {
			System.out.println("���������ִ���");
			e.printStackTrace();
			} 
	     finally{
	    	 CourseSelectionDataAccess.closeconn(conn, stat, pre, rs);
	     }	
		return flag;
	}

}