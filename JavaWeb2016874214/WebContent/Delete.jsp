<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*" %>
<%@page import="cn.edu.lingnan.dto.Room" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除房间信息</title>
</head>
<body>

	<table width="834" border="0" cellpadding="0" cellspacing="0">
		<tr>
			
			
			<td width="27" height="30"></td>
			
		</tr>
	</table>	
	<jsp:useBean id="service" class="cn.edu.lingnan.service.RoomService" scope="session"/>
	<%
		List<Room> projectlist=service.fill();
		Iterator<Room> iterproject=projectlist.iterator();
	%>

	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			
		</tr>
		<tr>
			<td height="30" colspan="3">
			<form action="RoomServlet?action=delete2" method="post">	
			<table width="100%" border="1"
					align="center" cellpadding="0" cellspacing="0">
					<tr>
					    <td width="10%" align="center" bgcolor="#80C6FF" class="titletxt">选择</td>
				
						<td width="25%" height="30" align="center" bgcolor="#80C6FF"><span
							class="txt"><span class="titletxt">房间ID</span></span></td>
						<td width="30%" height="30" align="center" bgcolor="#80C6FF"
							class="titletxt">房间类型</td>
						<td width="35%" height="30" align="center" bgcolor="#80C6FF"
							class="titletxt">相关操作</td>
					</tr>
					<%
					List<Room> projectlist1=service.fill();
		            for(int i=0;i<projectlist1.size();i++){
		            	Room rm= (Room)projectlist1.get(i);
						
					%>
					<tr>
					    <td align="center"><input name="Id" width="15%"  bgcolor="#FFF5D7" type="checkbox" value="<%=rm.getRid()%>" /></td>
						<td width="25%" height="30" align="center" bgcolor="#FFF5D7"><span
							class="txt"><%=rm.getRid()%></span></td>
						<td width="30%" height="30" align="center" bgcolor="#FFF5D7"><span
							class="txt"><%=rm.getRtype()%></span></td>
						<td width="35%" height="30" align="center" bgcolor="#FFF5D7"><span
							class="txt">
							<a href="RoomServlet?action=delete3&id=<%=rm.getRid()%>">删除</a></span></td>
					</tr>
					<%	
					 }
					%>
				 <tr>
					<td width="10%" align="left" bgcolor="#80C6FF" class="titletxt" colspan="4">
					      <input type="submit" value=" 删除选择"/>     
					 </td>		
				</tr>
				</table>
				</form>	
			</td>
		</tr>
	</table>
</body>
</html>