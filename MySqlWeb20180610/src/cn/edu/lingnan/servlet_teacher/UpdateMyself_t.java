package cn.edu.lingnan.servlet_teacher;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.TeachersDAO;
import cn.edu.lingnan.dto.TeachersDTO;
@SuppressWarnings("serial")
public class UpdateMyself_t extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String TeacherId = req.getParameter("TeacherId");
		String DeptId = req.getParameter("DeptId");
		String TeacherName = new String(req.getParameter("TeacherName").getBytes("ISO-8859-1"),"GB2312");
		String TeacherSex = new String(req.getParameter("TeacherSex").getBytes("ISO-8859-1"),"GB2312");
		String TeacherTitle = new String(req.getParameter("TeacherTitle").getBytes("ISO-8859-1"),"GB2312");
		String TeacherPassw = req.getParameter("TeacherPassw");
//		System.out.println("StudentId"+StudentId+" ClassId"+ClassId+" StudentName"+StudentName+
//				" StudentSex"+StudentSex+" StudentAge"+StudentAge+" EntranceTime"+EntranceTime+" StudentPassw"+StudentPassw);
		TeachersDTO tdto = new TeachersDTO();
		TeachersDAO tdao = new TeachersDAO();
		tdto.setTeacherId(TeacherId);
		tdto.setDeptId(DeptId);
		tdto.setTeacherName(TeacherName);
		tdto.setTeacherSex(TeacherSex);
		tdto.setTeacherTitle(TeacherTitle);
		tdto.setTeacherPassw(TeacherPassw);
		
		Boolean flag=tdao.updateTeacherInfo(tdto);
		if(flag){
			Vector<TeachersDTO> v = new Vector<TeachersDTO>();
			v = tdao.findAllTeachers();
			HttpSession s = req.getSession();
			s.setAttribute("oneteacher", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showTeacher.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改失败！",  "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showTeacher.jsp");
		}
	}
}
