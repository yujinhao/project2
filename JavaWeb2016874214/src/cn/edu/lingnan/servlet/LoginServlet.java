package cn.edu.lingnan.servlet;
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import cn.edu.lingnan.dao.UserDao;  
  
public class LoginServlet extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.setCharacterEncoding("gb2312");  
        response.setContentType("text/html;charset=gb2312");  
        String username = request.getParameter("uname");  
        String password = request.getParameter("password").trim();  
        /*String verifyc  = request.getParameter("verifycode");*/
        String svc =(String) request.getSession().getAttribute("sessionverify");  
        String psw =new UserDao().findUsername(username);  
        /*if(!svc.equalsIgnoreCase(verifyc)){  
            request.setAttribute("msg", "验证码错误！");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  */
        System.out.println(psw);
        System.out.println(password);
        if(psw ==null){  
            request.setAttribute("msg2", "没有该用户！");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        
        
        if(psw.equals(password)){  
            request.setAttribute("msg2", "欢迎："+username+"访问");  
            request.getRequestDispatcher("/ext2.jsp").forward(request, response);  
            //response.setHeader("Refresh","1;url=welcome.jsp");  
        }  
        if(psw!=null&&!psw.equals(password)){  
            request.setAttribute("msg2", "密码错误请重新输入！");  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);  
            return;  
        }  
        
          
    }  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	doGet(request,response);
	}
    
    
}  