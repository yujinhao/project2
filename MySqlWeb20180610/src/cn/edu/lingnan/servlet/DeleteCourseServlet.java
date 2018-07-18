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

import cn.edu.lingnan.dao.CourseDAO;
import cn.edu.lingnan.dto.CourseDTO;


@SuppressWarnings("serial")
public class DeleteCourseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String CourseId=req.getParameter("CourseId");
		System.out.println("É¾³ýµÄ¿Î³Ì±àºÅ£º    "+CourseId);
		CourseDAO coursedao= new CourseDAO();
		
		boolean flag=coursedao.deleteCourseByCourseId(CourseId);
		if(flag)
		{
			Vector<CourseDTO> v=new Vector<CourseDTO>();
			v=coursedao.findAllCourse();
			HttpSession hs=req.getSession();
			hs.setAttribute("allcourse", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"É¾³ý³É¹¦£¡", "ÌáÊ¾ÐÅÏ¢", JOptionPane.WARNING_MESSAGE); 
			resp.sendRedirect("showAllCourse.jsp");
		}
			
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"É¾³ýÊ§°Ü£¡","´íÎóÐÅÏ¢", JOptionPane.ERROR_MESSAGE); 
			resp.sendRedirect("showAllCourse.jsp");
		}
			
		
	}
}


