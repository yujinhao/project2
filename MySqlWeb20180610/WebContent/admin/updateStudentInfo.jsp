<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸�ѧ����Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllStudent">ѧ������</a>&nbsp;-</span>&nbsp;�޸�ѧ����Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�޸�ѧ����Ϣ</span>
				</div>
				<form action="updateStudentServlet">
                        <%
                        	String StudentId = request.getParameter("StudentId");
							Vector<StudentsDTO> v = new Vector<StudentsDTO>();
							v = (Vector<StudentsDTO>)session.getAttribute("allstudent");
							Iterator it = v.iterator();
							StudentsDTO s = null;
							while(it.hasNext()){
								s = (StudentsDTO)it.next();
								if(s.getStudentId().equals(StudentId)){
						 %>				
				<div class="baBody">
					<div class="bbD">ѧ����ţ�<input readOnly="true" name="StudentId" value=<%=s.getStudentId() %> class="input3" /></div>
					<div class="bbD">ѧ��������<input name="StudentName" value=<%=s.getStudentName() %> class="input3" />&nbsp;&nbsp;�����༶��<input name="ClassId" value=<%=s.getClassId() %> class="input3" /></div>
					<div class="bbD">ѧ���Ա�<input name="StudentSex" value=<%=s.getStudentSex() %> class="input3" />&nbsp;&nbsp;��ѧʱ�䣺<input name="EntranceTime" value=<%=s.getEntranceTime() %> class="input3" /></div>
					<div class="bbD">ѧ�����䣺<input name="StudentAge" value=<%=s.getStudentAge() %> class="input3" />&nbsp;&nbsp;��¼���룺<input name="StudentPassw" value=<%=s.getStudentPassw() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="findAllStudent">ȡ��</a>
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