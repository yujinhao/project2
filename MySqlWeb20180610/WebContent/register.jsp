<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ע��</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/page.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
        <script>
        	function check(){
        		if(form.UserId.value==""){
        			alert("�û�ID����Ϊ��");
        			form.UserId.focus();
        			return false;
        		}
        		if(form.UserName.value==""){
        			alert("�û�������Ϊ��");
        			form.UserName.focus();
        			return false;
        		}
        		if(form.UserPassw.value==""){
        			alert("�û����벻��Ϊ��");
        			form.UserPassw.focus();
        			return false;
        		}
        		
        		if(form.UserRoot.value==""){
        			alert("�û�Ȩ�޲���Ϊ��");
        			form.UserRoot.focus();
        			return false;
        		}
        		var regm2 = /^[1-3]?$/
        		if(!form.UserRoot.value.match(regm2)){
        			alert("�û�Ȩ�����벻�Ϸ���������1��2��3");
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

	<!-- ��¼body -->
	<div class="logDiv">
		<img class="logBanner" src="img/logBanner.png" />
		<div class="logGet">
			<!-- ͷ����ʾ��Ϣ -->
			<div class="logD logDtip">
				<p class="p1">ע��</p>
			</div>
			<!-- ����� -->
			<form action="registerServlet" name="form">
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" id="UserId" name="UserId" class="UserId" placeholder="�����û����" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" id="UserName" name="UserName" class="UserName" placeholder="�����û���" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logPwd.png" /><input type="password" id="UserPassw" name="UserPassw" class="UserPassw" placeholder="�����û�����" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" id="UserRoot" name="UserRoot" class="UserRoot" placeholder="����Ȩ��" />
			</div>
			<div class="logC">
				<a href="#" target="_self"><button type="submit" onClick="return check();">ע ��</button></a>
			</div>
			</form>
			<div class="logC">
				<a href="index.html" target="_self"><button type="submit">�� ¼</button></a>
			</div>
		</div>
	</div>
	<!-- ��¼body  end -->

	<!-- ��¼ҳ��ײ� -->
	<div class="logFoot">
		<p class="p1"></p>
		<p class="p2"></p>
	</div>
	<!-- ��¼ҳ��ײ�end -->
   
</body>
</html>