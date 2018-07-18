package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.MajorDAO;
import cn.edu.lingnan.dto.MajorDTO;

@SuppressWarnings("serial")
public class FindAllMajor extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		MajorDAO mdao = new MajorDAO();
		Vector<MajorDTO> v = new Vector<MajorDTO>();
		v = mdao.findAllMajorInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allmajor", v);
		resp.sendRedirect("showAllMajor.jsp");
	}
}
