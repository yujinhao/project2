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
public class DeleteMajorCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		MajorDAO sdao = new MajorDAO();
		for(String a:arr){
			String[] b = a.split(",");
			for(String c:b)
				sdao.deleteMajorByMajorId(c);
		}
		Vector<MajorDTO> v = new Vector<MajorDTO>();
		v = sdao.findAllMajorInfo();
		HttpSession s = req.getSession();
		s.setAttribute("allmajor", v);
		resp.sendRedirect("showAllMajor.jsp");			
	}
}
