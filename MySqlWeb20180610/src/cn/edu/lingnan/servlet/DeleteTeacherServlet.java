package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.TeachersDAO;
import cn.edu.lingnan.dto.TeachersDTO;

@SuppressWarnings("serial")
public class DeleteTeacherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherId = req.getParameter("TeacherId");
		TeachersDAO tdao = new TeachersDAO();
		
		Boolean flag=tdao.deleteTeacherByTeacherId(TeacherId);		
		if(flag){
			Vector<TeachersDTO> v = new Vector<TeachersDTO>();
			v = tdao.findAllTeachers();
			HttpSession s = req.getSession();
			s.setAttribute("allteacher", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"ɾ���ɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllTeacher.jsp");	
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"ɾ��ʧ�ܣ�","������Ϣ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllTeacher.jsp");	
		}
	}
}

