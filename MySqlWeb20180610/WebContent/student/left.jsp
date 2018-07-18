<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB2312">
     <meta http-equiv="Cache-Control" content="no-cache"/> 
<title>首页左侧导航</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">
      <%
          String UserId=(String)session.getAttribute("UserId");    	
       %>
		<div class="leftsidebar_box">
			<!--  <a href="student.html" target="main"><div class="line">
					<img src="img/coin01.png" />&nbsp;&nbsp;首页
				</div></a>-->
				
				<!--课程信息管理-->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin03.png" /><img class="icon2"
						src="img/coin04.png" /> 选课活动报名<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="findStuAllCourseServlet"
						target="main">选课课程信息</a><img class="icon5" src="img/coin21.png" />
				</dd>
				<!-- <dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="addCourseInfo.jsp"
						target="main">已选课程信息</a><img class="icon5" src="img/coin21.png" />
				</dd> -->
			</dl>
			
			
				
			<!--学生信息管理-->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin07.png" /><img class="icon2"
						src="img/coin08.png" /> 信息查询<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="findStuScoreServlet?StudentId=<%=UserId%>" target="main"
						class="cks">个人成绩查询</a><img class="icon5" src="img/coin21.png" />
				</dd>
			   <dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="findStuCourseServlet?StudentId=<%=UserId%>" target="main"
						class="cks">选课情况查询</a><img class="icon5" src="img/coin21.png" />
				</dd> 
			</dl>
				
			<!--系统管理-->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coinL1.png" /><img class="icon2"
						src="img/coinL2.png" /> 信息维护<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="findStudentInfo?StudentId=<%=UserId%>"
						target="main" class="cks">个人信息</a><img class="icon5"
						src="img/coin21.png" />
				</dd>
<!-- 				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="UpdateStudentInfoServlet"
						target="main" class="cks">信息修改</a><img
						class="icon5" src="img/coin21.png" />
				</dd> -->
			</dl>

		</div>

	</div>
</body>
</html>
