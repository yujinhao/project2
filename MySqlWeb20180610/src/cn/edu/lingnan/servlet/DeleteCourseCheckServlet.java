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
			String[] b = a.split(",");//��a���зָ�
			for(String c:b){
				//System.out.println("ɾ���˵�Id�ţ� " +a);
				coursedao.deleteCourseByCourseId(c);
			}
		}
		Vector<CourseDTO> v=new Vector<CourseDTO>();//�ɱ�����
		v=coursedao.findAllCourse();
		HttpSession hs=req.getSession();//session��ÿһ���û�����
		hs.setAttribute("allcourse", v);//vΪһ��object
		resp.sendRedirect("showAllCourse.jsp");//ҳ���л�	
			
	}

}
