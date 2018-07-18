package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.TeachingDAO;
import cn.edu.lingnan.dto.TeachingDTO;

@SuppressWarnings("serial")
public class AddTeachingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.从客户端接收页面传过来的数据
		String TeacherId=request.getParameter("TeacherId");
		String CourseId=request.getParameter("CourseId");	
		int StudentsNumber=Integer.parseInt(request.getParameter("StudentsNumber"));
		//2.处理数据：调用后台的业务逻辑去处理（DAO里面的方法）
		TeachingDAO teachingdao=new TeachingDAO();
		TeachingDTO teachingdto=new TeachingDTO();
		teachingdto.setTeacherId(TeacherId);
		teachingdto.setCourseId(CourseId);
		teachingdto.setStudentsNumber(StudentsNumber);
		
		boolean flag=teachingdao.addTeachingInfo(teachingdto);
		//3.根据你的处理结果返回到相应的页面
		if(flag){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect(request.getContextPath()+"/admin/findAllTeachingServlet");
		}
			
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加失败\n请重新输入！","错误信息", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("addTeachingInfo.jsp");
		}
	
	}
}

