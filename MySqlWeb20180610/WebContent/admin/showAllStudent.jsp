<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>学生管理</title>
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
			if(confirm("您确定要删除这些记录吗？"))
				location.href="deleteStudentCheckServlet?arr="+arr
		}
		else
			alert("您至少选择一条记录进行删除");
			
	}
</script>
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" />&nbsp;学生信息
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120px" class="tdColor"></td>
							<td width="166px" class="tdColor tdC">学生编号</td>
							<td width="176px" class="tdColor">所属班级</td>
							<td width="186px" class="tdColor">学生姓名</td>
							<td width="166px" class="tdColor">学生性别</td>
							<td width="166px" class="tdColor">学生年龄</td>
							<td width="580px" class="tdColor">入学时间</td>
							<td width="300px" class="tdColor">登录密码</td>
							<td width="150px" class="tdColor">操作</td>
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
							<div class="btn_box"><input  type="button" id="btn1" value="全选" onClick="allcheck();"/>
					                            <input  type="button" id="btn1" value="不选" onClick="allnotcheck();"/>
					                            <input  type="button" id="btn1" value="反选" onClick="backcheck();"/> 
					                            <input  type="button" value="批量删除" onClick="deletecheck();"/>
					       </div>                                                                               
				</div>
				<!-- user 表格 显示 end-->
			</div>
			<!-- user页面样式end -->
		</div>

	</div>

</body>
</html>