<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸Ľ�ʦ��Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllTeacher">��ʦ����</a>&nbsp;-</span>&nbsp;�޸Ľ�ʦ��Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�޸Ľ�ʦ��Ϣ</span>
				</div>
				<form action="updateTeacherServlet">
                        <%
                        	String TeacherId = request.getParameter("TeacherId");
							Vector<TeachersDTO> v = new Vector<TeachersDTO>();
							v = (Vector<TeachersDTO>)session.getAttribute("allteacher");
							Iterator it = v.iterator();
							TeachersDTO s = null;
							while(it.hasNext()){
								s = (TeachersDTO)it.next();
								if(s.getTeacherId().equals(TeacherId)){
						 %>				
				<div class="baBody">
					<div class="bbD">��ʦ���룺<input readOnly="true" name="TeacherId" value=<%=s.getTeacherId() %> class="input3" />&nbsp;&nbsp;����Ժϵ��<input name="DeptId" value=<%=s.getDeptId() %> class="input3" /></div>
					<div class="bbD">��ʦ���ƣ�<input name="TeacherName" value=<%=s.getTeacherName() %> class="input3" />&nbsp;&nbsp;��ʦְ�ƣ�<input name="TeacherTitle" value=<%=s.getTeacherTitle() %> class="input3" /></div>
					<div class="bbD">��ʦ�Ա�<input name="TeacherSex" value=<%=s.getTeacherSex() %> class="input3" />&nbsp;&nbsp;��¼���룺<input name="TeacherPassw" value=<%=s.getTeacherPassw() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="findAllTeacher">ȡ��</a>
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