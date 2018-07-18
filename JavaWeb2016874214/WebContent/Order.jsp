<%@ page language="java" contentType="text/html; charset=gb2312"	pageEncoding="gb2312"%>
<%@page import="java.util.*"%>
<%@page import="cn.edu.lingnan.dto.Room"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>预订房间</title>
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
<table width="100%" height="30" align="center" cellpadding="0" cellspacing="0" >
 <tr>
 <td height="30" align="center"><form id="form1" name="form1" method="post" action="RoomServlet&action=update2">
 <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bgcolor="E7E7E7">
 <tr>
 <td width="24%" height="30" align="right" class="txt"><span class="txt">房间ID</span></td>
 <td height="30" align="left" ><label for="textfield"></label>
 <input type="text" name="rid" id="rid" value=<%=room.getRid()%> disabled/>
  <input type="hidden" name="rid" id="rid" value=<%=room.getRid()%> /><span class="txt">*</span></td>
  </tr>
  

   <tr>
 <td width="24%" height="30" align="right" class="txt"><span class="txt"> 房间类型</span></td>
 <td height="30" align="left" >
 <input  height="20" width="400" type="text" name="rtype" id="rtype" value=<%=room.getRtype()%>/>  <span class="txtred">*</span></td>
  </tr>
     
   <tr>
 <td  height="30" align="right" class="txt">有无早餐</td>
 <td height="30" align="left" >
 <input  height="20" width="150" type="text" name="breakfirst" id="breakfirst" value=<%=room.getBreakfirst()%>/>  </td>
  </tr>
  <tr>
 <td  height="30" align="right" class="txt">价格</td>
 <td height="30" align="left" >
 <input  height="20" width="200" type="text" name="price" id="price" value=<%=room.getPrice()%>/>  </td>
  </tr>

  
  </table>
  
<p>
 <input type="submit" name="button" id="button" value="确定"/>
</p>
</form>
<p>&nbsp;</p></td>
</tr>
</table>
<% }else{%>
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
		            	Room rm= (Room)projectlist1.get(i);
					%>
					<tr>
						<td width="30%" height="20" align="center" bgcolor="#FFF5D7"><span
							class="txt"><%=rm.getRid()%></span></td>
						<td width="35%" height="20" align="center" bgcolor="#FFF5D7"><span
							class="txt"><%=rm.getRtype()%></span></td>
						<td width="35%" height="20" align="center" bgcolor="#FFF5D7"><span
							class="txt">
							<a href="RoomServlet?id=<%=rm.getRid()%>&action=update2">【预订】</a></span></td>
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