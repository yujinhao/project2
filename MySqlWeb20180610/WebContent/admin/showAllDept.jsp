<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.DeptDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>Ժϵ����</title>
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
				location.href="deleteDeptCheckServlet?arr="+arr
		}
		else
			alert("������ѡ��һ����¼����ɾ��");
			
	}
</script>
        <script>
        	function check(){
        		if(form.DeptId.value==""){
        			alert("Ժϵ��Ų���Ϊ��");
        			form.DeptId.focus();
        			return false;
        		}
        		if(form.DeptName.value==""){
        			alert("Ժϵ���Ʋ���Ϊ��");
        			form.DeptName.focus();
        			return false;
        		}
        		if(form.DeptChairman.value==""){
        			alert("Ժϵ���β���Ϊ��");
        			form.DeptChairman.focus();
        			return false;
        		}
        		if(form.DeptTel.value==""){
        			alert("��ϵ��ʽ����Ϊ��");
        			form.DeptTel.focus();
        			return false;
        		}
        	}
        	
        	function createXmlHttpRequest(){
        	    var xmlreq = false;
        	    if (window.XMLHttpRequest){
        	        xmlreq = new XMLHttpRequest();
        	    }else
        	        if (window.ActiveXObject){
        	    	try{
        	    	    xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
        	    	}catch(e1){
        	    	    try{
        	    	        xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
        	    	    }catch(e2){
        	    	    }
        	    	}
        	    }
        	    return xmlreq;   	
        	    }
      	
        </script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" />&nbsp;Ժϵ��Ϣ
			</div>
		</div>

		<div class="page">
			<!-- userҳ����ʽ -->
			<div class="connoisseur">
				<div class="conform">
					<form action="addDeptServlet" name="form">
						<div class="cfD">
							<input class="userinput" id="DeptId" name="DeptId" placeholder="����Ժϵ���" />&nbsp;&nbsp;-&nbsp;&nbsp;
							<input class="userinput" id="DeptName" name="DeptName" placeholder="����Ժϵ����" />&nbsp;&nbsp;-&nbsp;&nbsp;
							<input class="userinput" id="DeptChairman" name="DeptChairman" placeholder="����Ժϵ����" />&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="DeptTel" name="DeptTel" placeholder="������ϵ��ʽ" />
							<button class="userbtn" type="submit" onClick="return check();">���Ժϵ</button>
						</div>
					</form>
				</div>			
				<!-- user ��� ��ʾ -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120px" class="tdColor"></td>
							<td width="166px" class="tdColor tdC">Ժϵ���</td>
							<td width="250px" class="tdColor">Ժϵ����</td>
							<td width="250px" class="tdColor">Ժϵ����</td>
							<td width="180px" class="tdColor">��ϵ��ʽ</td>
							<td width="170px" class="tdColor">����</td>
						</tr>
                        <%
							Vector<DeptDTO> v = new Vector<DeptDTO>();
							v = (Vector<DeptDTO>)session.getAttribute("alldept");
							Iterator it = v.iterator();
							DeptDTO s = null;
							while(it.hasNext()){
								s = (DeptDTO)it.next();		
						 %> 						
						<tr height="40px">
							<td><input type="checkbox" name="check" value=<%=s.getDeptId()%> ></td>
							<td><%=s.getDeptId()%></td>
							<td><%=s.getDeptName()%></td>
							<td><%=s.getDeptChairman()%></td>
							<td><%=s.getDeptTel()%></td>
							<td><a href="updateDeptInfo.jsp?DeptId=<%=s.getDeptId()%>"><img class="operation" src="img/update.png"></a> 
							    <a href="deleteDeptServlet?DeptId=<%=s.getDeptId()%>"><img src="img/delete.png"></a>								
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