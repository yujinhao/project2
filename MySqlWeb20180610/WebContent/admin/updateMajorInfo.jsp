<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MajorDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改专业信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllMajor">专业管理</a>&nbsp;-</span>&nbsp;修改专业信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改专业信息</span>
				</div>
				<form action="updateMajorServlet">
                        <%
                        	String MajorId = request.getParameter("MajorId");
							Vector<MajorDTO> v = new Vector<MajorDTO>();
							v = (Vector<MajorDTO>)session.getAttribute("allmajor");
							Iterator it = v.iterator();
							MajorDTO s = null;
							while(it.hasNext()){
								s = (MajorDTO)it.next();
								if(s.getMajorId().equals(MajorId)){
						 %>				
				<div class="baBody">
					<div class="bbD">专业编号：<input readOnly="true" name="MajorId" value=<%=s.getMajorId() %> class="input3" /></div>
					<div class="bbD">院系编号：<input name="DeptId" value=<%=s.getDeptId() %> class="input3" /></div>
					<div class="bbD">专业名称：<input name="MajorName" value=<%=s.getMajorName() %> class="input3" /></div>
					<div class="bbD">班级数量：<input name="ClassNumber" value=<%=s.getClassNumber() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">确认修改</button>
							<a class="btn_ok btn_no" href="findAllMajor">取消</a>
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