<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ManagersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改个人信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">管理</a>&nbsp;-</span>&nbsp;修改个人信息
			</div>
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>修改个人信息</span>
				</div>
				<form action="updateMyself">
                        <%
                        	String ManagerId = (String) session.getAttribute("UserId");
							Vector<ManagersDTO> v = new Vector<ManagersDTO>();
							v = (Vector<ManagersDTO>)session.getAttribute("myself");
							Iterator it = v.iterator();
							ManagersDTO s = null;
							while(it.hasNext()){
								s = (ManagersDTO)it.next();
								if(s.getManagerId().equals(ManagerId)){
						 %>				
				<div class="baBody">
					<div class="bbD">管理员编号：<input readOnly="true" name="ManagerId" value=<%=s.getManagerId() %> class="input3" />&nbsp;&nbsp;联系电话：<input name="ManagerTel" value=<%=s.getManagerTel() %> class="input3" /></div>
					<div class="bbD">管理员姓名：<input name="ManagerName" value=<%=s.getManagerName() %> class="input3" />&nbsp;&nbsp;办公地址：<input name="ManagerAddr" value=<%=s.getManagerAddr() %> class="input3" /></div>
					<div class="bbD">管理员性别：<input name="ManagerSex" value=<%=s.getManagerSex() %> class="input3" />&nbsp;&nbsp;登录密码：<input name="ManagerPassw" value=<%=s.getManagerPassw() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">确认修改</button>
							<a class="btn_ok btn_no" href="findMyself">取消</a>
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