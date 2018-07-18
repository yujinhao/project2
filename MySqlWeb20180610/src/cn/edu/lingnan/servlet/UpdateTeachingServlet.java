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

import cn.edu.lingnan.dao.TeachingDAO;
import cn.edu.lingnan.dto.TeachingDTO;

@SuppressWarnings("serial")
public class UpdateTeachingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherId = req.getParameter("TeacherId");
		String CourseId=req.getParameter("CourseId");
		int StudentsNumber=Integer.parseInt(req.getParameter("StudentsNumber"));
		TeachingDTO teachingdto = new TeachingDTO();
		TeachingDAO teachingdao = new TeachingDAO();
		teachingdto.setTeacherId(TeacherId);
		teachingdto.setCourseId(CourseId);
		teachingdto.setStudentsNumber(StudentsNumber);
		
		Boolean flag=teachingdao.updateTeachingInfo(teachingdto);
		if(flag){
			Vector<TeachingDTO> v = new Vector<TeachingDTO>();
			v = teachingdao.findAllTeachingviewInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allteaching", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllTeaching.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改失败！",  "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllTeaching.jsp");
		}
	}
}
