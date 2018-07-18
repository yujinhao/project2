package cn.edu.lingnan.dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;

import cn.edu.lingnan.dto.Room;
import cn.edu.lingnan.dto.User;
import cn.edu.lingnan.util.DataAccess;
  
public class UserDao {  
    public String findUsername(String username){  
        String psw = null;  
        Connection con =null;  
        PreparedStatement pstmt =null;  
        ResultSet rs = null;  
        try {  
            String driver ="com.mysql.jdbc.Driver";  
            String url ="jdbc:mysql://localhost:3306/movie";  
            String user ="root";  
            String password ="123456";
            Class.forName(driver);  
            con = DriverManager.getConnection(url, user, password);  
            String sql = "select * from user where uname=?";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, username);  
            rs = pstmt.executeQuery();  
            while(rs.next()){
            	psw = rs.getString("password");
            }
            //System.out.println(psw);
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally {  
            try {  
                if(pstmt!=null)pstmt.close();  
                if(con!=null)con.close();  
                }   
            catch (SQLException e) {          
                                    }  
        }  
        
		return psw;
    }  
    public void addUser(String uid,String uname,String psw){  
        Connection con =null;  
        PreparedStatement pstmt =null;  
        try {  
            String driver ="com.mysql.jdbc.Driver";  
            String url ="jdbc:mysql://localhost:3306/movie";  
            String user ="root";  
            String password ="123456";
       
            Class.forName(driver);  
            con = DriverManager.getConnection(url, user, password);  
            String sql = "INSERT INTO user VALUES(?,?,?)";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, uid);  
            pstmt.setString(2, uname);
            pstmt.setString(3, psw);  
            pstmt.executeUpdate();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally {  
            try {  
                if(pstmt!=null)pstmt.close();  
                if(con!=null)con.close();  
                }   
            catch (SQLException e) {          
                                    }  
        }  
    
    }
}
 