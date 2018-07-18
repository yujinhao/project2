<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.CourseDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改课程信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllStudent">课程管理</a>&nbsp;-</span>&nbsp;修改课程信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改课程信息</span>
				</div>
				<form action="updateCourseServlet">
                        <%
                        	String CourseId = request.getParameter("CourseId");
							Vector<CourseDTO> v = new Vector<CourseDTO>();
							v = (Vector<CourseDTO>)session.getAttribute("allcourse");
							Iterator it = v.iterator();
							CourseDTO d = null;
							while(it.hasNext()){
								d = (CourseDTO)it.next();
								if(d.getCourseId().equals(CourseId)){
						 %>				
				<div class="baBody">
					<div class="bbD">课程编号：<input readOnly="true" name="CourseId" value=<%=d.getCourseId() %> class="input3" /></div>
					<div class="bbD">课程名称：<input name="CourseName" value=<%=d.getCourseName() %> class="input3" /></div>
					<div class="bbD">课程学分：<input name="CourseCredit" value=<%=d.getCourseCredit() %> class="input3" /></div>
					<div class="bbD">课程学时：<input name="CourseClass" value=<%=d.getCourseClass()%> class="input3" /></div>
					<div class="bbD">课程性质：<input name="CourseDesc" value=<%=d.getCourseDesc() %> class="input3" /></div>
					<div class="bbD">上课时间：<input name="ClassTime" value=<%=d.getClassTime() %> class="input3" /></div>
					<div class="bbD">上课地点：<input name="Address" value=<%=d.getAddress() %> class="input3" /></div>
					<div class="bbD">课程容量：<input name="Volume" value=<%=d.getVolume() %> class="input3" /></div>
					<div class="bbD">课程余量：<input name="Remain" value=<%=d.getRemain() %> class="input3" /></div>
					
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">确认修改</button>
							<a class="btn_ok btn_no" href="findAllCourseServlet">取消</a>
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