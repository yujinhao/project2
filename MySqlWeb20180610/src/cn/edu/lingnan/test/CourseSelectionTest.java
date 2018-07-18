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
		//��ѯ����
		v=scoredao.findAllScoreInfo();
		System.out.println("ȫ��ѡ�������Ϣ���£�");
		for(ScoreDTO sd:v)
			System.out.println("ѧ��id��"+sd.getStudentId()+"   �γ�id��"+sd.getCourseId());
		
		v=scoredao.findScoreByStudentId("S01");
		System.out.println("ѧ��S01��ѡ�������Ϣ���£�");
		for(ScoreDTO sd:v)
			System.out.println("ѧ��id��"+sd.getStudentId()+"   �γ�id��"+sd.getCourseId());
		
		v=scoredao.findScoreByCourseId("Cou11");
		System.out.println("�γ�Cou11��ѡ�������Ϣ���£�");
		for(ScoreDTO sd:v)
			System.out.println("ѧ��id��"+sd.getStudentId()+"   �γ�id��"+sd.getCourseId());
		
		v=scoredao.findScoreByStudentIdandCourseId("S05", "Cou05");
		System.out.println("ѧ��S05�Ϳγ�Cou05��ѡ�������Ϣ���£�");
		for(ScoreDTO sd:v)
			System.out.println("ѧ��id��"+sd.getStudentId()+"   �γ�id��"+sd.getCourseId()+"   ���㣺"+sd.getGradePoint());
		
		v2=usersdao.findAllUsers();
		for(UsersDTO ud:v2)
			System.out.println("�û�id��"+ud.getUserId());
		int b=usersdao.findUserByIdAndPassword("aaaa","aaaa");
		System.out.println(b);
		
//		String AllCourseCredit="";
//		AllCourseCredit=scoredao.countCourseCredit("S01","2018-2019",1);
//		System.out.println("��������"+AllCourseCredit);
		
		//��Ӳ���
//		ScoreDTO scoredto=new ScoreDTO();
//		scoredto.setStudentId("S01");
//		scoredto.setCourseId("Cou03");
//		scoredto.setSchool("2018-2019");
//		scoredto.setSemester(1);
//		scoredto.setSign(1);
//		String a=scoredao.addScoreInfo(scoredto);
//		System.out.println("��������hh��������"+a);
		
		//ɾ������
//		boolean flag=scoredao.deleteScoreByStudentIdandCourseId("S01","Cou02");
//		if(flag)
//			System.out.println("ɾ���ɹ�");
		
//		boolean flag=scoredao.deleteScoreByStudentId("S01");
//		if(flag)
//			System.out.println("ɾ���ɹ�");
		
//		boolean flag=scoredao.deleteScoreByCourseId("Cou02");
//		if(flag)
//			System.out.println("ɾ���ɹ�");
		
		//�޸Ĳ���
//		ScoreDTO scoredto=new ScoreDTO();
//		scoredto.setStudentId("S05");
//		scoredto.setCourseId("Cou05");
//		scoredto.setGrade(82);
//		scoredto.setGradePoint(3.22f);
//		boolean flag=scoredao.updateSroceInfo(scoredto);
//		if(flag)
//			System.out.println("���³ɹ�");
		
//---------------------------------------------------------------------------------------------------------------------
		System.out.println("------------------------------------------------------");
		Vector<TeachingDTO> v1=new Vector<TeachingDTO>();
		TeachingDAO teachingdao=new TeachingDAO();
		//��ѯ����
		v1=teachingdao.findAllTeachingInfo();
		System.out.println("ȫ���ڿ������Ϣ���£�");
		for(TeachingDTO td:v1)
			System.out.println("��ʦid��"+td.getTeacherId()+"   �γ�id��"+td.getCourseId());
		
		v1=teachingdao.findTeachingByTeacherId("T01");
		System.out.println("T01���ڿ������Ϣ���£�");
		for(TeachingDTO td:v1)
			System.out.println("��ʦid��"+td.getTeacherId()+"   �γ�id��"+td.getCourseId());
		
		v1=teachingdao.findTeachingByCourseId("Cou09");
		System.out.println("�γ�Cou11��ѡ�������Ϣ���£�");
		for(TeachingDTO td:v1)
			System.out.println("��ʦid��"+td.getTeacherId()+"   �γ�id��"+td.getCourseId());
		
		v1=teachingdao.findTeachingByTeacherIdandCourseId("T05", "Cou05");
		System.out.println("��ʦT05�Ϳγ�Cou05��ѡ�������Ϣ���£�");
		for(TeachingDTO td:v1)
			System.out.println("��ʦid"+td.getTeacherId()+"   �γ�id��"+td.getCourseId()+"   ѧ��������"+td.getStudentsNumber());		
		
		//��ͼ��ѯ����
		v1=teachingdao.findAllTeachingviewInfo();
		System.out.println("ȫ����ϸ�ڿ������Ϣ���£�����������������������������hh��");
		for(TeachingDTO td:v1)
			System.out.println("��ʦid��"+td.getTeacherId()+"   �γ�����"+td.getCourseName());
		
		//��Ӳ���
//		TeachingDTO teachingdto=new TeachingDTO();
//		teachingdto.setTeacherId("T02");
//		teachingdto.setCourseId("Cou02");
//		teachingdto.setStudentsNumber(45);;
//		boolean flag=teachingdao.addTeachingInfo(teachingdto);
//		if(flag)
//			System.out.println("��ӳɹ���");
		
		//ɾ������
//		boolean flag=teachingdao.deleteTeachingByTeacherIdandCourseId("T01","Cou01");
//		if(flag)
//			System.out.println("ɾ���ɹ�");
		
//		boolean flag=teachingdao.deleteTeachingByTeacherId("T01");
//		if(flag)
//			System.out.println("ɾ���ɹ�");
		
//		boolean flag=teachingdao.deleteTeachingByCourseId("Cou02");
//		if(flag)
//			System.out.println("ɾ���ɹ�");
		
		//�޸Ĳ���
//		TeachingDTO teachingdto=new TeachingDTO();
//		teachingdto.setTeacherId("T03");
//		teachingdto.setCourseId("Cou03");
//		teachingdto.setStudentsNumber(45);;
//		boolean flag=teachingdao.updateTeachingInfo(teachingdto);
//		if(flag)
//			System.out.println("���³ɹ���");
	}
}
