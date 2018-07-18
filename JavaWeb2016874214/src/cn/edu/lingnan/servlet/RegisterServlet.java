package cn.edu.lingnan.servlet;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  

import cn.edu.lingnan.dao.UserDao;  
  
public class RegisterServlet extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        request.setCharacterEncoding("gb2312");  
        response.setContentType("text/html;charset=gb2312");  
        String uid = request.getParameter("uid");     
        String uname = request.getParameter("uname");
//        uname = new String(uname.getBytes("iso8859-1"),"gb2312");
        String psw = request.getParameter("psw"); 
        System.out.println(uid+uname+psw);
        //得到表单输入的内容  
     
        if(uid==null||uid.trim().isEmpty()){  
            request.setAttribute("msg3", "帐号不能为空");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        if(uname==null||uname.trim().isEmpty()){  
            request.setAttribute("msg3", "用户名不能为空");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        if(psw==null||psw.trim().isEmpty()){  
            request.setAttribute("msg3", "密码不能为空");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        UserDao u = new UserDao();  
        u.addUser(uid,uname,psw);//调用addUser（）方法  
        request.setAttribute("msg3", "恭喜："+uname+"，注册成功");  
        request.getRequestDispatcher("/Login.jsp").forward(request, response); 
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	doGet(request,response);
	}
}  