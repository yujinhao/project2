package cn.edu.lingnan.servlet_teacher;

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
public class LookTeacher extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		String TeacherId = (String) s.getAttribute("UserId");
		
		TeachersDAO tdao = new TeachersDAO();
		Vector<TeachersDTO> v = new Vector<TeachersDTO>();
		v = tdao.findTeacherByTeacherId(TeacherId);
		s.setAttribute("oneteacher", v);
		resp.sendRedirect("showTeacher.jsp");
	}
}
