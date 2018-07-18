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

import cn.edu.lingnan.dao.StudentsDAO;
import cn.edu.lingnan.dto.StudentsDTO;

@SuppressWarnings("serial")
public class DeleteStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String StudentId = req.getParameter("StudentId");
		StudentsDAO sdao = new StudentsDAO();
		
		Boolean flag=sdao.deleteStudentByStudentId(StudentId);
		if(flag){
			Vector<StudentsDTO> v = new Vector<StudentsDTO>();
			v = sdao.findAllStudents();
			HttpSession s = req.getSession();
			s.setAttribute("allstudent", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllStudent.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除失败！", "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllStudent.jsp");
		}
	}
}
