<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸�ѧ����Ϣ</title>
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
        <script>
        	function check(){
        		if(form.TeacherId.value==""){
        			alert("��ʦ��Ų���Ϊ��");
        			form.TeacherId.focus();
        			return false;
        		}
        		if(form.DeptId.value==""){
        			alert("����Ժϵ����Ϊ��");
        			form.DeptId.focus();
        			return false;
        		}
        		if(form.TeacherName.value==""){
        			alert("��ʦ���Ʋ���Ϊ��");
        			form.TeacherName.focus();
        			return false;
        		}
        		if(form.TeacherSex.value==""){
        			alert("��ʦ�Ա���Ϊ��");
        			form.TeacherSex.focus();
        			return false;
        		}
        		if(form.TeacherTitle.value==""){
        			alert("��ʦְ�Ʋ���Ϊ��");
        			form.TeacherTitle.focus();
        			return false;
        		}
        		if(form.TeacherPassw.value==""){
        			alert("��¼���벻��Ϊ��");
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
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllStudent">��ʦ����</a>&nbsp;-</span>&nbsp;��ӽ�ʦ��Ϣ
			</div>-->
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�����ʦ��Ϣ</span>
				</div>
				<form action="addTeacherServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"��Ϊ������Ŀ</p>
					<div class="bbD">��ʦ���<span class="f_cB">&nbsp;*</span><input id="TeacherId" name="TeacherId" class="input3" /></div>
					<div class="bbD">����Ժϵ<span class="f_cB">&nbsp;*</span><input id="DeptId" name="DeptId" class="input3" /></div>
					<div class="bbD">��ʦ����<span class="f_cB">&nbsp;*</span><input id="TeacherName" name="TeacherName" class="input3" /></div>
					<div class="bbD">��ʦ�Ա�<span class="f_cB">&nbsp;*</span><input id="TeacherSex" name="TeacherSex" class="input3" /></div>										
					<div class="bbD">��ʦְ��<span class="f_cB">&nbsp;*</span><input id="TeacherTitle" name="TeacherTitle" class="input3" /></div>
					<div class="bbD">��¼����<span class="f_cB">&nbsp;*</span><input id="TeacherPassw" name="TeacherPassw" class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit" onClick="return check();">ȷ�����</button>
							<a class="btn_ok btn_no" href="addTeacherInfo.jsp">ȡ��</a>
						</p>
					</div>
				</div>			
				</form>
			</div>

			<!-- ��Աע��ҳ����ʽend -->
		</div>
	</div>
</body>
</html>