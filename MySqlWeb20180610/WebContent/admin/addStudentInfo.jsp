<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
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
        		if(form.StudentId.value==""){
        			alert("ѧ����Ų���Ϊ��");
        			form.StudentId.focus();
        			return false;
        		}
        		if(form.ClassId.value==""){
        			alert("�����༶����Ϊ��");
        			form.ClassId.focus();
        			return false;
        		}
        		if(form.StudentName.value==""){
        			alert("ѧ����������Ϊ��");
        			form.StudentName.focus();
        			return false;
        		}
        		if(form.StudentSex.value==""){
        			alert("ѧ���Ա���Ϊ��");
        			form.StudentSex.focus();
        			return false;
        		}
        		if(form.StudentAge.value==""){
        			alert("ѧ�����䲻��Ϊ��");
        			form.StudentAge.focus();
        			return false;
        		}
        		if(form.EntranceTime.value==""){
        			alert("��ѧʱ�䲻��Ϊ��");
        			form.EntranceTime.focus();
        			return false;
        		}
        		
        		if(form.StudentPassw.value==""){
        			alert("��¼���벻��Ϊ��");
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
				���ѧ����Ϣ
			</div>-->
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>����ѧ����Ϣ</span>
				</div>
				<form action="addStudentServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"��Ϊ������Ŀ</p>
					<div class="bbD">ѧ�����<span class="f_cB">&nbsp;*</span><input id="StudentId" name="StudentId" class="input3" /></div>
					<div class="bbD">�����༶<span class="f_cB">&nbsp;*</span><input id="ClassId" name="ClassId" class="input3" /></div>
					<div class="bbD">ѧ������<span class="f_cB">&nbsp;*</span><input id="StudentName" name="StudentName" class="input3" /></div>
					<div class="bbD">ѧ���Ա�<span class="f_cB">&nbsp;*</span><input id="StudentSex" name="StudentSex" class="input3" /></div>					
					<div class="bbD">ѧ������<span class="f_cB">&nbsp;*</span><input id="StudentAge" name="StudentAge" class="input3" /></div>
					<div class="bbD">��ѧʱ��<span class="f_cB">&nbsp;*</span><input id="EntranceTime" name="EntranceTime" class="input3" /></div>
					<div class="bbD">��¼����<span class="f_cB">&nbsp;*</span><input id="StudentPassw" name="StudentPassw" class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit" onClick="return check();">ȷ�����</button>
							<a class="btn_ok btn_no" href="addStudentInfo.jsp">ȡ��</a>
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