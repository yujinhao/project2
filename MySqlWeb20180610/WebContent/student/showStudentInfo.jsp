<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>学生个人信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllStudent">信息维护</a>&nbsp;-</span>&nbsp;个人信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>个人信息</span>
				</div>
				<form action="findStudentInfo">
                        <%
                        Vector<StudentsDTO> v = new Vector<StudentsDTO>();
						v = (Vector<StudentsDTO>)session.getAttribute("person");
						Iterator it = v.iterator();
						StudentsDTO s = null;
						while(it.hasNext()){
							s = (StudentsDTO)it.next();		
						 %>				
				<div class="baBody">
					<div class="bbD">学生编号：<%=s.getStudentId()%></div>	
					<div class="bbD">所属班级：<%=s.getClassId() %></div>
					<div class="bbD">学生姓名：<%=s.getStudentName() %></div>
					<div class="bbD">学生性别：<%=s.getStudentSex() %> </div>
					<div class="bbD">学生年龄：<%=s.getStudentAge() %></div>
					<div class="bbD">入学时间：<%=s.getEntranceTime() %></div>
					<div class="bbD">登录密码：<%=s.getStudentPassw() %> </div>
					<div class="bbD">
                        <p class="bbDP">
							<a href="updateStudent.jsp?StudentId=<%=s.getStudentId()%>" class="btn_ok btn_yes" type="submit">修改个人信息</a>
						</p>
					</div>	
				</div>
				<%-- <div class="btn_box floatR mag_l20">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="updateStudent.jsp?StudentId=<%=s.getStudentId()%>">修改个人信息</a>
                </div> --%>
                         <%
								}
						%>				
				</form>
			</div>

			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
</html>