<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ScoreDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改选课情况信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				修改选课情况信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改选课情况信息</span>
				</div>
				<form action="updateScoreServlet">
                        <%
                        	String StudentId = request.getParameter("StudentId");
                            String CourseId = request.getParameter("CourseId");
							Vector<ScoreDTO> v = new Vector<ScoreDTO>();
							v = (Vector<ScoreDTO>)session.getAttribute("allscore");
							Iterator it = v.iterator();
							ScoreDTO s = null;
							while(it.hasNext()){
								s = (ScoreDTO)it.next();
								if(s.getStudentId().equals(StudentId)&&s.getCourseId().equals(CourseId)){
						 %>				
				<div class="baBody">
					<div class="bbD">学生编码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <input readOnly="true" name="StudentId" value=<%=s.getStudentId() %> class="input3" />
					</div>
					<div class="bbD">课程编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <input readOnly="true" name="CourseId" value=<%=s.getCourseId()%> class="input3" />
					</div>
					<div class="bbD">学年：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <input name="School" value=<%=s.getSchool()%> class="input3" />
					</div>
					<div class="bbD">学期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <input name="Semester" value=<%=s.getSemester() %> class="input3"/>
					</div>
					<div class="bbD">学生是否可退选：
					    <input name="Sign" value=<%=s.getSign() %> class="input3" />
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">确认修改</button>
							<a class="btn_ok btn_no" href="findAllScoreServlet">取消</a>
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