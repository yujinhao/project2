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
public class UpdateCourseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String courseId=req.getParameter("CourseId");
		String courseName=new String(req.getParameter("CourseName").getBytes("ISO-8859-1"),"GB2312");
		String courseCredit=req.getParameter("CourseCredit");
		String courseClass=req.getParameter("CourseClass");
		String courseDesc=new String(req.getParameter("CourseDesc").getBytes("ISO-8859-1"),"GB2312");
		String classTime=new String(req.getParameter("ClassTime").getBytes("ISO-8859-1"),"GB2312");
		String address=new String(req.getParameter("Address").getBytes("ISO-8859-1"),"GB2312");
		String volume=req.getParameter("Volume");
		String remain=req.getParameter("Remain");
		
		CourseDAO coursedao=new CourseDAO();
		CourseDTO coursedto=new CourseDTO();
		
		coursedto.setCourseId(courseId);
		coursedto.setCourseName(courseName);
		coursedto.setCourseCredit(Integer.parseInt(courseCredit));
		coursedto.setCourseClass(Integer.parseInt(courseClass));
		coursedto.setCourseDesc(courseDesc);
		coursedto.setClassTime(classTime);
		coursedto.setAddress(address);
		coursedto.setVolume(Integer.parseInt(volume));
		coursedto.setRemain(Integer.parseInt(remain));
		
		boolean flag=coursedao.updateCourseInfo(coursedto);
		if(flag){
			 Vector<CourseDTO> v=new Vector<CourseDTO>();
		     v=coursedao.findAllCourse();
		     HttpSession hs=req.getSession();
		     hs.setAttribute("allcourse", v);
		     JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改成功！", "提示信息", JOptionPane.WARNING_MESSAGE); 
		     resp.sendRedirect("showAllCourse.jsp");	  
    }
    else{
		  	  JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
							"修改失败！", "错误信息", JOptionPane.ERROR_MESSAGE);  
				resp.sendRedirect(req.getContextPath()+"/admin/updateCourse.jsp");
    }
		
	}

}
