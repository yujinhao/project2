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

import cn.edu.lingnan.dao.MajorDAO;
import cn.edu.lingnan.dto.MajorDTO;

@SuppressWarnings("serial")
public class AddMajorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String MajorId = req.getParameter("MajorId");
		String DeptId = req.getParameter("DeptId");
		String MajorName = new String(req.getParameter("MajorName").getBytes("ISO-8859-1"),"GB2312");
		String ClassNumber = req.getParameter("ClassNumber");
		MajorDTO mdto = new MajorDTO();
		MajorDAO mdao = new MajorDAO();
		mdto.setMajorId(MajorId);
		mdto.setDeptId(DeptId);
		mdto.setMajorName(MajorName);
		mdto.setClassNumber(Integer.parseInt(ClassNumber));
		
		Boolean flag=mdao.addMajorInfo(mdto);
		if(flag){
			Vector<MajorDTO> v = new Vector<MajorDTO>();
			v = mdao.findAllMajorInfo();
			HttpSession s = req.getSession();
			s.setAttribute("allmajor", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllMajor.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"该专业编号已存在 \n或此院系编号不存在！", "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllMajor.jsp");
		}
	}
}
