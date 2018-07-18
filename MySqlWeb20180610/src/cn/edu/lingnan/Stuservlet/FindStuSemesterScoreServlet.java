package cn.edu.lingnan.Stuservlet;

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
public class FindStuSemesterScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String StudentId=(String)session.getAttribute("UserId");
		String School = req.getParameter("School");
		int Semester =  Integer.parseInt(req.getParameter("Semester"));
		ScoreDAO sdao=new ScoreDAO();
		Vector<ScoreDTO> v = new Vector<ScoreDTO>();
		v=sdao.findAllGradeViewInfo(StudentId,School,Semester);
		HttpSession h = req.getSession();
	    h.setAttribute("semesterscore", v);
	    
	    //传学期总学分过去
	    String AllCourseCredit=sdao.countCourseCredit(StudentId, School, Semester);
	    h.setAttribute("allcoursecredit", AllCourseCredit);
	    
	    resp.sendRedirect("showStuSemesterScore.jsp");
	}
}
