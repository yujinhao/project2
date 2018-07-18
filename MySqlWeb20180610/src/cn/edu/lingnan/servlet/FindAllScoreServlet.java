package cn.edu.lingnan.servlet;

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
public class FindAllScoreServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ScoreDAO scoredao=new ScoreDAO();
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
		v =scoredao.findAllScoreViewInfo();
		HttpSession s=request.getSession();
		s.setAttribute("allscore", v);
		//把页面切过去
		response.sendRedirect("showAllScore.jsp");					
	}
}
