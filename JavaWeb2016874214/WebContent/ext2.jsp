<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<%@page import="java.util.*" %>
<%@page import="cn.edu.lingnan.dto.Room" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>闲余私人影院</title>
<style type="text/css">
body{
	font-size:12px;
	background-image: url(images/bg.gif);
	background-repeat: repeat;
}
ul,li,h2{margin:0;padding:0;}
ul{list-style:none;}
#top{
	width:909px;
	height:26px;
	background-image: url(images/h2bg.gif);
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
	background-repeat: repeat-x;
}
#top h2{
	width:150px;
	height:24px;
	float:left;
	font-size:12px;
	text-align:center;
	line-height:20px;
	color:#0066FF;
	font-weight: bold;
	padding-top: 2px;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
}
#top .jg {
	width: 5px;
	float: left;
	background-color: #DCE6F5;
	height: 26px;
}
#topTags{
	width:740px;
	height:24px;
	float:left;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
	padding-top: 2px;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
	padding-left: 10px;
}
#topTags ul li{
	float:left;
	width:100px;
	height:21px;
	margin-right:4px;
	display:block;
	text-align:center;
	cursor:pointer;
	padding-top: 3px;
	color: #15428B;
	font-size: 12px;
}
#main{
	width:909px;
	height:501px;
	background-color:#F5F7E6;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
}
#main .jg {
	width: 5px;
	float: left;
	background-color: #DFE8F6;
	height: 500px;
}
#leftMenu{
	width:150px;
	height:500px;
	background-color:#DAE7F6;
	float:left;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
}
#leftMenu ul{margin:10px;}
#leftMenu ul li{
	width:130px;
	height:22px;
	display:block;
	cursor:pointer;
	text-align:center;
	margin-bottom:5px;
	background-color: #D9E8FB;
	background-image: url(images/tabbg01.gif);
	background-repeat: no-repeat;
	background-position: 0px 0px;
	padding-top: 2px;
	line-height: 20px;
}
#leftMenu ul li a{
	color:#000000;
	text-decoration:none;
	background-image: url(images/tb-btn-sprite_03.gif);
	background-repeat: repeat-x;
}
#content{
	width:750px;
	height:500px;
	float:left;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
	background-color: #DAE7F6;
}
.content{
	width:740px;
	height:490px;
	display:none;
	padding:5px;
	overflow-y:auto;
	line-height:30px;
	background-color: #FFFFFF;
}
#footer{
	width:907px;
	height:26px;
	background-color:#FFFFFF;
	line-height:20px;
	text-align:center;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
	border-right-width: 1px;
	border-left-width: 1px;
	border-right-style: solid;
	border-left-style: solid;
	border-right-color: #99BBE8;
	border-left-color: #99BBE8;
	background-image: url(images/h2bg.gif);
	background-repeat: repeat-x;
}
.content1 {width:740px;height:490px;display:block;padding:5px;overflow-y:auto;line-height:30px;}
</style>
<script type="text/javascript">
window.onload=function(){
function $(id){return document.getElementById(id)}
var menu=$("topTags").getElementsByTagName("ul")[0];//顶部菜单容器
var tags=menu.getElementsByTagName("li");//顶部菜单
var ck=$("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li");//左侧菜单
var j;
//点击左侧菜单增加新标签
for(i=0;i<ck.length;i++){
ck[i].onclick=function(){
$("welcome").style.display="none"//欢迎内容隐藏
clearMenu();
this.style.background='url(images/tabbg02.gif)'
//循环取得当前索引
for(j=0;j<8;j++){
if(this==ck[j]){
if($("p"+j)==null){
openNew(j,this.innerHTML);//设置标签显示文字
 }
clearStyle();
$("p"+j).style.background='url(images/tabbg1.gif)';
clearContent();
$("c"+j).style.display="block";
   }
 }
return false;
  }
 }
//增加或删除标签
function openNew(id,name){
var tagMenu=document.createElement("li");
tagMenu.id="p"+id;
tagMenu.innerHTML=name+"&nbsp;&nbsp;"+"<img src='images/off.gif' style='vertical-align:middle'/>";
//标签点击事件
tagMenu.onclick=function(evt){
clearMenu();
ck[id].style.background='url(images/tabbg02.gif)'
clearStyle();
tagMenu.style.background='url(images/tabbg1.gif)';
clearContent();
$("c"+id).style.display="block";
}
//标签内关闭图片点击事件
tagMenu.getElementsByTagName("img")[0].onclick=function(evt){
evt=(evt)?evt:((window.event)?window.event:null);
if(evt.stopPropagation){evt.stopPropagation()} //取消opera和Safari冒泡行为;
this.parentNode.parentNode.removeChild(tagMenu);//删除当前标签
var color=tagMenu.style.backgroundColor;
//设置如果关闭一个标签时，让最后一个标签得到焦点
if(color=="#ffff00"||color=="yellow"){//区别浏览器对颜色解释
if(tags.length-1>=0){
clearStyle();
tags[tags.length-1].style.background='url(images/tabbg1.gif)';
clearContent();
var cc=tags[tags.length-1].id.split("p");
$("c"+cc[1]).style.display="block";
clearMenu();
ck[cc[1]].style.background='url(images/tabbg1.gif)';
 }
else{
clearContent();
clearMenu();
$("welcome").style.display="block"
   }
  }
}
menu.appendChild(tagMenu);
}
//清除菜单样式
function clearMenu(){
for(i=0;i<ck.length;i++){
ck[i].style.background='url(images/tabbg01.gif)';
 }
}
//清除标签样式
function clearStyle(){
for(i=0;i<tags.length;i++){
menu.getElementsByTagName("li")[i].style.background='url(images/tabbg2.gif)';
  }
}
//清除内容
function clearContent(){
for(i=0;i<7;i++){
$("c"+i).style.display="none";
 }
}
}
</script>
</head>
<body>
<div id="top">
<h2>管理菜单</h2>
<div class=jg></div>
<div id="topTags">
<ul>
</ul>
</div>
</div>
<div id="main"> 
<div id="leftMenu">
<ul>
<li>个人资料</li>
<li ></li>

