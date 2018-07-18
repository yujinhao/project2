<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ScoreDTO"%>
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
        		if(form.CourseId.value==""){
        			alert("课程编号不能为空");
        			form.CourseId.focus();
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
        		    		    alert("该用户ID不存在，请您重新输入");
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
        	    		    alert("该图书ID不存在或者书籍已经借阅完，请您重新输入");
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
			<!--<div class="page">
				添加选课情况信息
			</div>-->
		</div>
		<div class="page ">
			<!-- 会员注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>输入选课情况信息</span>
				</div>
				<form action="addScoreServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"号为必填项目</p>
					<div class="bbD">学生编号<span class="f_cB">&nbsp;*</span><input id="StudentId" name="StudentId" class="input3" /></div>
					<div class="bbD">课程编号<span class="f_cB">&nbsp;*</span><input id="CourseId" name="CourseId" class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit" onClick="return check();">确认添加</button>
							<a class="btn_ok btn_no" href="addScoreInfo.jsp">取消</a>
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