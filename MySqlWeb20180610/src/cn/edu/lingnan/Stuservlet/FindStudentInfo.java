package cn.edu.lingnan.Stuservlet;

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
public class FindStudentInfo extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String StudentId=(String)session.getAttribute("UserId");
		StudentsDAO sdao=new StudentsDAO();
		Vector<StudentsDTO> v = new Vector<StudentsDTO>();
		v=sdao.findStudentByStudentid(StudentId);
		HttpSession h = req.getSession();
	    h.setAttribute("person", v);
	    resp.sendRedirect("showStudentInfo.jsp");
	}

}
