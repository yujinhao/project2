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
public class UpdateDeptServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String DeptId = req.getParameter("DeptId");
		String DeptName = new String(req.getParameter("DeptName").getBytes("ISO-8859-1"),"GB2312");
		String DeptChairman = new String(req.getParameter("DeptChairman").getBytes("ISO-8859-1"),"GB2312");
		String DeptTel = req.getParameter("DeptTel");
		DeptDTO sdto = new DeptDTO();
		DeptDAO sdao = new DeptDAO();
		sdto.setDeptId(DeptId);
		sdto.setDeptName(DeptName);
		sdto.setDeptChairman(DeptChairman);
		sdto.setDeptTel(DeptTel);
		
		Boolean flag=sdao.updateDeptInfo(sdto);
		if(flag){
			Vector<DeptDTO> v = new Vector<DeptDTO>();
			v = sdao.findAllDeptInfo();
			HttpSession s = req.getSession();
			s.setAttribute("alldept", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showAllDept.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改失败！",  "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("updateDeptInfo.jsp");
		}
	}
}