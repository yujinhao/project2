package cn.edu.lingnan.servlet_teacher;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TeachingDAO;
import cn.edu.lingnan.dto.TeachingDTO;
@SuppressWarnings("serial")
public class LookCourse extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		String TeacherId = (String) s.getAttribute("UserId");
		TeachingDAO teachingdao=new TeachingDAO();
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
		v = teachingdao.findTeachingviewInfoByTeacherId(TeacherId);
		s.setAttribute("mycourse", v);
		//把页面切过去
		response.sendRedirect("showCourse.jsp");					
	}
}
