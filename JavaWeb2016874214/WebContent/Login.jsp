<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����˽��ӰԺ</title>

<!-- For-Mobile-Apps-and-Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps-and-Meta-Tags -->

<link href="css3/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css3/jquerysctipttop.css" rel="stylesheet" type="text/css">
<style type="text/css">  
            #code  
            {  
                font-family:Arial;  
                font-style:italic;  
                font-weight:bold;  
                border:0;  
                letter-spacing:2px;  
                color:blue;  
            }  
        </style>  
</head>
<body>
<h1>����˽��ӰԺ</h1>
	<section>
		<div class="controls w3l">
			<div class="cbcontrol" id="cbControlRight"><</div>
			<div class="cbcontrol" id="cbControlLeft">></div>
			<div class="clear"></div>
		</div>
		<div class="stage">

			<div class="cbImage w3">
				<h3>����Ա��¼</h3>
				<form action="ALoginServlet" method="post">
					<input type="text" class="name" name="aname" placeholder="����Ա�˺�"
						required=""> 
						<input  
						type="password" class="password"  name="password" placeholder="����"  >

  <input type = "text" id = "input"/>  
            <input type = "button" id="code" onclick="createCode()"/>  
            <span onclick="createCode()">�������</span>


					<input type="submit"
						class="done" value="Done" onclick="validate()">
						
						<font color="red" size="3"> ${msg1 }</font> 
				</form>

			</div>
			<div class="cbImage active signin agileits">
				<h3>�û���¼</h3>
				<form action="LoginServlet" method="post">
					<input type="text" name="uname" class="name" placeholder="�û���"
						required=""> 
						<input type="password" name="password"
						class="password" placeholder="����" required=""> <input
						type="submit" value="Sign In">

<font color="red" size="3"> ${msg2 }</font> 

					<ul class="bottom">

				<li><a href="#" class="forgot">��������?</a></li>
				<li><a href="#" class="terms">��ϵ����</a></li>
			
					</ul>
				</form>
			</div>
			<div class="cbImage agileinfo">
				<h3>���û�ע��</h3>
				<form action="RegisterServlet" method="post">
			<input type="text"  name="uid" placeholder="���������˺�" required="">
			<input type="text" name="uname"  class="name" placeholder="���û���" required=""> 
			<input type="password" class="password" name="psw" placeholder="������"	required=""> 
						
						
						
						<input type="submit" value="Sign Up">
						<font color="red"  size="3"> ${msg3 }</font> 
				</form>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		<div class="footer">
			<p>&copy; 2018 All Rights Reserved | by ��</p>
		</div>
	</section>
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="coverflow-slideshow.js"></script>
	<script src="js/checkCode.js"></script>
	<div style="text-align: center;">
		<p>
			<a href="" target="_blank"></a>
		</p>
	</div>
	
</body>
</html>