package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.DeptDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;


public class DeptDAO {
	boolean flag=false;
	Connection conn=null;
	PreparedStatement pre=null;
	ResultSet rs=null;
	Statement stat=null;
	
	//��ѯ����Ժϵ����Ϣ
	public Vector<DeptDTO> findAllDeptInfo(){
		Vector<DeptDTO> v=new Vector<DeptDTO>();
		try{
		      conn=CourseSelectionDataAccess.getConnection();
	              stat=conn.createStatement();
	    	      String sql="select * from dept";
	    	      rs=stat.executeQuery(sql);
	    	      while(rs.next()){
	    		 DeptDTO deptdto=new DeptDTO();
	    		 deptdto.setDeptId(rs.getString("DeptId"));
	    		 deptdto.setDeptName(rs.getString("DeptName"));
	    		 deptdto.setDeptChairman(rs.getString("DeptChairman"));
	    		 deptdto.setDeptTel(rs.getString("DeptTel"));
	    		 v.add(deptdto);
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
	
	//����Ժϵ��Id�Ų�ѯĳ��Ժϵ��Ϣ
	public Vector<DeptDTO> findDeptByDeptId(String DeptId){
		Vector<DeptDTO> v=new Vector<DeptDTO>();
		try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="select * from dept where DeptId='"+DeptId+"'";
	    	 rs=stat.executeQuery(sql);
	    	 while(rs.next()){
	    		 DeptDTO deptdto=new DeptDTO();
	    		 deptdto.setDeptId(rs.getString("DeptId"));
	    		 deptdto.setDeptName(rs.getString("DeptName"));
	    		 deptdto.setDeptChairman(rs.getString("DeptChairman"));
	    		 deptdto.setDeptTel(rs.getString("DeptTel"));
	    		 v.add(deptdto);
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
	
	
	//���Ժϵ��Ϣ
	public boolean addDeptInfo(DeptDTO deptdto){
		try {
	    	   conn=CourseSelectionDataAccess.getConnection();
	    	   pre=conn.prepareStatement("insert into dept values(?,?,?,?)");
			   pre.setString(1,deptdto.getDeptId());
			   pre.setString(2,deptdto.getDeptName());
			   pre.setString(3, deptdto.getDeptChairman());
			   pre.setString(4,deptdto.getDeptTel());
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

	//����Ժϵ��Ϣ
	public boolean updateDeptInfo(DeptDTO deptdto){
		boolean flag=false;
		String DeptId=deptdto.getDeptId();
		String DeptName=deptdto.getDeptName();
		String DeptChairman=deptdto.getDeptChairman();
		String DeptTel = deptdto.getDeptTel();
		String sql="update dept set DeptName='"+DeptName+"',DeptChairman='"+DeptChairman+"',"
				+ "DeptTel='"+DeptTel+"' where DeptId='"+DeptId+"'";
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
	
	
	//����ԺϵId��ɾ��ĳ��Ժϵ��Ϣ
	public boolean deleteDeptByDeptId(String DeptId){	
		try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="delete from dept where DeptId='"+DeptId+"'";
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