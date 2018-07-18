package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.ScoreDTO;

@SuppressWarnings("serial")
public class DeleteScoreServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String StudentId=req.getParameter("StudentId");
		String CourseId=req.getParameter("CourseId");
		ScoreDAO scoredao = new ScoreDAO();
		
		Boolean flag=scoredao.deleteScoreByStudentIdandCourseId(StudentId, CourseId);	
		if(flag){
			Vector<ScoreDTO> v = new Vector<ScoreDTO>();
			v =scoredao.findAllScoreViewInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allscore", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllScore.jsp");	
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除失败！", "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllScore.jsp");	
		}
	}
}