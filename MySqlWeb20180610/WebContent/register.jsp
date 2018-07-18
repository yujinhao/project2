<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/page.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
        <script>
        	function check(){
        		if(form.UserId.value==""){
        			alert("用户ID不能为空");
        			form.UserId.focus();
        			return false;
        		}
        		if(form.UserName.value==""){
        			alert("用户名不能为空");
        			form.UserName.focus();
        			return false;
        		}
        		if(form.UserPassw.value==""){
        			alert("用户密码不能为空");
        			form.UserPassw.focus();
        			return false;
        		}
        		
        		if(form.UserRoot.value==""){
        			alert("用户权限不能为空");
        			form.UserRoot.focus();
        			return false;
        		}
        		var regm2 = /^[1-3]?$/
        		if(!form.UserRoot.value.match(regm2)){
        			alert("用户权限输入不合法，请输入1或2或3");
        			form.UserRoot.focus();
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

	<!-- 登录body -->
	<div class="logDiv">
		<img class="logBanner" src="img/logBanner.png" />
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">注册</p>
			</div>
			<!-- 输入框 -->
			<form action="registerServlet" name="form">
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" id="UserId" name="UserId" class="UserId" placeholder="输入用户编号" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" id="UserName" name="UserName" class="UserName" placeholder="输入用户名" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logPwd.png" /><input type="password" id="UserPassw" name="UserPassw" class="UserPassw" placeholder="输入用户密码" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" id="UserRoot" name="UserRoot" class="UserRoot" placeholder="输入权限" />
			</div>
			<div class="logC">
				<a href="#" target="_self"><button type="submit" onClick="return check();">注 册</button></a>
			</div>
			</form>
			<div class="logC">
				<a href="index.html" target="_self"><button type="submit">登 录</button></a>
			</div>
		</div>
	</div>
	<!-- 登录body  end -->

	<!-- 登录页面底部 -->
	<div class="logFoot">
		<p class="p1"></p>
		<p class="p2"></p>
	</div>
	<!-- 登录页面底部end -->
   
</body>
</html>