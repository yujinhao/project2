package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.ManagersDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

        public class ManagersDAO {
			public Vector<ManagersDTO> findAllManagers() {
				Vector<ManagersDTO> v = new Vector<ManagersDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = CourseSelectionDataAccess.getConnection();
					stat = conn.createStatement();//����SQL������ִ��
					String sql = "select * from Managers";
					stat.executeQuery(sql);
					rs = stat.executeQuery(sql);
					while(rs.next()){//��������
						ManagersDTO m = new ManagersDTO();
						m.setManagerId(rs.getString("ManagerId"));					
						m.setManagerName(rs.getString("ManagerName"));
						m.setManagerSex(rs.getString("ManagerSex"));						
						m.setManagerTel(rs.getInt("ManagerTel"));
						m.setManagerAddr(rs.getString("ManagerAddr"));
						m.setManagerPassw("ManagerPassw");
						v.add(m);							
					}			
				} catch (SQLException e) {
					e.printStackTrace();
				}
				CourseSelectionDataAccess.closeconn(conn, stat, rs);
				return v;
			}
			
			public Vector<ManagersDTO> findManagerByManagerId(String ManagerId) {
				Vector<ManagersDTO> v = new Vector<ManagersDTO>();
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
				try {
					conn = CourseSelectionDataAccess.getConnection();
					stat = conn.createStatement();//����SQL������ִ��
					String sql = "select * from Managers where ManagerId='"+ManagerId+"'";
					stat.executeQuery(sql);
					rs = stat.executeQuery(sql);
					while(rs.next()){//��������
						ManagersDTO m = new ManagersDTO();
						m.setManagerId(rs.getString("ManagerId"));					
						m.setManagerName(rs.getString("ManagerName"));
						m.setManagerSex(rs.getString("ManagerSex"));						
						m.setManagerTel(rs.getInt("ManagerTel"));
						m.setManagerAddr(rs.getString("ManagerAddr"));
						m.setManagerPassw(rs.getString("ManagerPassw"));
						v.add(m);							
					}			
				} catch (SQLException e) {
					e.printStackTrace();
				}
				CourseSelectionDataAccess.closeconn(conn, stat, rs);
				return v;
			}
									
			public boolean addManagerInfo(ManagersDTO mdto){
				boolean flag = false;
				String ManagerId = mdto.getManagerId();
				String ManagerName = mdto.getManagerName();
				String ManagerSex = mdto.getManagerSex();
				int ManagerTel = mdto.getManagerTel();
				String ManagerAddr = mdto.getManagerAddr();
				String ManagerPassw = mdto.getManagerPassw();				
				String sql = "exec Managers_Insert "
						+ "'"+ManagerId+"','"+ManagerName+"','"+ManagerSex+"','"+ManagerTel+"','"+ManagerAddr+"','"+ManagerPassw+"'";
				Connection conn = null;
				Statement stat = null;
				try {
					conn = CourseSelectionDataAccess.getConnection();
					stat = conn.createStatement();//����SQL������ִ��
					stat.executeUpdate(sql);
					flag = true;
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				CourseSelectionDataAccess.closeconn(conn, stat);
				return flag;
			}
			
			public boolean updateManagerInfo(ManagersDTO mdto){
				boolean flag = false;
				String ManagerId = mdto.getManagerId();
				String ManagerName = mdto.getManagerName();				
				String ManagerSex = mdto.getManagerSex();
				int ManagerTel = mdto.getManagerTel();
				String ManagerAddr = mdto.getManagerAddr();				
				String ManagerPassw = mdto.getManagerPassw();	
				String sql = "update Managers set ManagerName='"+ManagerName+"',ManagerSex='"+ManagerSex+"',ManagerTel='"+ManagerTel+"',ManagerAddr='"+ManagerAddr+"',ManagerPassw='"+ManagerPassw+"' where ManagerId='"+ManagerId+"'";							
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
									
			public boolean deleteManagerByManagerId(String ManagerId){
				boolean flag = false;
				Connection conn = null;
				Statement stat = null;
				try { 
					conn = CourseSelectionDataAccess.getConnection();
					stat = conn.createStatement();//����SQL������ִ��				
					String sql = "delete from Managers where ManagerId = '"+ManagerId+"'";					
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