package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.lingnan.dto.Room;
import cn.edu.lingnan.util.DataAccess;




public class RoomDao {
  /**
   * 操作数据库命令链接
   * 数据访问类
   */
	private Connection conn;
	private Statement state;
	private ResultSet rs;
	private PreparedStatement pre;
	/**
	 * 查询全部
	 * @return
	 * @throws SQLException
	 */
	public  List<Room> fill() throws SQLException {
		List<Room> list = new ArrayList<Room>();
		String sql = "select * from room";
		conn = DataAccess.getConnection();
		state = conn.createStatement();
		rs = state.executeQuery(sql);
		while (rs.next()) {
			Room rm = new Room();				
			rm.setRid(rs.getString("rid"));
			rm.setRtype(rs.getString("rtype"));
			rm.setBreakfirst(rs.getString("breakfirst"));
			rm.setPrice(rs.getString("price"));
			
			list.add(rm);
		}
		rs.close();
		state.close();
		conn.close();
		return list;
	}
	/**
	 * 根据Id查询
	 * @param Id
	 * @return
	 * @throws SQLException
	 */
public Room fill(String rid) throws SQLException{
		
		conn = DataAccess.getConnection();
		String sql="select * from room where rid=?";
		pre = conn.prepareStatement(sql);
		pre.setString(1, rid);
		rs=pre.executeQuery();
		Room rm = null;
		if(rs.next()){
			rm = new Room();				
			rm.setRid(rs.getString("rid"));
			rm.setRtype(rs.getString("rtype"));
			rm.setBreakfirst(rs.getString("breakfirst"));
			rm.setPrice(rs.getString("price"));
		}
		rs.close();
		pre.close();
		conn.close();
		return rm;
	}
/**
 * 添加
 * @param room
 * @return
 * @throws SQLException
 */
	public int add(Room room) throws SQLException {

		String sql = "insert into room values ('" + room.getRid() + "','"
				+ room.getRtype() + "','" + room.getBreakfirst() + "','"
				+ room.getPrice() +"')";
		System.out.println(sql);
		conn = DataAccess.getConnection();
		state = conn.createStatement();		
		int result = state.executeUpdate(sql);
		state.close();
		conn.close();
		return result;

	}
	/**
	 * 修改
	 * @param room
	 * @return
	 * @throws SQLException
	 */
	public int  update(Room  room) throws SQLException {
		String sql="UPDATE room SET Rtype=?,Breakfirst =?,Price=? WHERE Rid=?";
		conn=DataAccess.getConnection();
		pre = conn.prepareStatement(sql);
		pre.setString(1,  room.getRtype());
		pre.setString(2,  room.getBreakfirst());
		pre.setString(3,  room.getPrice());
		pre.setString(4,  room.getRid());
		int count=pre.executeUpdate();
		pre.close();
		conn.close();
		return count;		
		// TODO Auto-generated method stub
		
	}
/**
 * 根据ID删除一项
 * @param Id
 * @throws SQLException
 */
	public void  delete(String rid) throws SQLException {
		String sql="delete from room where  rid=?";
		conn=DataAccess.getConnection();
		pre = conn.prepareStatement(sql);
		pre.setString(1,rid);
		pre.executeUpdate();
		pre.close();
		conn.close();				
		// TODO Auto-generated method stub	
		
	}
	
	
	/**
	 * 多项选择Id删除
	 * @param Id
	 * @throws SQLException
	 */
	public void  delete(String[] rid) throws SQLException {
		conn = DataAccess.getConnection();
		String ids="'"+rid[0]+"'";
		for(int i=1;i<rid.length;i++) {
			ids=ids+",'"+rid[i]+"'";
		}
		String sql="delete from  room where  rid  in ("+ids+")";
		pre = conn.prepareStatement(sql);		
		pre.executeUpdate();
		pre.close();
		conn.close();				
		// TODO Auto-generated method stub		
	}
}