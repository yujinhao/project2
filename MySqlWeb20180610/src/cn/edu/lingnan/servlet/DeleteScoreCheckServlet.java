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
public class DeleteScoreCheckServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] score=request.getParameterValues("arr");
		ScoreDAO scoredao=new ScoreDAO();
		//由于从页面拿过来的数据会自动添加“,”来分隔，所以要通过方法split分割它们
		for(String a:score){
			String[] b=a.split(",");
			int i=0;
			while(i<b.length){
				scoredao.deleteScoreByStudentIdandCourseId(b[i], b[i+1]);
				i=i+2;
			}
		}		
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
		v =scoredao.findAllScoreViewInfo();
		HttpSession s=request.getSession();
		s.setAttribute("allscore", v);
		//把页面切过去
		response.sendRedirect("showAllScore.jsp");
	}
}
