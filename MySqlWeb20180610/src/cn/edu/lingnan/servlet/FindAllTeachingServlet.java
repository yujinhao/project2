package cn.edu.lingnan.servlet;

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
public class FindAllTeachingServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeachingDAO teachingdao=new TeachingDAO();
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
		v =teachingdao.findAllTeachingviewInfo();
		HttpSession s=request.getSession();
		s.setAttribute("allteaching", v);
		//把页面切过去
		response.sendRedirect("showAllTeaching.jsp");					
	}
}
