<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ManagersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>��ʦ����</title>
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
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;-</span>&nbsp;������Ϣ
			</div>
		</div>

		<div class="page">
			<!-- userҳ����ʽ -->
			<div class="connoisseur">
				<!-- user ��� ��ʾ -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="166px" class="tdColor tdC">����Ա���</td>
							<td width="194px" class="tdColor">����Ա����</td>
							<td width="166px" class="tdColor">����Ա�Ա�</td>
							<td width="186px" class="tdColor">��ϵ�绰</td>
							<td width="580px" class="tdColor">�칫��ַ</td>
							<td width="300px" class="tdColor">��¼����</td>
							<td width="150px" class="tdColor">�޸�</td>
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
				<!-- user ��� ��ʾ end-->
			</div>
			<!-- userҳ����ʽend -->
		</div>

	</div>

</body>
</html>