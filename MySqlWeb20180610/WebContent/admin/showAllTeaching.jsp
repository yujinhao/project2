<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TeachingDTO"%>
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
    	var checkobj=document.getElementsByName("check");
    	var arr=[];
    	var flag=false;
    	for(var i=0;i<checkobj.length;i++){
    		if(checkobj[i].checked==true){
    			arr.push(checkobj[i].value);
    			flag=true;
    		}
    	}
    	if(flag){
    		if(confirm("您确定要删除这些信息吗？"))
    			location.href="deleteTeachingCheckServlet?arr="+arr;
    	}
    	else
    		alert("您至少选择一条信息，再进行删除")
    }
</script>

<!-- MainForm -->
<div id="MainForm">
<div class="form_boxB">
<h2>授课情况列表</h2>
<table cellpadding="0" cellspacing="0">
<tr>
<th></th>
<th>老师编号</th>
<th>老师姓名</th>
<th>课程编号</th>
<th>课程名</th>
<th>课程性质</th>
<th>上课时间</th>
<th>上课地点</th>
<th>学生人数</th>
<th>操作</th>
</tr>
       <%
            Vector<TeachingDTO> v=new Vector<TeachingDTO>();
            v=(Vector<TeachingDTO>)session.getAttribute("allteaching");
            Iterator it=v.iterator();
            TeachingDTO teachingdto=new TeachingDTO();
            while(it.hasNext()){
            	teachingdto=(TeachingDTO)it.next();
        %>
        <tr>
            <td ><input type="checkbox" name="check" value=<%=teachingdto.getTeacherId()+","+teachingdto.getCourseId()%> /></td>
            <td ><%=teachingdto.getTeacherId() %></td>
            <td ><%=teachingdto.getTeacherName() %></td>
            <td ><%=teachingdto.getCourseId() %></td>
            <td ><%=teachingdto.getCourseName() %></td>
            <td ><%=teachingdto.getCourseDesc() %></td>
            <td ><%=teachingdto.getClassTime()%></td>
            <td ><%=teachingdto.getAddress() %></td>          
            <td ><%=teachingdto.getStudentsNumber() %></td>
			<td> <a href="updateTeachingInfo.jsp?TeacherId=<%=teachingdto.getTeacherId() %>&CourseId=<%=teachingdto.getCourseId() %>"><img class="operation" src="img/update.png"></a> 
				<a href="deleteTeachingServlet?TeacherId=<%=teachingdto.getTeacherId() %>&CourseId=<%=teachingdto.getCourseId() %>"><img src="img/delete.png"></a>								
			</td>
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

<!-- /footer -->
<footer>
</footer>
<!-- /footer -->

</div>
<!-- /wrap_right -->
</body>
</html>