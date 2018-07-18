<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.DeptDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>院系管理</title>
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
				location.href="deleteDeptCheckServlet?arr="+arr
		}
		else
			alert("您至少选择一条记录进行删除");
			
	}
</script>
        <script>
        	function check(){
        		if(form.DeptId.value==""){
        			alert("院系编号不能为空");
        			form.DeptId.focus();
        			return false;
        		}
        		if(form.DeptName.value==""){
        			alert("院系名称不能为空");
        			form.DeptName.focus();
        			return false;
        		}
        		if(form.DeptChairman.value==""){
        			alert("院系主任不能为空");
        			form.DeptChairman.focus();
        			return false;
        		}
        		if(form.DeptTel.value==""){
        			alert("联系方式不能为空");
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
				<img src="img/coin02.png" />&nbsp;院系信息
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form action="addDeptServlet" name="form">
						<div class="cfD">
							<input class="userinput" id="DeptId" name="DeptId" placeholder="输入院系编号" />&nbsp;&nbsp;-&nbsp;&nbsp;
							<input class="userinput" id="DeptName" name="DeptName" placeholder="输入院系名称" />&nbsp;&nbsp;-&nbsp;&nbsp;
							<input class="userinput" id="DeptChairman" name="DeptChairman" placeholder="输入院系主任" />&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
							<input class="userinput" id="DeptTel" name="DeptTel" placeholder="输入联系方式" />
							<button class="userbtn" type="submit" onClick="return check();">添加院系</button>
						</div>
					</form>
				</div>			
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120px" class="tdColor"></td>
							<td width="166px" class="tdColor tdC">院系编号</td>
							<td width="250px" class="tdColor">院系名称</td>
							<td width="250px" class="tdColor">院系主任</td>
							<td width="180px" class="tdColor">联系方式</td>
							<td width="170px" class="tdColor">操作</td>
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