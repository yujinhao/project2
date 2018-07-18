<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
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
        		if(form.StudentId.value==""){
        			alert("学生编号不能为空");
        			form.StudentId.focus();
        			return false;
        		}
        		if(form.ClassId.value==""){
        			alert("所属班级不能为空");
        			form.ClassId.focus();
        			return false;
        		}
        		if(form.StudentName.value==""){
        			alert("学生姓名不能为空");
        			form.StudentName.focus();
        			return false;
        		}
        		if(form.StudentSex.value==""){
        			alert("学生性别不能为空");
        			form.StudentSex.focus();
        			return false;
        		}
        		if(form.StudentAge.value==""){
        			alert("学生年龄不能为空");
        			form.StudentAge.focus();
        			return false;
        		}
        		if(form.EntranceTime.value==""){
        			alert("入学时间不能为空");
        			form.EntranceTime.focus();
        			return false;
        		}
        		
        		if(form.StudentPassw.value==""){
        			alert("登录密码不能为空");
        			form.StudentPassw.focus();
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
				添加学生信息
			</div>-->
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>输入学生信息</span>
				</div>
				<form action="addStudentServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"号为必填项目</p>
					<div class="bbD">学生编号<span class="f_cB">&nbsp;*</span><input id="StudentId" name="StudentId" class="input3" /></div>
					<div class="bbD">所属班级<span class="f_cB">&nbsp;*</span><input id="ClassId" name="ClassId" class="input3" /></div>
					<div class="bbD">学生姓名<span class="f_cB">&nbsp;*</span><input id="StudentName" name="StudentName" class="input3" /></div>
					<div class="bbD">学生性别<span class="f_cB">&nbsp;*</span><input id="StudentSex" name="StudentSex" class="input3" /></div>					
					<div class="bbD">学生年龄<span class="f_cB">&nbsp;*</span><input id="StudentAge" name="StudentAge" class="input3" /></div>
					<div class="bbD">入学时间<span class="f_cB">&nbsp;*</span><input id="EntranceTime" name="EntranceTime" class="input3" /></div>
					<div class="bbD">登录密码<span class="f_cB">&nbsp;*</span><input id="StudentPassw" name="StudentPassw" class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit" onClick="return check();">确认添加</button>
							<a class="btn_ok btn_no" href="addStudentInfo.jsp">取消</a>
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