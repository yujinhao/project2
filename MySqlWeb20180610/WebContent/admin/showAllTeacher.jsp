<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachersDTO"%>
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
				location.href="deleteTeacherCheckServlet?arr="+arr
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
				<img src="img/coin02.png" />&nbsp;��ʦ��Ϣ
			</div>
		</div>

		<div class="page">
			<!-- userҳ����ʽ -->
			<div class="connoisseur">
				<!-- user ���� ��ʾ -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="100px" class="tdColor"></td>
							<td width="166px" class="tdColor tdC">��ʦ���</td>
							<td width="176px" class="tdColor">����Ժϵ</td>
							<td width="186px" class="tdColor">��ʦ����</td>
							<td width="166px" class="tdColor">��ʦ�Ա�</td>
							<td width="166px" class="tdColor">��ʦְ��</td>
							<td width="300px" class="tdColor">��¼����</td>
							<td width="150px" class="tdColor">����</td>
						</tr>
                        <%
							Vector<TeachersDTO> v = new Vector<TeachersDTO>();
							v = (Vector<TeachersDTO>)session.getAttribute("allteacher");
							Iterator it = v.iterator();
							TeachersDTO s = null;
							while(it.hasNext()){
								s = (TeachersDTO)it.next();		
						 %> 						
						<tr height="40px">
							<td><input type="checkbox" name="check" value=<%=s.getTeacherId()%> ></td>
							<td><%=s.getTeacherId()%></td>
							<td><%=s.getDeptId()%></td>
							<td><%=s.getTeacherName()%></td>
							<td><%=s.getTeacherSex()%></td>
							<td><%=s.getTeacherTitle()%></td>
							<td><%=s.getTeacherPassw()%></td>
							<td><a href="updateTeacherInfo.jsp?TeacherId=<%=s.getTeacherId()%>"><img class="operation" src="img/update.png"></a> 
							    <a href="deleteTeacherServlet?TeacherId=<%=s.getTeacherId()%>"><img src="img/delete.png"></a>								
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
				<!-- user ���� ��ʾ end-->
			</div>
			<!-- userҳ����ʽend -->
		</div>

	</div>

</body>
</html>