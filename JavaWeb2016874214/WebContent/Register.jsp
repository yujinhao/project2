<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>«Î◊¢≤·</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
  
  </head>  
    
  </head>  
<style type="text/css">
*{
	padding:0 auto;
	margin:0 auto;
}
body{
	text-align:center;
}
#register{
	width:400px;
	height:400px;
	border:1px solid #ddd;
	border-radius:4px;
	margin-top:10px;
	box-shadow: 0 5px 15px rgba(0,0,0,.5);
}
#register h1{
	padding:10px;
	border-bottom:1px solid #ddd;
}
#register dl{
	padding:10px;
}
#register dl dd{
	padding:10px 0;
}
#register dl dd input{
	border-radius:4px;
	border:1px solid black;
	outline:none;
	width:150px;
	height:30px;
	line-height:20px;
	padding:0 10px;
}

#register dl dd button{
	width:80px;
	height:30px;
	line-height:20px;
	background:white;
	border-radius:4px;
	border:1px solid #996699;
	transition:all 0.4s;
}
#register dl dd button:hover{
	cursor:pointer;
	background:#996699;
	color:white;
}
</style>
  <body>  
  <center>  
    <div id="register">   
    <h1>ª∂”≠◊¢≤·</h1>  
    <form action="RegisterServlet" method="post">  
    <d1>
       <dd>«Î ‰»Î’À∫≈£∫<input type="text" name="uid" /></dd>
       
       <dd>«Î ‰»Î”√ªß√˚£∫<input type="text" name="uname" /> </dd>
       
       <dd>«Î ‰»Î√‹¬Î£∫<input type="password" name="psw" /></dd>
       <input type="submit" value="Ã·Ωª">  
       <dd><a href="Login.jsp"><font size="2"><i>∑µªÿµ«¬º</i></font></a> </dd>
       </d1>
    <font color="red" size="2"> ${msg }</font>  
    </form>  
   </div>  
    </center>  
  </body>  
</html>  