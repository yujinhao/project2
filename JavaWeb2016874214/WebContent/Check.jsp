<%@ page language="java" contentType="text/html; charset=gb2312"	pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="cn.edu.lingnan.dto.Room"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查看房间信息</title>
</head>
<body>

	<table width="834" border="0" cellpadding="0" cellspacing="0">
		<tr>			
			
		</tr>
	</table>	
	<%
	Room room=(Room)request.getAttribute("room");
	if(room!=null){	  
	%>
	房间ID：<%=room.getRid() %><br />
	房间类型：<%=room.getRtype() %><br />
	有无早餐：<%=room.getBreakfirst() %><br /> 
	价格：<%=room.getPrice() %><br />
	
	<%
	}
	else
	{  
	%>
	<jsp:useBean id="service" class="cn.edu.lingnan.service.RoomService" scope="session"/>
	<%
		List<Room> projectlist=service.fill();
		Iterator<Room> iterproject=projectlist.iterator();
	%>
	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		
		<tr>
			<td height="30" colspan="3"><table width="100%" border="1"
					align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="30%" height="20" align="center" bgcolor="#80C6FF"><span
							class="txt"><span class="titletxt">房间ID</span></span></td>
						<td width="35%" height="20" align="center" bgcolor="#80C6FF"
							class="titletxt"> 房间类型</td>
						<td width="35%" height="20" align="center" bgcolor="#80C6FF"
							class="titletxt">相关操作</td>
					</tr>
					<%
					List<Room> projectlist1=service.fill();
		            for(int i=0;i<projectlist1.size();i++){
		            	Room r= (Room)projectlist1.get(i);
		            
					%>
					<tr>
						<td width= "30%" height="20" align="center" bgcolor="#FFF5D7"><span
							class="txt"><%=r.getRid()%></span></td>
						<td width="35%" height="20" align="center" bgcolor="#FFF5D7"><span
							class="txt"><%=r.getRtype()%></span></td>
						<td width="35%" height="20" align="center" bgcolor="#FFF5D7"><span
							class="txt">
							<a href="RoomServlet?id=<%=r.getRid()%>&action=list2">详细</a></span></td>
					</tr>
					<%
		            }
	}
		            %>
				</table></td>
		</tr>
	</table>
</body>
</html>