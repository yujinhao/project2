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

import cn.edu.lingnan.dao.StudentsDAO;
import cn.edu.lingnan.dto.StudentsDTO;

@SuppressWarnings("serial")
public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String StudentId = req.getParameter("StudentId");
		String ClassId = req.getParameter("ClassId");
		String StudentName = new String(req.getParameter("StudentName").getBytes("ISO-8859-1"),"GB2312");
		String StudentSex = new String(req.getParameter("StudentSex").getBytes("ISO-8859-1"),"GB2312");
		String StudentAge = req.getParameter("StudentAge");
		String EntranceTime = req.getParameter("EntranceTime");
		String StudentPassw = req.getParameter("StudentPassw");		
//		System.out.println("StudentId"+StudentId+" ClassId"+ClassId+" StudentName"+StudentName+
//				" StudentSex"+StudentSex+" StudentAge"+StudentAge+" EntranceTime"+EntranceTime+" StudentPassw"+StudentPassw);
		StudentsDTO sdto = new StudentsDTO();
		StudentsDAO sdao = new StudentsDAO();
		sdto.setStudentId(StudentId);
		sdto.setClassId(ClassId);
		sdto.setStudentName(StudentName);
		sdto.setStudentSex(StudentSex);
		sdto.setStudentAge(Integer.parseInt(StudentAge));
		sdto.setEntranceTime(EntranceTime);
		sdto.setStudentPassw(StudentPassw);
		
		Boolean flag=sdao.addStudentInfo(sdto);
		if(flag){
			Vector<StudentsDTO> v = new Vector<StudentsDTO>();
			v = sdao.findAllStudents();
			HttpSession s = req.getSession();
			s.setAttribute("allstudent", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllStudent.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加失败\n请重新输入！", "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("addStudentInfo.jsp");
		}
	}
}