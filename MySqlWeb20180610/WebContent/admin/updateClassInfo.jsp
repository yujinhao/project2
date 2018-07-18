<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ClassDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改班级信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllClass">班级管理</a>&nbsp;-</span>&nbsp;修改班级信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改班级信息</span>
				</div>
				<form action="updateClassServlet">
                        <%
                        	String ClassId = request.getParameter("ClassId");
							Vector<ClassDTO> v = new Vector<ClassDTO>();
							v = (Vector<ClassDTO>)session.getAttribute("allclass");
							Iterator it = v.iterator();
							ClassDTO s = null;
							while(it.hasNext()){
								s = (ClassDTO)it.next();
								if(s.getClassId().equals(ClassId)){
						 %>				
				<div class="baBody">
					<div class="bbD">班级编号：<input readOnly="true" name="ClassId" value=<%=s.getClassId() %> class="input3" /></div>
					<div class="bbD">专业编码：<input name="MajorId" value=<%=s.getMajorId() %> class="input3" /></div>
					<div class="bbD">班级名称：<input name="ClassName" value=<%=s.getClassName()%> class="input3" /></div>
					<div class="bbD">学生人数：<input name="StudentsNumber" value=<%=s.getStudentsNumber() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">确认修改</button>
							<a class="btn_ok btn_no" href="findAllClass">取消</a>
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