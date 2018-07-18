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

import cn.edu.lingnan.dao.ClassDAO;
import cn.edu.lingnan.dto.ClassDTO;

@SuppressWarnings("serial")
public class DeleteClassServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassId = req.getParameter("ClassId");
		ClassDAO cdao = new ClassDAO();
		
		Boolean flag=cdao.deleteClassByClassId(ClassId);
		if(flag){	
			Vector<ClassDTO> v = new Vector<ClassDTO>();
			v = cdao.findClass();
			HttpSession s = req.getSession();
			s.setAttribute("allclass", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllClass.jsp");		
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除失败\n请先删除相关的学生信息！", "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllClass.jsp");	
		}
		
	}
}
