<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ScoreDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸�ѡ�������Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				¼��ɼ�
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>¼��ɼ�</span>
				</div>
				<form action="updateGrade">
                        <%
                        	String StudentId = request.getParameter("StudentId");
                            String CourseId = request.getParameter("CourseId");
							Vector<ScoreDTO> v = new Vector<ScoreDTO>();
							v = (Vector<ScoreDTO>)session.getAttribute("grade");
							Iterator it = v.iterator();
							ScoreDTO s = null;
							while(it.hasNext()){
								s = (ScoreDTO)it.next();
								if(s.getStudentId().equals(StudentId)&&s.getCourseId().equals(CourseId)){
						 %>				
				<div class="baBody">
					<div class="bbD">ѧ�����룺<input readOnly="true" name="StudentId" value=<%=s.getStudentId() %> class="input3" /></div>
					<div class="bbD">ѧ��������<input readOnly="true" name="StudentName" value=<%=s.getStudentName() %> class="input3" /></div>
					<div class="bbD">�γ̱�ţ�<input readOnly="true" name="CourseId" value=<%=s.getCourseId()%> class="input3" /></div>
					<div class="bbD">�γ����ƣ�<input readOnly="true" name="CourseId" value=<%=s.getCourseName()%> class="input3" /></div>
					<div class="bbD">������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="Grade" value=<%=s.getGrade() %> class="input3" /></div>
					<%-- <div class="bbD">���㣺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="GradePoint" value=<%=s.getGradePoint() %> class="input3" /></div> --%>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="lookGrade">ȡ��</a>
						</p>
					</div>
				</div>
                         <%
								}}
						%>				
				</form>
			</div>

			<!-- ��Աע��ҳ����ʽend -->
		</div>
	</div>
</body>
</html>