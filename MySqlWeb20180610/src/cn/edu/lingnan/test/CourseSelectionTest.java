package cn.edu.lingnan.test;

import java.util.Vector;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dao.TeachingDAO;
import cn.edu.lingnan.dao.UsersDAO;
import cn.edu.lingnan.dto.ScoreDTO;
import cn.edu.lingnan.dto.TeachingDTO;
import cn.edu.lingnan.dto.UsersDTO;

public class CourseSelectionTest {

	public static void main(String[] args) {
		Vector<ScoreDTO> v=new Vector<ScoreDTO>();
		ScoreDAO scoredao=new ScoreDAO();
		Vector<UsersDTO> v2=new Vector<UsersDTO>();
		UsersDAO usersdao=new UsersDAO();
		//查询测试
		v=scoredao.findAllScoreInfo();
		System.out.println("全部选课情况信息如下：");
		for(ScoreDTO sd:v)
			System.out.println("学生id："+sd.getStudentId()+"   课程id："+sd.getCourseId());
		
		v=scoredao.findScoreByStudentId("S01");
		System.out.println("学生S01的选课情况信息如下：");
		for(ScoreDTO sd:v)
			System.out.println("学生id："+sd.getStudentId()+"   课程id："+sd.getCourseId());
		
		v=scoredao.findScoreByCourseId("Cou11");
		System.out.println("课程Cou11的选课情况信息如下：");
		for(ScoreDTO sd:v)
			System.out.println("学生id："+sd.getStudentId()+"   课程id："+sd.getCourseId());
		
		v=scoredao.findScoreByStudentIdandCourseId("S05", "Cou05");
		System.out.println("学生S05和课程Cou05的选课情况信息如下：");
		for(ScoreDTO sd:v)
			System.out.println("学生id："+sd.getStudentId()+"   课程id："+sd.getCourseId()+"   绩点："+sd.getGradePoint());
		
		v2=usersdao.findAllUsers();
		for(UsersDTO ud:v2)
			System.out.println("用户id："+ud.getUserId());
		int b=usersdao.findUserByIdAndPassword("aaaa","aaaa");
		System.out.println(b);
		
//		String AllCourseCredit="";
//		AllCourseCredit=scoredao.countCourseCredit("S01","2018-2019",1);
//		System.out.println("呦西呦西"+AllCourseCredit);
		
		//添加测试
//		ScoreDTO scoredto=new ScoreDTO();
//		scoredto.setStudentId("S01");
//		scoredto.setCourseId("Cou03");
//		scoredto.setSchool("2018-2019");
//		scoredto.setSemester(1);
//		scoredto.setSign(1);
//		String a=scoredao.addScoreInfo(scoredto);
//		System.out.println("哈哈哈哈hh我又来了"+a);
		
		//删除测试
//		boolean flag=scoredao.deleteScoreByStudentIdandCourseId("S01","Cou02");
//		if(flag)
//			System.out.println("删除成功");
		
//		boolean flag=scoredao.deleteScoreByStudentId("S01");
//		if(flag)
//			System.out.println("删除成功");
		
//		boolean flag=scoredao.deleteScoreByCourseId("Cou02");
//		if(flag)
//			System.out.println("删除成功");
		
		//修改测试
//		ScoreDTO scoredto=new ScoreDTO();
//		scoredto.setStudentId("S05");
//		scoredto.setCourseId("Cou05");
//		scoredto.setGrade(82);
//		scoredto.setGradePoint(3.22f);
//		boolean flag=scoredao.updateSroceInfo(scoredto);
//		if(flag)
//			System.out.println("更新成功");
		
//---------------------------------------------------------------------------------------------------------------------
		System.out.println("------------------------------------------------------");
		Vector<TeachingDTO> v1=new Vector<TeachingDTO>();
		TeachingDAO teachingdao=new TeachingDAO();
		//查询测试
		v1=teachingdao.findAllTeachingInfo();
		System.out.println("全部授课情况信息如下：");
		for(TeachingDTO td:v1)
			System.out.println("教师id："+td.getTeacherId()+"   课程id："+td.getCourseId());
		
		v1=teachingdao.findTeachingByTeacherId("T01");
		System.out.println("T01的授课情况信息如下：");
		for(TeachingDTO td:v1)
			System.out.println("教师id："+td.getTeacherId()+"   课程id："+td.getCourseId());
		
		v1=teachingdao.findTeachingByCourseId("Cou09");
		System.out.println("课程Cou11的选课情况信息如下：");
		for(TeachingDTO td:v1)
			System.out.println("教师id："+td.getTeacherId()+"   课程id："+td.getCourseId());
		
		v1=teachingdao.findTeachingByTeacherIdandCourseId("T05", "Cou05");
		System.out.println("教师T05和课程Cou05的选课情况信息如下：");
		for(TeachingDTO td:v1)
			System.out.println("教师id"+td.getTeacherId()+"   课程id："+td.getCourseId()+"   学生数量："+td.getStudentsNumber());		
		
		//视图查询测试
		v1=teachingdao.findAllTeachingviewInfo();
		System.out.println("全部详细授课情况信息如下：哈哈哈哈哈哈哈哈哈或或哈哈哈哈hh或");
		for(TeachingDTO td:v1)
			System.out.println("教师id："+td.getTeacherId()+"   课程名："+td.getCourseName());
		
		//添加测试
//		TeachingDTO teachingdto=new TeachingDTO();
//		teachingdto.setTeacherId("T02");
//		teachingdto.setCourseId("Cou02");
//		teachingdto.setStudentsNumber(45);;
//		boolean flag=teachingdao.addTeachingInfo(teachingdto);
//		if(flag)
//			System.out.println("添加成功！");
		
		//删除测试
//		boolean flag=teachingdao.deleteTeachingByTeacherIdandCourseId("T01","Cou01");
//		if(flag)
//			System.out.println("删除成功");
		
//		boolean flag=teachingdao.deleteTeachingByTeacherId("T01");
//		if(flag)
//			System.out.println("删除成功");
		
//		boolean flag=teachingdao.deleteTeachingByCourseId("Cou02");
//		if(flag)
//			System.out.println("删除成功");
		
		//修改测试
//		TeachingDTO teachingdto=new TeachingDTO();
//		teachingdto.setTeacherId("T03");
//		teachingdto.setCourseId("Cou03");
//		teachingdto.setStudentsNumber(45);;
//		boolean flag=teachingdao.updateTeachingInfo(teachingdto);
//		if(flag)
//			System.out.println("更新成功！");
	}
}
