package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.DeptDAO;
import cn.edu.lingnan.dto.DeptDTO;

@SuppressWarnings("serial")
public class DeleteDeptCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		DeptDAO sdao = new DeptDAO();
		for(String a:arr){
			String[] b = a.split(",");
			for(String c:b)
				sdao.deleteDeptByDeptId(c);
		}
		Vector<DeptDTO> v = new Vector<DeptDTO>();
		v = sdao.findAllDeptInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alldept", v);
		resp.sendRedirect("showAllDept.jsp");			
	}
}
