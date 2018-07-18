<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改学生信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllStudent">学生管理</a>&nbsp;-</span>&nbsp;修改学生信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改学生信息</span>
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
					<div class="bbD">学生编号：<input readOnly="true" name="StudentId" value=<%=s.getStudentId() %> class="input3" /></div>
					<div class="bbD">学生姓名：<input name="StudentName" value=<%=s.getStudentName() %> class="input3" />&nbsp;&nbsp;所属班级：<input name="ClassId" value=<%=s.getClassId() %> class="input3" /></div>
					<div class="bbD">学生性别：<input name="StudentSex" value=<%=s.getStudentSex() %> class="input3" />&nbsp;&nbsp;入学时间：<input name="EntranceTime" value=<%=s.getEntranceTime() %> class="input3" /></div>
					<div class="bbD">学生年龄：<input name="StudentAge" value=<%=s.getStudentAge() %> class="input3" />&nbsp;&nbsp;登录密码：<input name="StudentPassw" value=<%=s.getStudentPassw() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">确认修改</button>
							<a class="btn_ok btn_no" href="findAllStudent">取消</a>
						</p>
					</div>
				</div>
                         <%
								}}
						%>				
				</form>
			</div>

			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
</html>