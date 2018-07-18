package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.BookDTO;
import cn.edu.lingnan.util.CourseSelectionDataAccess;

public class BookDAO {
	boolean flag=false;
	Connection conn=null;
	PreparedStatement pre=null;
	ResultSet rs=null;
	Statement stat=null;
	
	//��ѯ���вο�����Ϣ
	public Vector<BookDTO> findAllBookInfo(){
		Vector<BookDTO> v=new Vector<BookDTO>();
		try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="select * from book";
	    	 rs=stat.executeQuery(sql);
	    	 while(rs.next()){
	    		 BookDTO bookdto=new BookDTO();
	    		 bookdto.setBookId(rs.getString("BookId"));
	    		 bookdto.setBookName(rs.getString("BookName"));
	    		 bookdto.setBookPrice(rs.getFloat("BookPrice"));
	    		 bookdto.setBookContent(rs.getString("BookContent"));
	    		 bookdto.setBookWriter(rs.getString("BookWriter"));
	    		 bookdto.setBookPublish(rs.getString("BookPublish"));
	    		 v.add(bookdto);
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

	//���ݲο����Id�Ų�ѯĳ���ο�����Ϣ
	public Vector<BookDTO> findBookByBookId(String BookId){
		Vector<BookDTO> v=new Vector<BookDTO>();
		try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="select * from book where BookId='"+BookId+"'";
	    	 rs=stat.executeQuery(sql);
	    	 while(rs.next()){
	    		 BookDTO bookdto=new BookDTO();
	    		 bookdto.setBookId(rs.getString("BookId"));
	    		 bookdto.setBookName(rs.getString("BookName"));
	    		 bookdto.setBookPrice(rs.getFloat("BookPrice"));
	    		 bookdto.setBookContent(rs.getString("BookContent"));
	    		 bookdto.setBookWriter(rs.getString("BookWriter"));
	    		 bookdto.setBookPublish(rs.getString("BookPublish"));
	    		 v.add(bookdto);
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
	
	//��Ӳο�����Ϣ
	public boolean addBookInfo(BookDTO bookdto){
		try {
	    	   conn=CourseSelectionDataAccess.getConnection();
	    	   pre=conn.prepareStatement("insert into book values(?,?,?,?,?,?)");
			   pre.setString(1,bookdto.getBookId());
			   pre.setString(2,bookdto.getBookName());
			   pre.setFloat(3, bookdto.getBookPrice());
			   pre.setString(4, bookdto.getBookContent());
			   pre.setString(5,bookdto.getBookWriter());
			   pre.setString(6, bookdto.getBookPublish());
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

	//���²ο�����Ϣ
	public boolean updateBookInfo(BookDTO bookdto){
		boolean flag=false;
		String BookId=bookdto.getBookId();
		String BookName=bookdto.getBookName();
		float BookPrice=bookdto.getBookPrice();
		String BookContent=bookdto.getBookContent();
		String BookWriter = bookdto.getBookWriter();
		String BookPublish=bookdto.getBookPublish();
		 try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="update book set BookName='"+BookName+"',BookPrice='"+BookPrice+"',BookContent='"+BookContent+"',"
	 				+ "BookWriter='"+BookWriter+"',BookPublish='"+BookPublish+"' where BookId='"+BookId+"'";
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
	
	//���ݲο����Id��ɾ��ĳ���ο�����Ϣ
	public boolean deleteBookByBookId(String BookId){
	
		try {	 
	    	 conn=CourseSelectionDataAccess.getConnection();
	    	 stat=conn.createStatement();
	    	 String sql="delete from book where BookId='"+BookId+"'";
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