package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.StudentsDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

public class StudentsDAO {
    //��ѯ����ѧ����Ϣ	
	public Vector<StudentsDTO> findAllStudents() {
		Vector<StudentsDTO> v = new Vector<StudentsDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "select * from Students";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//��������
				StudentsDTO s = new StudentsDTO();
				s.setStudentId(rs.getString("StudentId"));
				s.setClassId(rs.getString("ClassId"));
				s.setStudentName(rs.getString("StudentName"));
				s.setStudentSex(rs.getString("StudentSex"));
				s.setStudentAge(rs.getInt("StudentAge"));
				s.setEntranceTime(rs.getString("EntranceTime"));
				s.setStudentPassw(rs.getString("StudentPassw"));
				v.add(s);											
			}			
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}
    //����ѧ��ID��ѯѧ����Ϣ
    public Vector<StudentsDTO> findStudentByStudentid(String studentid) {
		Vector<StudentsDTO> v = new Vector<StudentsDTO>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "exec Query_Students_S '"+studentid+"'";
			stat.executeQuery(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){//��������
				StudentsDTO s = new StudentsDTO();
				s.setStudentId(rs.getString("StudentId"));
				s.setClassId(rs.getString("ClassId"));
				s.setStudentName(rs.getString("StudentName"));
				s.setStudentSex(rs.getString("StudentSex"));
				s.setStudentAge(rs.getInt("StudentAge"));
				s.setEntranceTime(rs.getString("EntranceTime"));
				s.setStudentPassw(rs.getString("StudentPassw"));
				v.add(s);									
			}			
		} catch (SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		} 
		CourseSelectionDataAccess.closeconn(conn, stat, rs);
		return v;
	}

    //���ѧ����Ϣ		
	public boolean addStudentInfo(StudentsDTO sdto){
		boolean flag = false;
		String StudentId = sdto.getStudentId();
		String ClassId = sdto.getClassId();
		String StudentName = sdto.getStudentName();
		String StudentSex = sdto.getStudentSex();
		int StudentAge = sdto.getStudentAge();
		String EntranceTime = sdto.getEntranceTime();
		String StudentPassw = sdto.getStudentPassw();
		String sql = "exec Students_Insert "
				+ "'"+StudentId+"','"+ClassId+"','"+StudentName+"','"+StudentSex+"','"+StudentAge+"','"+EntranceTime+"','"+StudentPassw+"'";
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
	
    //����ѧ����Ϣ	
	public boolean updateStudentInfo(StudentsDTO sdto){
		boolean flag = false;
		String StudentId = sdto.getStudentId();
		String ClassId = sdto.getClassId();
		String StudentName = sdto.getStudentName();
		String StudentSex = sdto.getStudentSex();
		int StudentAge = sdto.getStudentAge();
		String EntranceTime = sdto.getEntranceTime();
		String StudentPassw = sdto.getStudentPassw();
		String sql = "update Students set ClassId='"+ClassId+"',StudentName='"+StudentName+"',StudentSex='"+StudentSex+"',StudentAge='"+StudentAge+"',EntranceTime='"+EntranceTime+"',StudentPassw='"+StudentPassw+"' where StudentId='"+StudentId+"'";
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
	
    //����ѧ��ID����ѧ������	
	public boolean updateStudentPasswordBystudentid(StudentsDTO sdto){
		boolean flag = false;
		String StudentId = sdto.getStudentId();
		String StudentPassw = sdto.getStudentPassw();
		String sql = "update Students set StudentPassw='"+StudentPassw+"' where StudentId='"+StudentId+"'";
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
	
    //����ѧ��IDɾ��ѧ����Ϣ	
	public boolean deleteStudentByStudentId(String StudentId){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try { 
			conn = CourseSelectionDataAccess.getConnection();
			stat = conn.createStatement();//����SQL������ִ��
			String sql = "exec Delete_Students '"+StudentId+"'";
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