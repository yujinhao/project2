package cn.edu.lingnan.Stuservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.CourseDAO;
import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.CourseDTO;
import cn.edu.lingnan.dto.ScoreDTO;

@SuppressWarnings("serial")
public class StudentChooseCourseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String StudentId=(String)session.getAttribute("UserId");
		//由于传过来的多加/，所以要分割
		String _CourseId=request.getParameter("CourseId");
		String[] c=_CourseId.split("/");
        String CourseId=c[0];
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
        //把值赋值
		ScoreDAO scoredao=new ScoreDAO();
		ScoreDTO scoredto=new ScoreDTO();
		scoredto.setStudentId(StudentId);
		scoredto.setCourseId(CourseId);
		scoredto.setSchool(School);
		scoredto.setSemester(Semester);
		scoredto.setSign(Sign);
		//判断课程余量是否为0
		Vector<CourseDTO> v1=new Vector<CourseDTO>();
		CourseDAO coursedao=new CourseDAO();
		v1=coursedao.findCourseByCourseId(CourseId);
		if(v1.size()>0){
			for(CourseDTO cd:v1){
				if(cd.getRemain()<=0){
					JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
							"该课程已选完，不能再选择！", "提示信息", JOptionPane.WARNING_MESSAGE);
					response.sendRedirect(request.getContextPath()+"/student/findStuAllCourseServlet");
				}
				else{
					//判断该课程是否被选过
					Vector<ScoreDTO> v=new Vector<ScoreDTO>();
					v=scoredao.findScoreByStudentIdandCourseId(StudentId, CourseId);
					if(v.size()>0){
						JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
								"您已选了此课程了！", "提示信息", JOptionPane.WARNING_MESSAGE);
						response.sendRedirect(request.getContextPath()+"/student/findStuAllCourseServlet");
					}
					else{
						boolean flag=scoredao.addScoreInfo(scoredto);
						if(flag){
							response.sendRedirect(request.getContextPath()+"/student/findStuAllCourseServlet");
						JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
								"提交成功kkkkk！", "提示信息", JOptionPane.WARNING_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
									"您已选了此课程了！", "提示信息", JOptionPane.WARNING_MESSAGE);
							response.sendRedirect(request.getContextPath()+"/student/findStuAllCourseServlet");
						}
					}
				}
			}			
		}
	}
	
	public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }
}
