package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.UsersDAO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 1、从页面获取我们想要的数据
		String UserId = null;
		String UserPassw = null;
		UserId = req.getParameter("UserId");
		UserPassw =  req.getParameter("UserPassw");
		System.out.println("ID:"+UserId+"   密码:"+UserPassw);
		
		
		// 2、调用后台的业务逻辑去判断这个用户名和密码是否存在且对应
		UsersDAO udao = new UsersDAO();
		int UserRoot = udao.findUserByIdAndPassword(UserId, UserPassw);
		String UserName = udao.findUserNameByIdAndPassword(UserId, UserPassw);
		HttpSession s = req.getSession();
		s.setAttribute("UserRoot", UserRoot);
		s.setAttribute("UserId", UserId);
		s.setAttribute("UserName", UserName);
		
		
		// 3、根据结果去到相应的页面
		if(UserRoot==3){
			resp.sendRedirect(req.getContextPath()+"/admin/admin.html");
		}
		else if(UserRoot==2){
		    resp.sendRedirect(req.getContextPath()+"/teacher/teacher.html");
		}
		else if(UserRoot==1){
		    resp.sendRedirect(req.getContextPath()+"/student/student.html");			
		}
		else
//		    resp.sendRedirect(req.getContextPath()+"/error.html");
		{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"密码错误\n或账号不存在！", "提示信息", JOptionPane.WARNING_MESSAGE);
			 resp.sendRedirect(req.getContextPath()+"/index.html");
		}
	}
}
