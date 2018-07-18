<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  

  <head>  
    <base href="<%=basePath%>">  
      
    <title>请登录</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
    
  </head>  
<style type="text/css">
*{
	padding:0 auto;
	margin:0 auto;
}
body{
	text-align:center;
}
#login{
	width:400px;
	height:400px;
	border:1px solid #ddd;
	border-radius:4px;
	margin-top:10px;
	box-shadow: 0 5px 15px rgba(0,0,0,.5);
}
#login h1{
	padding:10px;
	border-bottom:1px solid #ddd;
}
#login dl{
	padding:10px;
}
#login dl dd{
	padding:10px 0;
}
#login dl dd input{
	border-radius:4px;
	border:1px solid black;
	outline:none;
	width:150px;
	height:30px;
	line-height:20px;
	padding:0 10px;
}
#login #yzm{
	padding:10px 40px 10px 0;
}
#login #yzm input{
	width:100px;
}
#login dl dd button{
	width:80px;
	height:30px;
	line-height:20px;
	background:white;
	border-radius:4px;
	border:1px solid #996699;
	transition:all 0.4s;
}
#login dl dd button:hover{
	cursor:pointer;
	background:#996699;
	color:white;
}
</style>
  <body background-color = lightpink >
    
<div id="login">  
<h1>欢迎登陆</h1>  
<form action="ALoginServlet" method="post">  
   
   <dl>
   		<dd>帐号 : <input type="text" name="aname" value="${aname }" /> </dd>
   
    	<dd>密码 : <input type="password" name="password" /></dd>
 
  		
  		<dd><button type="submit">登录</button></dd>
        <dd><a href="Login.jsp"><font size="2"><i>切换至普通用户登录界面</i></font></a> </dd>
   </dl>
<font color="red" size="2"> ${msg }</font>  
	 </form> 
</div>  

  </body>  
</html>  
