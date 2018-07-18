package cn.edu.lingnan.servlet_teacher;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.ScoreDTO;

@SuppressWarnings("serial")
public class LookGrade extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String CourseId = request.getParameter("CourseId");
		System.out.print("----1---"+CourseId);
		ScoreDAO scoredao=new ScoreDAO();
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
		v = scoredao.findRegisterGradeviewByCourseId(CourseId);
		HttpSession s = request.getSession();
		s.setAttribute("grade", v);
		//把页面切过去
		response.sendRedirect("showGrade.jsp");					
	}
}
