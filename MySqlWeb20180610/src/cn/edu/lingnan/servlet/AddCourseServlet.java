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
public class AddCourseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String courseId=new String(req.getParameter("CourseId").getBytes("ISO-8859-1"),"GB2312");
		String courseName=new String(req.getParameter("CourseName").getBytes("ISO-8859-1"),"GB2312");
		int courseCredit=Integer.parseInt(req.getParameter("CourseCredit"));
		int courseClass=Integer.parseInt(req.getParameter("CourseClass"));
		String courseDesc=new String(req.getParameter("CourseDesc").getBytes("ISO-8859-1"),"GB2312");
		String classTime=new String(req.getParameter("ClassTime").getBytes("ISO-8859-1"),"GB2312");
		String address=new String(req.getParameter("Address").getBytes("ISO-8859-1"),"GB2312");
		int volume=Integer.parseInt(req.getParameter("Volume"));
		int remain=Integer.parseInt(req.getParameter("Remain"));
		System.out.println("员工的注册信息:"+courseId+"	"+courseName+"   "+courseCredit+"	"
				+courseClass+" "+courseDesc+"	"+classTime+"	"+address);
		
		CourseDAO coursedao=new CourseDAO();
		CourseDTO coursedto=new CourseDTO();
		
		coursedto.setCourseId(courseId);
		coursedto.setCourseName(courseName);
		coursedto.setCourseCredit(courseCredit);
		coursedto.setCourseClass(courseClass);
		coursedto.setCourseDesc(courseDesc);
		coursedto.setClassTime(classTime);
		coursedto.setAddress(address);
		coursedto.setVolume(volume);
		coursedto.setRemain(remain);
		boolean flag=coursedao.addCourseInfo(coursedto);
		if(flag)
		{
			Vector<CourseDTO> v = new Vector<CourseDTO>();
			v=coursedao.findAllCourse();
			HttpSession s = req.getSession();
			s.setAttribute("allcourse", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加成功！", "提示信息", JOptionPane.WARNING_MESSAGE); 
			resp.sendRedirect(req.getContextPath()+"/admin/showAllCourse.jsp");	
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"该课程编号已存在!\n请重新输入！", "错误信息", JOptionPane.ERROR_MESSAGE);  
			resp.sendRedirect(req.getContextPath()+"/admin/addCourseInfo.jsp");	
		}
		
	}
}
