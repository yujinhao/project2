<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachingDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸��ڿ������Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				�޸��ڿ������Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�޸��ڿ������Ϣ</span>
				</div>
				<form action="updateTeachingServlet">
                        <%
                        	String TeacherId = request.getParameter("TeacherId");
                            String CourseId = request.getParameter("CourseId");
							Vector<TeachingDTO> v = new Vector<TeachingDTO>();
							v = (Vector<TeachingDTO>)session.getAttribute("allteaching");
							Iterator it = v.iterator();
							TeachingDTO s = null;
							while(it.hasNext()){
								s = (TeachingDTO)it.next();
								if(s.getTeacherId().equals(TeacherId)&&s.getCourseId().equals(CourseId)){
						 %>				
				<div class="baBody">
					<div class="bbD">��ʦ���룺<input readOnly="true" name="TeacherId" value=<%=s.getTeacherId() %> class="input3" /></div>
					<div class="bbD">�γ̱�ţ�<input name="CourseId" value=<%=s.getCourseId()%> class="input3" /></div>
					<div class="bbD">ѧ��������<input name="StudentsNumber" value=<%=s.getStudentsNumber() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="findAllTeachingServlet">ȡ��</a>
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