<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>修改学生信息</title>
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
        <script>
        	function check(){
        		if(form.TeacherId.value==""){
        			alert("教师编号不能为空");
        			form.TeacherId.focus();
        			return false;
        		}
        		if(form.DeptId.value==""){
        			alert("所属院系不能为空");
        			form.DeptId.focus();
        			return false;
        		}
        		if(form.TeacherName.value==""){
        			alert("教师名称不能为空");
        			form.TeacherName.focus();
        			return false;
        		}
        		if(form.TeacherSex.value==""){
        			alert("教师性别不能为空");
        			form.TeacherSex.focus();
        			return false;
        		}
        		if(form.TeacherTitle.value==""){
        			alert("教师职称不能为空");
        			form.TeacherTitle.focus();
        			return false;
        		}
        		if(form.TeacherPassw.value==""){
        			alert("登录密码不能为空");
        			form.TeacherPassw.focus();
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
			<!--<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="findAllStudent">教师管理</a>&nbsp;-</span>&nbsp;添加教师信息
			</div>-->
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>输入教师信息</span>
				</div>
				<form action="addTeacherServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"号为必填项目</p>
					<div class="bbD">教师编号<span class="f_cB">&nbsp;*</span><input id="TeacherId" name="TeacherId" class="input3" /></div>
					<div class="bbD">所属院系<span class="f_cB">&nbsp;*</span><input id="DeptId" name="DeptId" class="input3" /></div>
					<div class="bbD">教师名称<span class="f_cB">&nbsp;*</span><input id="TeacherName" name="TeacherName" class="input3" /></div>
					<div class="bbD">教师性别<span class="f_cB">&nbsp;*</span><input id="TeacherSex" name="TeacherSex" class="input3" /></div>										
					<div class="bbD">教师职称<span class="f_cB">&nbsp;*</span><input id="TeacherTitle" name="TeacherTitle" class="input3" /></div>
					<div class="bbD">登录密码<span class="f_cB">&nbsp;*</span><input id="TeacherPassw" name="TeacherPassw" class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit" onClick="return check();">确认添加</button>
							<a class="btn_ok btn_no" href="addTeacherInfo.jsp">取消</a>
						</p>
					</div>
				</div>			
				</form>
			</div>

			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
</html>