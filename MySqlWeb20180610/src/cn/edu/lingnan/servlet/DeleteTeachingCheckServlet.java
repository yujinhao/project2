package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TeachingDAO;
import cn.edu.lingnan.dto.TeachingDTO;

@SuppressWarnings("serial")
public class DeleteTeachingCheckServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] teaching=request.getParameterValues("arr");
		TeachingDAO teachingdao=new TeachingDAO();
		//���ڴ�ҳ���ù��������ݻ��Զ���ӡ�,�����ָ�������Ҫͨ������split�ָ�����
		for(String a:teaching){
			String[] b=a.split(",");
			int i=0;
			while(i<b.length){
				teachingdao.deleteTeachingByTeacherIdandCourseId(b[i], b[i+1]);
				i=i+2;
			}
		}		
		Vector<TeachingDTO> v=new Vector<TeachingDTO>();
		v =teachingdao.findAllTeachingviewInfo();
		HttpSession s=request.getSession();
		s.setAttribute("allteaching", v);
		//��ҳ���й�ȥ
		response.sendRedirect("showAllTeaching.jsp");
	}
}
