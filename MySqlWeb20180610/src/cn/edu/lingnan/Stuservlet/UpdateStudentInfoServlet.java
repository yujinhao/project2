package cn.edu.lingnan.Stuservlet;

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
public class UpdateStudentInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String StudentId=(String)session.getAttribute("UserId");
		//String StudentId = req.getParameter("StudentId");
		String ClassId = req.getParameter("ClassId");
		String StudentName=new String(req.getParameter("StudentName").getBytes("ISO-8859-1"),"GB2312");
		String StudentSex=new String(req.getParameter("StudentSex").getBytes("ISO-8859-1"),"GB2312");
		String StudentAge = req.getParameter("StudentAge");
		String EntranceTime=new String(req.getParameter("EntranceTime").getBytes("ISO-8859-1"),"GB2312");
		String StudentPassw = req.getParameter("StudentPassw");
		StudentsDTO sdto = new StudentsDTO();
		StudentsDAO sdao = new StudentsDAO();
		sdto.setStudentId(StudentId);
		sdto.setClassId(ClassId);
		sdto.setStudentName(StudentName);
		sdto.setStudentSex(StudentSex);
		sdto.setStudentAge(Integer.parseInt(StudentAge));
		sdto.setEntranceTime(EntranceTime);
		sdto.setStudentPassw(StudentPassw);
		
		boolean flag = sdao.updateStudentInfo(sdto);
		if(flag){
		Vector<StudentsDTO> v = new Vector<StudentsDTO>();
		v = sdao.findAllStudents();
		HttpSession s = req.getSession();
		s.setAttribute("person", v);	
		JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
		//resp.sendRedirect("updateStudent.jsp");
		 resp.sendRedirect("findStudentInfo");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改失败！",  "错误信息", JOptionPane.ERROR_MESSAGE);  
		resp.sendRedirect("updateStudent.jsp");
		}
	}
}

