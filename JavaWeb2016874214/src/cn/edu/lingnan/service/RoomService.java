
package cn.edu.lingnan.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.lingnan.dao.RoomDao;
import cn.edu.lingnan.dto.Room;;


public class RoomService{
	
	public int add(Room room) throws SQLException {
		RoomDao dao=new RoomDao();
		return dao.add(room);			
	}
	/**
	 * ²éÑ¯
	 * @return
	 * @throws SQLException
	 */
	public  List<Room>  fill() throws SQLException{
		RoomDao dao=new RoomDao();	
		return dao.fill();
	}
	public  Room  fill(String  rid) throws SQLException{
		RoomDao dao=new RoomDao();	
		return dao.fill(rid);
	}
	/**
	 * ÐÞ¸Ä
	 * @param room
	 * @return
	 * @throws SQLException
	 */
	public int update(Room room) throws SQLException{
		RoomDao dao=new RoomDao();
		return dao.update(room);		
	}
	/**
	 *  É¾³ý
	 * @param Rid
	 * @throws SQLException
	 */
	public void delete(String rid) throws SQLException{
		RoomDao dao=new RoomDao();
		 dao.delete(rid);	
	}
	
	public void delete(String[] rid) throws SQLException {
		RoomDao dao=new RoomDao();
		dao.delete(rid);
	}
}