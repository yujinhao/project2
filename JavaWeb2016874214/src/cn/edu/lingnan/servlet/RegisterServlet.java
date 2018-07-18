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
        //�õ������������  
     
        if(uid==null||uid.trim().isEmpty()){  
            request.setAttribute("msg3", "�ʺŲ���Ϊ��");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        if(uname==null||uname.trim().isEmpty()){  
            request.setAttribute("msg3", "�û�������Ϊ��");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        if(psw==null||psw.trim().isEmpty()){  
            request.setAttribute("msg3", "���벻��Ϊ��");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        UserDao u = new UserDao();  
        u.addUser(uid,uname,psw);//����addUser��������  
        request.setAttribute("msg3", "��ϲ��"+uname+"��ע��ɹ�");  
        request.getRequestDispatcher("/Login.jsp").forward(request, response); 
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	doGet(request,response);
	}
}  