<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachingDTO"%>
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
        		if(form.CourseId.value==""){
        			alert("�γ̱�Ų���Ϊ��");
        			form.CourseId.focus();
        			return false;
        		}
        		if(form.StudentsNumber.value==""){
        			alert("ѧ����������Ϊ��");
        			form.StudentsNumber.focus();
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
        	  function findTeacherIdCheck(){
        	      var request = createXmlHttpRequest();
        	      var TeacherId = document.all.TeacherId.value;
        	      request.open("put","findUserIdOrBookIdCheckServlet?userid="+userid);
        	      request.send();
        	      request.onreadystatechange = function(){
        	  	if(request.readyState==4){
        	  	        var value = request.responseText;
        	  	        if(value=="true"){
        		    		    alert("���û�ID�����ڣ�������������");
        	  	  		        form.userid.focus();
        	  	        }
        	      	}
        	      }
        	  } 
        	  function findCourseIdCheck(){
        	    var request = createXmlHttpRequest();
        	    var bookid = document.all.bookid.value;
        	    request.open("post","findUserIdOrBookIdCheckServlet?bookid="+bookid);
        	    request.send();
        	    request.onreadystatechange = function(){
        		if(request.readyState==4){
        		        var value = request.responseText;	        
        		        if(value=="true"){    
        	    		    alert("��ͼ��ID�����ڻ����鼮�Ѿ������꣬������������");
        		  		    form.bookid.focus();
        		        }
        	    	}
        	    }
        	  } 
      	
        </script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<!--  <div class="page">
				����ڿ������Ϣ
			</div>-->
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�����ڿ������Ϣ</span>
				</div>
				<form action="addTeachingServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"��Ϊ������Ŀ</p>
					<div class="bbD">��ʦ���<span class="f_cB">&nbsp;*</span><input id="TeacherId" name="TeacherId" class="input3" /></div>
					<div class="bbD">�γ̱��<span class="f_cB">&nbsp;*</span><input id="CourseId" name="CourseId" class="input3" /></div>
					<div class="bbD">ѧ������<span class="f_cB">&nbsp;*</span><input id="StudentsNumber" name="StudentsNumber" class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit" onClick="return check();">ȷ�����</button>
							<a class="btn_ok btn_no" href="addTeachingInfo.jsp">ȡ��</a>
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