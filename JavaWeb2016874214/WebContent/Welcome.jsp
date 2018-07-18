<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>环球酒店</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>
<body >
<div >
<table width="900" height="20" border="0" align="center">
  <tr>
    <td colspan="2"></td>
  </tr>
  <tr>
    <td width="170" valign="top" bgcolor="#FFFFCC" align="center"><ul>
      <li><a href="Add.jsp" target="content">添加房间信息</a></li>
      <li><a href="RoomServlet?action=list" target="content">查询房间信息</a></li>
      <li><a href="Change.jsp" target="content">编辑房间信息</a></li>
      <li><a href="RoomServlet?action=delete" target="content">删除房间信息</a></li>
      <li><a href="Booking.jsp" target="content">查看订单信息</a></li>
    </ul>
    </td>
    <td width="730" valign="top">
     <iframe frameborder="0" name="content" width="100%" height="590" scrolling="auto">
     <marquee>欢迎管理员进入</marquee>
     </iframe>
    </td>
  </tr>
</table>
 
  </div>
</body>
</html>