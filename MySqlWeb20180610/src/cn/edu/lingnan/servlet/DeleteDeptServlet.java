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

import cn.edu.lingnan.dao.DeptDAO;
import cn.edu.lingnan.dto.DeptDTO;

@SuppressWarnings("serial")
public class DeleteDeptServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String DeptId = req.getParameter("DeptId");
		DeptDAO sdao = new DeptDAO();		
		
		Boolean flag=sdao.deleteDeptByDeptId(DeptId);
		if(flag){
			Vector<DeptDTO> v = new Vector<DeptDTO>();
			v = sdao.findAllDeptInfo();
			HttpSession s = req.getSession();
			s.setAttribute("alldept", v);	
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllDept.jsp");	
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"删除失败\n请先删除相关的专业信息！","错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showAllDept.jsp");	
		}
			
	}
}
