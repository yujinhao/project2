<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>添加课程信息</title>
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<!--  <div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllCourseServlet">课程信息管理</a>&nbsp;-</span>&nbsp;添加课程信息
			</div>-->
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>输入课程信息</span>
				</div>
				<form action="addCourseServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"号为必填项目</p>
					<div class="bbD">课程编号<span class="f_cB">&nbsp;*</span>
					<input id="CourseId" name="CourseId" class="input3" required />
					</div>
					<div class="bbD">课程名称<span class="f_cB">&nbsp;*</span>
					<input id="CourseName" name="CourseName" class="input3" required />
					</div>
					<div class="bbD">课程学分<span class="f_cB">&nbsp;*</span>
					<input id="CourseCredit" name="CourseCredit" class="input3" required />
					</div>
					<div class="bbD">课程学时<span class="f_cB">&nbsp;*</span>
					<input id="CourseClass" name="CourseClass" class="input3" required />
					</div>					
					<div class="bbD">课程性质<span class="f_cB">&nbsp;*</span>
					<input id="CourseDesc" name="CourseDesc" class="input3" required />
					</div>
					<div class="bbD">上课时间<span class="f_cB">&nbsp;*</span>
					<input id="ClassTime" name="ClassTime" class="input3" required />
					</div>
					<div class="bbD">上课地点<span class="f_cB">&nbsp;*</span>
					<input id="Address" name="Address" class="input3" required />
					</div>
					<div class="bbD">课程容量<span class="f_cB">&nbsp;*</span>
					<input id="Volume" name="Volume" class="input3" required />
					</div>
					<div class="bbD">课程余量<span class="f_cB">&nbsp;*</span>
					<input id="Remain" name="Remain" class="input3" required />
					</div>
					
					<div class="bbD">
						<p class="bbDP">
							 <button class="btn_ok btn_yes" type="submit" onClick="return check();">确认添加</button>
							<a class="btn_ok btn_no" href="addCourseInfo.jsp">取消</a>
							<!--<input type="submit" value="确认添加"/>
                            <input type="button" value="返回" onclick="history.back(-1)"/> -->
						</p>
					</div>
				</div>			
				</form>
			</div>

			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
</html>