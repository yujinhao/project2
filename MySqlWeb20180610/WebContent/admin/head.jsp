<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>头部</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<body>
<%			
    String UserName = (String) session.getAttribute("UserName");            											
%>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<img class="headLogo" src="img/logLOGO.png"/>
		</div>
		<div class="headR">
			<span style="color:#FFF">欢迎：<%=UserName%></span><a href="../logoutServlet" rel="external">【退出】</a></span> 
		</div>
	</div>
</body>
</html>