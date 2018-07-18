package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.StudentsDAO;
import cn.edu.lingnan.dto.StudentsDTO;

@SuppressWarnings("serial")
public class DeleteStudentCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		StudentsDAO sdao = new StudentsDAO();
		for(String a:arr){
			String[] b = a.split(",");
			for(String c:b)
				sdao.deleteStudentByStudentId(c);
		}
		Vector<StudentsDTO> v = new Vector<StudentsDTO>();
		v = sdao.findAllStudents();
		HttpSession s = req.getSession();
		s.setAttribute("allstudent", v);
		resp.sendRedirect("showAllStudent.jsp");			
	}
}
