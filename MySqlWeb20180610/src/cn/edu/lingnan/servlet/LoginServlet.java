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
		
		// 1����ҳ���ȡ������Ҫ������
		String UserId = null;
		String UserPassw = null;
		UserId = req.getParameter("UserId");
		UserPassw =  req.getParameter("UserPassw");
		System.out.println("ID:"+UserId+"   ����:"+UserPassw);
		
		
		// 2�����ú�̨��ҵ���߼�ȥ�ж�����û����������Ƿ�����Ҷ�Ӧ
		UsersDAO udao = new UsersDAO();
		int UserRoot = udao.findUserByIdAndPassword(UserId, UserPassw);
		String UserName = udao.findUserNameByIdAndPassword(UserId, UserPassw);
		HttpSession s = req.getSession();
		s.setAttribute("UserRoot", UserRoot);
		s.setAttribute("UserId", UserId);
		s.setAttribute("UserName", UserName);
		
		
		// 3�����ݽ��ȥ����Ӧ��ҳ��
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
					"�������\n���˺Ų����ڣ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			 resp.sendRedirect(req.getContextPath()+"/index.html");
		}
	}
}
