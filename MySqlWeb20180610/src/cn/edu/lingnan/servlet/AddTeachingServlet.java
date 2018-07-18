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
		//1.�ӿͻ��˽���ҳ�洫����������
		String TeacherId=request.getParameter("TeacherId");
		String CourseId=request.getParameter("CourseId");	
		int StudentsNumber=Integer.parseInt(request.getParameter("StudentsNumber"));
		//2.�������ݣ����ú�̨��ҵ���߼�ȥ����DAO����ķ�����
		TeachingDAO teachingdao=new TeachingDAO();
		TeachingDTO teachingdto=new TeachingDTO();
		teachingdto.setTeacherId(TeacherId);
		teachingdto.setCourseId(CourseId);
		teachingdto.setStudentsNumber(StudentsNumber);
		
		boolean flag=teachingdao.addTeachingInfo(teachingdto);
		//3.������Ĵ��������ص���Ӧ��ҳ��
		if(flag){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"��ӳɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect(request.getContextPath()+"/admin/findAllTeachingServlet");
		}
			
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"���ʧ��\n���������룡","������Ϣ", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("addTeachingInfo.jsp");
		}
	
	}
}

