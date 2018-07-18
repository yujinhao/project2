<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改教师信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllTeacher">教师管理</a>&nbsp;-</span>&nbsp;修改教师信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改教师信息</span>
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
					<div class="bbD">教师编码：<input readOnly="true" name="TeacherId" value=<%=s.getTeacherId() %> class="input3" />&nbsp;&nbsp;所属院系：<input name="DeptId" value=<%=s.getDeptId() %> class="input3" /></div>
					<div class="bbD">教师名称：<input name="TeacherName" value=<%=s.getTeacherName() %> class="input3" />&nbsp;&nbsp;教师职称：<input name="TeacherTitle" value=<%=s.getTeacherTitle() %> class="input3" /></div>
					<div class="bbD">教师性别：<input name="TeacherSex" value=<%=s.getTeacherSex() %> class="input3" />&nbsp;&nbsp;登录密码：<input name="TeacherPassw" value=<%=s.getTeacherPassw() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">确认修改</button>
							<a class="btn_ok btn_no" href="findAllTeacher">取消</a>
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