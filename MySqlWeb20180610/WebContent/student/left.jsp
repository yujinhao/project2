<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB2312">
     <meta http-equiv="Cache-Control" content="no-cache"/> 
<title>��ҳ��ർ��</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<body id="bg">
	<!-- ��߽ڵ� -->
	<div class="container">
      <%
          String UserId=(String)session.getAttribute("UserId");    	
       %>
		<div class="leftsidebar_box">
			<!--  <a href="student.html" target="main"><div class="line">
					<img src="img/coin01.png" />&nbsp;&nbsp;��ҳ
				</div></a>-->
				
				<!--�γ���Ϣ����-->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin03.png" /><img class="icon2"
						src="img/coin04.png" /> ѡ�λ����<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="findStuAllCourseServlet"
						target="main">ѡ�ογ���Ϣ</a><img class="icon5" src="img/coin21.png" />
				</dd>
				<!-- <dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="addCourseInfo.jsp"
						target="main">��ѡ�γ���Ϣ</a><img class="icon5" src="img/coin21.png" />
				</dd> -->
			</dl>
			
			
				
			<!--ѧ����Ϣ����-->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin07.png" /><img class="icon2"
						src="img/coin08.png" /> ��Ϣ��ѯ<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="findStuScoreServlet?StudentId=<%=UserId%>" target="main"
						class="cks">���˳ɼ���ѯ</a><img class="icon5" src="img/coin21.png" />
				</dd>
			   <dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="findStuCourseServlet?StudentId=<%=UserId%>" target="main"
						class="cks">ѡ�������ѯ</a><img class="icon5" src="img/coin21.png" />
				</dd> 
			</dl>
				
			<!--ϵͳ����-->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coinL1.png" /><img class="icon2"
						src="img/coinL2.png" /> ��Ϣά��<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="findStudentInfo?StudentId=<%=UserId%>"
						target="main" class="cks">������Ϣ</a><img class="icon5"
						src="img/coin21.png" />
				</dd>
<!-- 				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="UpdateStudentInfoServlet"
						target="main" class="cks">��Ϣ�޸�</a><img
						class="icon5" src="img/coin21.png" />
				</dd> -->
			</dl>

		</div>

	</div>
</body>
</html>
