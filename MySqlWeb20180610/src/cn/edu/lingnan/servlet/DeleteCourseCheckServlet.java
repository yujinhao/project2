package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CourseDAO;
import cn.edu.lingnan.dto.CourseDTO;


@SuppressWarnings("serial")
public class DeleteCourseCheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr=req.getParameterValues("arr");
		CourseDAO coursedao=new CourseDAO();
		for(String a:arr){
			String[] b = a.split(",");//对a进行分割
			for(String c:b){
				//System.out.println("删除了的Id号： " +a);
				coursedao.deleteCourseByCourseId(c);
			}
		}
		Vector<CourseDTO> v=new Vector<CourseDTO>();//可变数组
		v=coursedao.findAllCourse();
		HttpSession hs=req.getSession();//session对每一个用户而言
		hs.setAttribute("allcourse", v);//v为一个object
		resp.sendRedirect("showAllCourse.jsp");//页面切换	
			
	}

}
