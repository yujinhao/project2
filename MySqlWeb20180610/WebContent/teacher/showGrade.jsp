<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ScoreDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="../css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="../css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="../js/jquery-1.10.1.min.js"></script>
<script src="../js/side.js" type="text/javascript"></script>
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
</script>

<!-- MainForm -->
<div id="MainForm">
<div class="form_boxB">
<h2>班级学生信息&nbsp;&nbsp;<a class="btn_ok btn_no" href="lookCourse">返回</a></h2>
<table cellpadding="0" cellspacing="0">
<tr>
<th>学生编号</th>
<th>学生姓名</th>
<th>课程编号</th>
<th>课程名称</th>
<th>成绩</th>
<th>绩点</th>
<th>录入成绩</th>
</tr>
       <%
            Vector<ScoreDTO> v=new Vector<ScoreDTO>();
            v=(Vector<ScoreDTO>)session.getAttribute("grade");
            Iterator it=v.iterator();
            ScoreDTO sdto=new ScoreDTO();
            while(it.hasNext()){
            	sdto=(ScoreDTO)it.next();
        %>
        <tr>
            <td ><%=sdto.getStudentId() %></td>
            <td ><%=sdto.getStudentName() %></td>
            <td ><%=sdto.getCourseId() %></td>
            <td ><%=sdto.getCourseName() %></td>
            <td ><%=sdto.getGrade() %></td>
            <td ><%=sdto.getGradePoint()%></td>
            <td><a href="updateGrade.jsp?StudentId=<%=sdto.getStudentId()%>&&CourseId=<%=sdto.getCourseId()%>"><img class="operation" src="img/update.png"></a></td>
        </tr>
        <%
            }
        %>       


</table>
<p class="msg"></p>
</div>
</div>
<!-- /MainForm -->
<!-- btn_box -->
<!-- /btn_box -->
</div>
<!-- /BtmMain -->
</div>
<!-- /Contents -->

<!-- /footer -->
<footer>
</footer>
<!-- /footer -->

</div>
<!-- /wrap_right -->
</body>
</html>