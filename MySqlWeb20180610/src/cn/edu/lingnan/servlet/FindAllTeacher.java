package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TeachersDAO;
import cn.edu.lingnan.dto.TeachersDTO;

@SuppressWarnings("serial")
public class FindAllTeacher extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		TeachersDAO tdao = new TeachersDAO();
		Vector<TeachersDTO> v = new Vector<TeachersDTO>();
		v = tdao.findAllTeachers();
		HttpSession s = req.getSession();
		s.setAttribute("allteacher", v);
		resp.sendRedirect("showAllTeacher.jsp");
	}
}