<li>查询房间</li>




</ul>
</div>
<div class=jg></div>
<div id="content">
<div id="welcome" class="content" style="display:block;">
  <div align="center">
    <p>&nbsp;</p>
    <p><strong>欢 迎 来 到 闲 余 影 院 系 统！</strong></p>
    <p>&nbsp;</p>
    </div>
</div>
<div id="c0" class="content"><div align="center">
    <p>&nbsp;</p>
    <p><strong>尊 敬 的 客户</strong></p>
      <p><strong>闲 余 私 人 影 院 为 你 服 务</strong></p>
    <p>&nbsp;</p>
    </div></div>
<div id="c1" class="content"><!-- <form id="form1" name="form1" method="post" action="RoomServlet">
 <table  border="1" class="tableEdit" width="600" cellpadding="0" cellspacing="0">
      <tr>
        <td width="34%">房间号</td>
        <td width="66%">
          <label>
            <input type="text" name="Rid" id="Rid" />
          </label>
        *</td>
      </tr>
      <tr>
        <td>房间类型</td>
        <td><input type="text" name="Rtype" id="Rtype" />
          *</td>
      </tr>
      <tr>
        <td>零食套餐</td>
        <td><input type="text" name="Breakfirst" id="Breakfirst" /> </td>
      </tr>
      <tr>
        <td>价格</td>
        <td><input type="text" name="Price" id="Price" />
          </td>
      </tr>
      <tr>
        <td colspan="2"><label>
          <input type="submit" name="action" id="button" value="add" />
        </label></td>
        </tr>
    </table>
   </form> --></div>
   
   
   
<div id="c2" class="content"><jsp:useBean id="service" class="cn.edu.lingnan.service.RoomService" scope="session"/>
	<%
		List<Room> projectlist=service.fill();
		Iterator<Room> iterproject=projectlist.iterator();
	%>

	<table width="700" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			
		</tr>
		<tr>
			<td height="30" colspan="3">
			<form action="RoomServlet?action=delete2" method="post">	
			<table width="100%" border="1"
					align="center" cellpadding="0" cellspacing="0">
					<tr>
					    
				
						<td width="20%" height="30" align="center" ><span
							class="txt"><span class="titletxt">房间ID</span></span></td>
						<td width="20%" height="30" align="center" 
							class="titletxt">房间类型</td>
						<td width="20%" height="30" align="center" 
							class="titletxt">套餐</td>
					
					<td width="20%" height="30" align="center" 
							class="titletxt">价格</td>
					
					<td width="20%" height="30" align="center" 
							class="titletxt" >预约</td>
					</tr>
					<%
					List<Room> projectlist1=service.fill();
		            for(int i=0;i<projectlist1.size();i++){
		            	Room rm= (Room)projectlist1.get(i);
						
					%>
					<tr>
					    
						<td width="20%" height="30" align="center" ><span
							class="txt"><%=rm.getRid()%></span></td>
						<td width="20%" height="30" align="center" ><span
							class="txt"><%=rm.getRtype()%></span></td>
						
							
						<td width="20%" height="30" align="center" ><span
							class="txt"><%=rm.getBreakfirst()  %></span></td>	
							
								
						<td width="20%" height="30" align="center" ><span
							class="txt"><%= rm.getPrice()%></span></td>	
							
						<td width="20%" height="30" align="center"><span
							class="txt">
							<a href="RoomServlet?id=<%=rm.getRid()%>&action=update2">预约</a></span></td>
					</tr>
					<%	
					 }
					%>
				 <tr>
						
				</tr>
				</table>
				</form>	
			</td>
		</tr>
	</table></div>
<div id="c3" class="content">编辑房间</div>
<div id="c4" class="content">	
</div>
<div id="c5" class="content"></div>
<div id="c6" class="content">帮助信息</div>
</div>
</div>
<div id="footer">闲余私人影院</div>
</body>
</html>