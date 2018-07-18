package cn.edu.lingnan.servlet;
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import cn.edu.lingnan.dao.AdminDao;  
  
public class ALoginServlet extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.setCharacterEncoding("gb2312");  
        response.setContentType("text/html;charset=gb2312");  
        String adminname = request.getParameter("aname");  
        String password = request.getParameter("password").trim();  
        String svc =(String) request.getSession().getAttribute("sessionverify");  
        String psw =new AdminDao().findAdminname(adminname);  
        System.out.println(psw);
        System.out.println(password);
        if(psw ==null){  
            request.setAttribute("msg1", "没有该用户！");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        if(psw.equals(password)){  
            request.setAttribute("msg1", "欢迎管理员："+adminname+"访问");  
            request.getRequestDispatcher("/ext.jsp").forward(request, response);  
            //response.setHeader("Refresh","1;url=welcome.jsp");  
        }  
        if(psw!=null&&!psw.equals(password)){  
            request.setAttribute("msg1", "密码错误请重新输入！");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        
          
    }  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	doGet(request,response);
	}
    
    
}  