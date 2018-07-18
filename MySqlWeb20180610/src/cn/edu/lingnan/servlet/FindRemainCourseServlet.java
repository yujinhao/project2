package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CourseDAO;
import cn.edu.lingnan.dto.CourseDTO;

@SuppressWarnings("serial")
public class FindRemainCourseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CourseDAO coursedao=new CourseDAO();
		Vector<CourseDTO> v = new Vector<CourseDTO>();
		v=coursedao.findAllRemainCourse();
		HttpSession hs= req.getSession();
		hs.setAttribute("allcourse", v);
		resp.sendRedirect("showAllCourse.jsp");
	}

}
