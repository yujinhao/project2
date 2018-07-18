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

import cn.edu.lingnan.dao.TeachersDAO;
import cn.edu.lingnan.dto.TeachersDTO;

@SuppressWarnings("serial")
public class AddTeacherServlet extends HttpServlet {
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
		
		Boolean flag=tdao.addTeacherInfo(tdto);
		if(flag){
			Vector<TeachersDTO> v = new Vector<TeachersDTO>();
			v = tdao.findAllTeachers();
			HttpSession s = req.getSession();
			s.setAttribute("allteacher", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllTeacher.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加失败\n请重新输入！","错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("addTeacherInfo.jsp");
		}
	}
}
