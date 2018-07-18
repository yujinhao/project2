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

import cn.edu.lingnan.dao.MajorDAO;
import cn.edu.lingnan.dto.MajorDTO;

@SuppressWarnings("serial")
public class DeleteMajorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String MajorId = req.getParameter("MajorId");
		MajorDAO mdao = new MajorDAO();
		
		Boolean flag=mdao.deleteMajorByMajorId(MajorId);		
		if(flag){
			Vector<MajorDTO> v = new Vector<MajorDTO>();
			v = mdao.findAllMajorInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allmajor", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"ɾ���ɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllMajor.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"ɾ��ʧ��\n����ɾ����صİ༶��Ϣ��", "������Ϣ", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllMajor.jsp");
		}
	}
}
