<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ClassDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>班级管理</title>
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
				location.href="deleteClassCheckServlet?arr="+arr
		}
		else
			alert("您至少选择一条记录进行删除");
			
	}
</script>
        <script>
        	function check(){
        		if(form.ClassId.value==""){
        			alert("班级编号不能为空");
        			form.ClassId.focus();
        			return false;
        		}
        		if(form.MajorId.value==""){
        			alert("专业编号不能为空");
        			form.MajorId.focus();
        			return false;
        		}
        		if(form.ClassName.value==""){
        			alert("班级名称不能为空");
        			form.ClassName.focus();
        			return false;
        		}
        		if(form.StudentsNumber.value==""){
        			alert("学生数量不能为空");
        			form.StudentsNumber.focus();
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
				<img src="img/coin02.png" />&nbsp;班级信息
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form action="addClassServlet" name="form">
						<div class="cfD">
							<input class="userinput" id="ClassId" name="ClassId" placeholder="输入班级编号" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="MajorId" name="MajorId" placeholder="输入专业编号" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="ClassName" name="ClassName" placeholder="输入班级名称" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="StudentsNumber" name="StudentsNumber" placeholder="输入学生人数" />
							<button class="userbtn" type="submit" onClick="return check();">添加新班级</button>
						</div>
					</form>
				</div>			
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120px" class="tdColor"></td>
							<td width="166px" class="tdColor tdC">班级编号</td>
							<td width="250px" class="tdColor">专业编号</td>
							<td width="250px" class="tdColor">班级名称</td>
							<td width="180px" class="tdColor">学生人数</td>
							<td width="170px" class="tdColor">操作</td>
						</tr>
                        <%
							Vector<ClassDTO> v = new Vector<ClassDTO>();
							v = (Vector<ClassDTO>)session.getAttribute("allclass");
							Iterator it = v.iterator();
							ClassDTO s = null;
							while(it.hasNext()){
								s = (ClassDTO)it.next();		
						 %> 						
						<tr height="40px">
							<td><input type="checkbox" name="check" value=<%=s.getClassId()%> ></td>
							<td><%=s.getClassId()%></td>
							<td><%=s.getMajorId()%></td>
							<td><%=s.getClassName()%></td>
							<td><%=s.getStudentsNumber()%></td>
							<td><a href="updateClassInfo.jsp?ClassId=<%=s.getClassId()%>"><img class="operation" src="img/update.png"></a> 
							    <a href="deleteClassServlet?ClassId=<%=s.getClassId()%>"><img src="img/delete.png"></a>								
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