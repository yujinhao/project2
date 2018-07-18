package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.UsersDAO;
import cn.edu.lingnan.dto.UsersDTO;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1、从页面获取我们想要的数据
		String UserId = null;
		String UserName = null;
		String UserPassw = null;
		int UserRoot = 0;
		UserId = req.getParameter("UserId");
		UserName = new String(req.getParameter("UserName").getBytes("ISO-8859-1"),"GB2312");
		UserPassw =  req.getParameter("UserPassw");
		UserRoot = Integer.parseInt(req.getParameter("UserRoot"));
		System.out.println("1:"+UserId+"  "+UserName+"  "+UserPassw+"  "+UserRoot);
		// 2、调用后台的业务逻辑去判断这个用户名和密码是否存在且对应
		UsersDAO udao = new UsersDAO();
		UsersDTO udto = new UsersDTO();
		udto.setUserId(UserId);
		udto.setUserName(UserName);
		udto.setUserPassw(UserPassw);
		udto.setUserRoot(UserRoot);
		boolean flag = udao.addUserInfo(udto);
		// 3、根据结果去到相应的页面
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/index.html");
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"注册失败！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/register.jsp");
		}
		//	resp.sendRedirect(req.getContextPath()+"/error.html");
	}
}
