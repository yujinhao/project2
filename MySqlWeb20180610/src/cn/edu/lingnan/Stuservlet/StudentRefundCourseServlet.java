package cn.edu.lingnan.Stuservlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CourseDAO;
import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.CourseDTO;
import cn.edu.lingnan.dto.ScoreDTO;


@SuppressWarnings("serial")
public class StudentRefundCourseServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ScoreDAO scoredao=new ScoreDAO();
		HttpSession session=request.getSession();
		String StudentId=(String)session.getAttribute("UserId");
		String CourseId=request.getParameter("CourseId");
		scoredao.deleteScoreByStudentIdandCourseId(StudentId, CourseId);
		
		CourseDAO coursedao=new CourseDAO();
		Vector<CourseDTO> v = new Vector<CourseDTO>();
		v=coursedao.findAllCourse();
		HttpSession hs= request.getSession();
		hs.setAttribute("course", v);
		
		Vector<ScoreDTO> v1 = new Vector<ScoreDTO>();
		v1=scoredao.findAllScoreViewInfo(StudentId);
		hs.setAttribute("stucourse", v1);
		response.sendRedirect("showAllCourseInfo.jsp");
	}
}