<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MajorDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>专业管理</title>
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
				location.href="deleteMajorCheckServlet?arr="+arr
		}
		else
			alert("您至少选择一条记录进行删除");
			
	}
</script>
        <script>
        	function check(){
        		if(form.MajorId.value==""){
        			alert("专业编号不能为空");
        			form.MajorId.focus();
        			return false;
        		}
        		if(form.DeptId.value==""){
        			alert("院系编号不能为空");
        			form.DeptId.focus();
        			return false;
        		}
        		if(form.MajorName.value==""){
        			alert("专业名称不能为空");
        			form.MajorName.focus();
        			return false;
        		}
        		if(form.ClassNumber.value==""){
        			alert("班级数量不能为空");
        			form.ClassNumber.focus();
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
				<img src="img/coin02.png" />&nbsp;专业信息
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form action="addMajorServlet" name="form">
						<div class="cfD">
							<input class="userinput" id="MajorId" name="MajorId" placeholder="输入专业编号" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="DeptId" name="DeptId" placeholder="输入院系编号" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="MajorName" name="MajorName" placeholder="输入专业名称" />&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="ClassNumber" name="ClassNumber" placeholder="输入班级数量" />
							<button class="userbtn" type="submit" onClick="return check();">添加新专业</button>
						</div>
					</form>
				</div>			
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120px" class="tdColor"></td>
							<td width="166px" class="tdColor tdC">专业编号</td>
							<td width="250px" class="tdColor">院系编号</td>
							<td width="250px" class="tdColor">专业名称</td>
							<td width="180px" class="tdColor">班级数量</td>
							<td width="170px" class="tdColor">操作</td>
						</tr>
                        <%
							Vector<MajorDTO> v = new Vector<MajorDTO>();
							v = (Vector<MajorDTO>)session.getAttribute("allmajor");
							Iterator it = v.iterator();
							MajorDTO s = null;
							while(it.hasNext()){
								s = (MajorDTO)it.next();		
						 %> 						
						<tr height="40px">
							<td><input type="checkbox" name="check" value=<%=s.getMajorId()%> ></td>
							<td><%=s.getMajorId()%></td>
							<td><%=s.getDeptId()%></td>
							<td><%=s.getMajorName()%></td>
							<td><%=s.getClassNumber()%></td>
							<td><a href="updateMajorInfo.jsp?MajorId=<%=s.getMajorId()%>"><img class="operation" src="img/update.png"></a> 
							    <a href="deleteMajorServlet?MajorId=<%=s.getMajorId()%>"><img src="img/delete.png"></a>								
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