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

import cn.edu.lingnan.dao.ClassDAO;
import cn.edu.lingnan.dto.ClassDTO;

@SuppressWarnings("serial")
public class AddClassServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ClassId = req.getParameter("ClassId");
		String MajorId = req.getParameter("MajorId");
		String ClassName = new String(req.getParameter("ClassName").getBytes("ISO-8859-1"),"GB2312");
		String StudentsNumber = req.getParameter("StudentsNumber");
		ClassDTO cdto = new ClassDTO();
		ClassDAO cdao = new ClassDAO();
		cdto.setClassId(ClassId);
		cdto.setMajorId(MajorId);
		cdto.setClassName(ClassName);
		cdto.setStudentsNumber(Integer.parseInt(StudentsNumber));
		Boolean flag=cdao.addClassInfo(cdto);
		if(flag){
			Vector<ClassDTO> v = new Vector<ClassDTO>();
			v = cdao.findClass();
			HttpSession s = req.getSession();
			s.setAttribute("allclass", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllClass.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"该班级编号已存在 \n或此专业编号不存在！", "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllClass.jsp");
		}
	}
}