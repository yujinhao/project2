<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>ѧ������</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
<script>
	function allcheck(){
		var checkObj = document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			checkObj[i].checked = true;
	}
	function allnotcheck(){
		var checkObj = document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			checkObj[i].checked = false;
	}
	function backcheck(){
		var checkObj = document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			if(checkObj[i].checked == true)
				checkObj[i].checked = false;
			else
				checkObj[i].checked = true;
	}
	function deletecheck(){
		var checkObj = document.getElementsByName("check");
		var arr = [];
		var flag = false;
		for(var i=0; i<checkObj.length; i++){
			if(checkObj[i].checked == true)
				arr.push(checkObj[i].value);
			flag = true;
		}
		if(flag=true){
			if(confirm("��ȷ��Ҫɾ����Щ��¼��"))
				location.href="deleteStudentCheckServlet?arr="+arr
		}
		else
			alert("������ѡ��һ����¼����ɾ��");
			
	}
</script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" />&nbsp;ѧ����Ϣ
			</div>
		</div>

		<div class="page">
			<!-- userҳ����ʽ -->
			<div class="connoisseur">
				<!-- user ��� ��ʾ -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120px" class="tdColor"></td>
							<td width="166px" class="tdColor tdC">ѧ�����</td>
							<td width="176px" class="tdColor">�����༶</td>
							<td width="186px" class="tdColor">ѧ������</td>
							<td width="166px" class="tdColor">ѧ���Ա�</td>
							<td width="166px" class="tdColor">ѧ������</td>
							<td width="580px" class="tdColor">��ѧʱ��</td>
							<td width="300px" class="tdColor">��¼����</td>
							<td width="150px" class="tdColor">����</td>
						</tr>
                        <%
							Vector<StudentsDTO> v = new Vector<StudentsDTO>();
							v = (Vector<StudentsDTO>)session.getAttribute("allstudent");
							Iterator it = v.iterator();
							StudentsDTO s = null;
							while(it.hasNext()){
								s = (StudentsDTO)it.next();		
						 %> 						
						<tr height="40px">
							<td><input type="checkbox" name="check" value=<%=s.getStudentId()%> ></td>
							<td><%=s.getStudentId()%></td>
							<td><%=s.getClassId()%></td>
							<td><%=s.getStudentName()%></td>
							<td><%=s.getStudentSex()%></td>
							<td><%=s.getStudentAge()%></td>
							<td><%=s.getEntranceTime()%></td>
							<td><%=s.getStudentPassw()%></td>
							<td><a href="updateStudentInfo.jsp?StudentId=<%=s.getStudentId()%>"><img class="operation" src="img/update.png"></a> 
							    <a href="deleteStudentServlet?StudentId=<%=s.getStudentId()%>"><img src="img/delete.png"></a>								
							</td>
						</tr>
                         <%
								}
						%>						
					</table><br />
							<div class="btn_box"><input  type="button" id="btn1" value="ȫѡ" onClick="allcheck();"/>
					                            <input  type="button" id="btn1" value="��ѡ" onClick="allnotcheck();"/>
					                            <input  type="button" id="btn1" value="��ѡ" onClick="backcheck();"/> 
					                            <input  type="button" value="����ɾ��" onClick="deletecheck();"/>
					       </div>                                                                               
				</div>
				<!-- user ��� ��ʾ end-->
			</div>
			<!-- userҳ����ʽend -->
		</div>

	</div>

</body>
</html>