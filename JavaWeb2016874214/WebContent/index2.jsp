
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html>
<html>
<head>
<title>闲余私人影院</title>
<link href="css2/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="keywords" content="App Sign in Form,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements"./>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</script>
<!--webfonts-->
<link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
	<h1>私人预约</h1>
		<div class="app-cam">
			<div class="cam"><img src="images2/cam.png" class="img-responsive" alt="" /></div>
			<form action="LoginServlet" method="post">
				<input type="text" name="uname"  class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
				<input type="password" name="password" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
				
				
				
				
     
 <input  type="text" name="checkCode"/>
    <img alt="验证码" id="imagecode" src="<%= request.getContextPath()%>/servlet/ImageServlet"/>
    <a href="javascript:reloadCode();">看不清楚</a><br>
  
    
				
				
				<div class="submit"><input type="submit" onclick="myFunction()" value="Sign in" ></div>
				<div class="clear"></div>
				<div class="buttons">
			  <div id="font">  <font color="red" size="5"> ${msg }</font>  </div>
					<ul>
						<li><a href="Register.jsp" class="hvr-sweep-to-right">没有账号？请注册</a></li>
						<li><a href="AdminLogin2.jsp" class="hvr-sweep-to-left">管理员登录</a></li>						
					</ul>
				</div>
			
			
			</form>
		</div>
	<!--start-copyright-->
   		
	<!--//end-copyright-->
</body>
</html>