<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ManagersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>教师管理</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;-</span>&nbsp;个人信息
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="166px" class="tdColor tdC">管理员编号</td>
							<td width="194px" class="tdColor">管理员姓名</td>
							<td width="166px" class="tdColor">管理员性别</td>
							<td width="186px" class="tdColor">联系电话</td>
							<td width="580px" class="tdColor">办公地址</td>
							<td width="300px" class="tdColor">登录密码</td>
							<td width="150px" class="tdColor">修改</td>
						</tr>
                        <%
							Vector<ManagersDTO> v = new Vector<ManagersDTO>();
							v = (Vector<ManagersDTO>)session.getAttribute("myself");
							Iterator it = v.iterator();
							ManagersDTO s = (ManagersDTO)it.next();	
						 %> 						
						<tr height="40px">
							<td><%=s.getManagerId()%></td>
							<td><%=s.getManagerName()%></td>
							<td><%=s.getManagerSex()%></td>
							<td><%=s.getManagerTel()%></td>
							<td><%=s.getManagerAddr()%></td>
							<td><%=s.getManagerPassw()%></td>
							<td><a href="updateMyself.jsp?ManagerId=<%=s.getManagerId()%>"><img class="operation" src="img/update.png"></a></td>
						</tr>						
					</table>                                                                            
				</div>
				<!-- user 表格 显示 end-->
			</div>
			<!-- user页面样式end -->
		</div>

	</div>

</body>
</html>