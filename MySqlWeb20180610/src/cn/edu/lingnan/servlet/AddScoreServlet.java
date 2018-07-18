package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.ScoreDTO;

@SuppressWarnings("serial")
public class AddScoreServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.从客户端接收页面传过来的数据
		String StudentId=request.getParameter("StudentId");
		String CourseId=request.getParameter("CourseId");
		String School="";
		int Semester=0;
		int Sign=1;
		//自动获取时间
		Date date=new Date();    
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");	 
	    String now=day.format(date);
	    //设置时间是1年后
	    Date newdate = stepMonth(date, +12);
	    String lastyear=day.format(newdate);	
	    String[] a=now.split("-");
        String year=a[0];
        int month=Integer.parseInt(a[1]);
	    String[] b=lastyear.split("-");
        String oneyear=b[0];
        School=year+"-"+oneyear;
        if(month>=1&&month<=6)
        	Semester=1;
        else
        	Semester=2;

		//2.处理数据：调用后台的业务逻辑去处理（DAO里面的方法）
		ScoreDAO scoredao=new ScoreDAO();
		ScoreDTO scoredto=new ScoreDTO();
		scoredto.setStudentId(StudentId);
		scoredto.setCourseId(CourseId);
		scoredto.setSchool(School);
		scoredto.setSemester(Semester);
		scoredto.setSign(Sign);
		
		boolean flag=scoredao.addScoreInfo(scoredto);
		//3.根据你的处理结果返回到相应的页面
		if(flag){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加成功！", "提示信息", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect(request.getContextPath()+"/admin/findAllScoreServlet");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"添加失败\n请重新输入！","错误信息", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("addScoreInfo.jsp");
		}
	}
	
	public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }
}

