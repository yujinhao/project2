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
public class FindStuScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String StudentId=(String)session.getAttribute("UserId");
		ScoreDAO sdao=new ScoreDAO();
		Vector<ScoreDTO> v = new Vector<ScoreDTO>();
		v=sdao.findAllGradeViewInfo(StudentId);
		HttpSession h = req.getSession();
	    h.setAttribute("score", v);
	    resp.sendRedirect("showStuScoreInfo.jsp");
	}
}
