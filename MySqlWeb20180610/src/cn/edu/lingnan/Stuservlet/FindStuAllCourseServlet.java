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
public class FindStuAllCourseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CourseDAO coursedao=new CourseDAO();
		Vector<CourseDTO> v = new Vector<CourseDTO>();
		v=coursedao.findAllCourse();
		HttpSession hs= req.getSession();
		hs.setAttribute("course", v);
		
        
		HttpSession session=req.getSession();
		String StudentId=(String)session.getAttribute("UserId");
		ScoreDAO scoredao=new ScoreDAO();
		Vector<ScoreDTO> v1 = new Vector<ScoreDTO>();
		v1=scoredao.findAllScoreViewInfo(StudentId);
		hs.setAttribute("stucourse", v1);
		resp.sendRedirect("showAllCourseInfo.jsp");
	}
}

