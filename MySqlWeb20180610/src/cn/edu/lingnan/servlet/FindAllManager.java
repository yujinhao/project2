package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ManagersDAO;
import cn.edu.lingnan.dto.ManagersDTO;

@SuppressWarnings("serial")
public class FindAllManager extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		ManagersDAO mdao = new ManagersDAO();
		Vector<ManagersDTO> v = new Vector<ManagersDTO>();
		v = mdao.findAllManagers();
		HttpSession s = req.getSession();
		s.setAttribute("allmanager", v);
		resp.sendRedirect("showAllManager.jsp");
	}
}
