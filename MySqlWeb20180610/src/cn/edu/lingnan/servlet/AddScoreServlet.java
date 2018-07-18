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
		//1.�ӿͻ��˽���ҳ�洫����������
		String StudentId=request.getParameter("StudentId");
		String CourseId=request.getParameter("CourseId");
		String School="";
		int Semester=0;
		int Sign=1;
		//�Զ���ȡʱ��
		Date date=new Date();    
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");	 
	    String now=day.format(date);
	    //����ʱ����1���
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

		//2.�������ݣ����ú�̨��ҵ���߼�ȥ����DAO����ķ�����
		ScoreDAO scoredao=new ScoreDAO();
		ScoreDTO scoredto=new ScoreDTO();
		scoredto.setStudentId(StudentId);
		scoredto.setCourseId(CourseId);
		scoredto.setSchool(School);
		scoredto.setSemester(Semester);
		scoredto.setSign(Sign);
		
		boolean flag=scoredao.addScoreInfo(scoredto);
		//3.������Ĵ��������ص���Ӧ��ҳ��
		if(flag){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"��ӳɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect(request.getContextPath()+"/admin/findAllScoreServlet");
		}
		else{
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
					"���ʧ��\n���������룡","������Ϣ", JOptionPane.ERROR_MESSAGE);
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

