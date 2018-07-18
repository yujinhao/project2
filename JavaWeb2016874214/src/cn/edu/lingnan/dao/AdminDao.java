package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
	public String findAdminname(String adminname){  
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
            String sql = "select * from admin where aname=?";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, adminname);  
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
}
