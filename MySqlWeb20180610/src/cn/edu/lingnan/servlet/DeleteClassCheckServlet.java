package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClassDAO;
import cn.edu.lingnan.dto.ClassDTO;

@SuppressWarnings("serial")
public class DeleteClassCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		ClassDAO cdao = new ClassDAO();
		for(String a:arr){
			String[] b = a.split(",");
			for(String c:b)
				cdao.deleteClassByClassId(c);
		}
		Vector<ClassDTO> v = new Vector<ClassDTO>();
		v = cdao.findClass();
		HttpSession s = req.getSession();
		s.setAttribute("allclass", v);
		resp.sendRedirect("showAllClass.jsp");			
	}
}
