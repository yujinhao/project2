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

import cn.edu.lingnan.dao.ManagersDAO;
import cn.edu.lingnan.dto.ManagersDTO;

@SuppressWarnings("serial")
public class UpdateMyself extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ManagerId = req.getParameter("ManagerId");
		String ManagerName = new String(req.getParameter("ManagerName").getBytes("ISO-8859-1"),"GB2312");
		String ManagerSex = new String(req.getParameter("ManagerSex").getBytes("ISO-8859-1"),"GB2312");
		String ManagerTel = new String(req.getParameter("ManagerTel").getBytes("ISO-8859-1"),"GB2312");
		String ManagerAddr = new String(req.getParameter("ManagerAddr").getBytes("ISO-8859-1"),"GB2312");
		String ManagerPassw = req.getParameter("ManagerPassw");
		ManagersDTO mdto = new ManagersDTO();
		ManagersDAO mdao = new ManagersDAO();
		mdto.setManagerId(ManagerId);
		mdto.setManagerName(ManagerName);
		mdto.setManagerSex(ManagerSex);
		mdto.setManagerTel(Integer.parseInt(ManagerTel));
		mdto.setManagerAddr(ManagerAddr);
		mdto.setManagerPassw(ManagerPassw);		
		
		Boolean flag=mdao.updateManagerInfo(mdto);
		if(flag){
			Vector<ManagersDTO> v = new Vector<ManagersDTO>();
			v = mdao.findManagerByManagerId(ManagerId);
			HttpSession s = req.getSession();
			s.setAttribute("myself", v);
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			resp.sendRedirect("showMyself.jsp");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"修改失败！",  "错误信息", JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect("showMyself.jsp");
		}
	}
}
