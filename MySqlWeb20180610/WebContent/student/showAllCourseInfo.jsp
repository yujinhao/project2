<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�鿴�γ���Ϣ</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="js/jquery-1.10.1.min.js"></script>
<script src="js/side.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<!-- wrap_left -->

<!-- /wrap_left -->

<!-- picBox -->
<div class="picBox" onClick="switchSysBar()" id="switchPoint"></div>
<!-- /picBox -->



<!-- wrap_right -->
<div class="wrap_right">
<!-- Contents -->
<div id="Contents">
<script type="text/javascript">
$(function(){
$(".select").each(function(){
var s=$(this);
var z=parseInt(s.css("z-index"));
var dt=$(this).children("dt");
var dd=$(this).children("dd");
var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
dt.click(function(){dd.is(":hidden")?_show():_hide();});
dd.find("a").click(function(){dt.html($(this).html());_hide();});
$("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})

    function allCheck(){
    	var checkObj=document.getElementsByName("check");
    	for(var i=0;i<checkObj.length;i++){
    		checkObj[i].checked=true;
		}
    }
    function allnotCheck(){
    	var checkObj=document.getElementsByName("check");
    	for(var i=0;i<checkObj.length;i++){
    		checkObj[i].checked=false;
		}
    }
    function backCheck(){
    	var checkObj=document.getElementsByName("check");
    	for(var i=0;i<checkObj.length;i++){
    		if(checkObj[i].checked==true)
    		    checkObj[i].checked=false;
    		else
    			checkObj[i].checked=true;
		}
    }
    function deleteCheck(){
    	var checkObj=document.getElementsByName("check");
    	var CourseId=[];
    	var flag=false;
    	for(var i=0;i<checkObj.length;i++){
    		if(checkObj[i].checked==true){
    			CourseId.push(checkObj[i].value);
    			flag=true;
    		}   
    	}
    	if(flag==true){
    		
    		    location.href="studentChooseCourseServlet?CourseId="+CourseId;
    	}
    	else
    		alert("������ѡ��һ����¼����ɾ��");
    }
</script>

<!-- MainForm -->
<div id="MainForm">
<div class="form_boxB">
<h2>�γ���Ϣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="findStuRemainCourseServlet">ʣ��γ�</a></h2>
<table cellpadding="0" cellspacing="0">

<tr>
<th></th>
<th>�γ̱��</th>
<th>�γ�����</th>
<th>ѧ��</th>
<th>ѧʱ</th>
<th>�γ�����</th>
<th>�Ͽ�ʱ��</th>
<th>�Ͽεص�</th>
<th>����</th>
<th>����</th>
</tr>

      <%
	         Vector<CourseDTO> v=new Vector<CourseDTO>();
	         v = (Vector<CourseDTO>)session.getAttribute("course");//object�಻��ֱ�Ӹ�ֵ����Ҫ����ǿ����ת��
	         Iterator it =v.iterator();//����
	         CourseDTO d=null;
	         while(it.hasNext()){
	        	 d=(CourseDTO)it.next();//object�඼��Ҫת��
      %>  

<tr>
<td><input type="radio" name="check" value=<%=d.getCourseId()%>/></td>
<td><%=d.getCourseId()%></td>
<td><%=d.getCourseName() %></td>
<td><%=d.getCourseCredit() %></td>
<td><%=d.getCourseClass() %></td>
<td><%=d.getCourseDesc() %></td>
<td><%=d.getClassTime() %></td>
<td><%=d.getAddress() %></td>
<td><%=d.getVolume() %></td>
<td><%=d.getRemain() %></td>
</tr>
<%
	         }
%>
</table>
<!-- btn_box -->
<div class="btn_box floatR mag_l20">
   <input type="button" value="�ύ" onClick="deleteCheck();"/>
</div>

<h2>
      ѡ������б� 
</h2>
<table cellpadding="0" cellspacing="0">
<tr>
<th>ѧ��</th>
<th>ѧ��</th>
<th>ѧ�����</th>
<th>ѧ������</th>
<th>�γ̱��</th>
<th>�γ�����</th>
<th>ѧ��</th>
<th>ѧʱ</th>
<th>�γ�����</th>
<th>�Ͽ�ʱ��</th>
<th>�Ͽεص�</th>
<th></th>
</tr>
       <%
             
            Vector<ScoreDTO> v1=new Vector<ScoreDTO>();
            v1=(Vector<ScoreDTO>)session.getAttribute("stucourse");
            Iterator itt=v1.iterator();
            ScoreDTO scoredto=new ScoreDTO();
            while(itt.hasNext()){
            	scoredto=(ScoreDTO)itt.next();
            	if(scoredto.getSign()==1){      	
        %>
        <tr>
            <td ><%=scoredto.getSchool() %></td>
            <td ><%=scoredto.getSemester() %></td>
            <td ><%=scoredto.getStudentId() %></td>
            <td ><%=scoredto.getStudentName() %></td>
            <td ><%=scoredto.getCourseId() %></td>
            <td ><%=scoredto.getCourseName()%></td>
            <td><%=scoredto.getCourseCredit() %></td>
			<td><%=scoredto.getCourseClass() %></td>
			<td><%=scoredto.getCourseDesc() %></td>
			<td><%=scoredto.getClassTime() %></td>
			<td><%=scoredto.getAddress() %></td>
            <td>            
               <a href="studentRefundCourseServlet?CourseId=<%=scoredto.getCourseId() %>">��ѡ</a>
            </td>
        </tr>
        <%
            	}}
        %>       
</table>
</div>
</div>

</div>
</div>
</body>
</html>

