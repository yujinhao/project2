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
		// 1����ҳ���ȡ������Ҫ������
		String UserId = null;
		String UserName = null;
		String UserPassw = null;
		int UserRoot = 0;
		UserId = req.getParameter("UserId");
		UserName = new String(req.getParameter("UserName").getBytes("ISO-8859-1"),"GB2312");
		UserPassw =  req.getParameter("UserPassw");
		UserRoot = Integer.parseInt(req.getParameter("UserRoot"));
		System.out.println("1:"+UserId+"  "+UserName+"  "+UserPassw+"  "+UserRoot);
		// 2�����ú�̨��ҵ���߼�ȥ�ж�����û����������Ƿ�����Ҷ�Ӧ
		UsersDAO udao = new UsersDAO();
		UsersDTO udto = new UsersDTO();
		udto.setUserId(UserId);
		udto.setUserName(UserName);
		udto.setUserPassw(UserPassw);
		udto.setUserRoot(UserRoot);
		boolean flag = udao.addUserInfo(udto);
		// 3�����ݽ��ȥ����Ӧ��ҳ��
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/index.html");
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"ע��ʧ�ܣ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/register.jsp");
		}
		//	resp.sendRedirect(req.getContextPath()+"/error.html");
	}
}
