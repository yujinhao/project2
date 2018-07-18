<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.CourseDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>查看课程信息</title>
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
<header>
<!-- Header -->

<!-- /Header -->
</header>


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

function allcheck(){
    	var checkobj=document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		checkobj[i].checked=true;
    }
    function allnotcheck(){
    	var checkobj=document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		checkobj[i].checked=false;
    }
    function backcheck(){
    	var checkobj=document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
    		if(checkobj[i].checked==true)
    			checkobj[i].checked=false;
    		else
    			checkobj[i].checked=true;
    }
    function deletecheck(){
    	/*alert("bbb"); 验证 */
    	var checkobj=document.getElementsByName("check");
    	var arr=[];/* 定义为数组 */
    	var flag=false;
    	for(var i=0;i<checkobj.length;i++){
    		if(checkobj[i].checked==true){
    			arr.push(checkobj[i].value);
    			flag=true;
    		}
    	}
    	alert(arr);/* 验证  */
    	if(flag){
    		if(confirm("您确定要删除这些信息吗？"))
    			location.href="deleteCourseCheckServlet?arr="+arr;
    	}
    	else
    		alert("您至少选择一条信息，再进行删除")
    }


</script>

<!-- MainForm -->
<div id="MainForm">
<div class="form_boxB">
<h2>课程信息  <a href="findRemainCourseServlet">剩余课程</a></h2>
<table cellpadding="0" cellspacing="0">

<tr>
<th></th>
<th>课程编号</th>
<th>课程名称</th>
<th>学分</th>
<th>学时</th>
<th>课程性质</th>
<th>上课时间</th>
<th>上课地点</th>
<th>容量</th>
<th>余量</th>
<th>操作</th>
</tr>

      <%
	         Vector<CourseDTO> v=new Vector<CourseDTO>();
	         v = (Vector<CourseDTO>)session.getAttribute("allcourse");//object类不可直接赋值，需要进行强制性转换
	         Iterator it =v.iterator();//遍历
	         CourseDTO d=null;
	         while(it.hasNext()){
	        	 d=(CourseDTO)it.next();//object类都需要转换
      %>  

<tr>
<td><input type="checkbox" name="check" value=<%=d.getCourseId()%>></td>
<td><%=d.getCourseId()%></td>
<td><%=d.getCourseName() %></td>
<td><%=d.getCourseCredit() %></td>
<td><%=d.getCourseClass() %></td>
<td><%=d.getCourseDesc() %></td>
<td><%=d.getClassTime() %></td>
<td><%=d.getAddress() %></td>
<td><%=d.getVolume() %></td>
<td><%=d.getRemain() %></td>
<td><a href="updateCourse.jsp?CourseId=<%=d.getCourseId()%>"><img class="operation" src="img/update.png"></a> 
<a href="deleteCourseServlet?CourseId=<%=d.getCourseId()%>" class="removeUser"><img class="operation delban" src="img/delete.png"></a></td>
</tr>
<%
	         }
%>
</table>
</div>
</div>



<!-- btn_box -->
<div class="btn_box floatR mag_l20">
 <input type="button" id="btn1" value="全选" onClick="allcheck();"/>
   <input type="button" id="btn2" value="不选" onClick="allnotcheck();"/>
   <input type="button" id="btn3" value="反选" onClick="backcheck();"/>
   <input type="button" value="批量删除" onClick="deletecheck();"/>
</div>
<!-- /btn_box -->
</div>
<!-- /BtmMain -->
</div>
<!-- /Contents -->
</div>
<!-- /wrap_right -->
</body>
</html>

