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
public class UpdateStudentGradeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String StudentId=req.getParameter("StudentId");
		String CourseId=req.getParameter("CourseId");
		int Grade=Integer.parseInt(req.getParameter("Grade"));
		float GradePoint=Float.parseFloat(req.getParameter("GradePoint"));
		ScoreDAO scoredao=new ScoreDAO();
		ScoreDTO scoredto=new ScoreDTO();
		scoredto.setStudentId(StudentId);
		scoredto.setCourseId(CourseId);
		scoredto.setGrade(Grade);
		scoredto.setGradePoint(GradePoint);
		
		Boolean flag=scoredao.updateGrade(scoredto);
		
		if(flag){
			Vector<ScoreDTO> v=new Vector<ScoreDTO>();
			v =scoredao.findAllGradeViewInfo();
			HttpSession s=req.getSession();
			s.setAttribute("allstugrade", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			//把页面切过去
			resp.sendRedirect("showAllStudentGrade.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改失败！",  "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllStudentGrade.jsp");
		}
	}
}