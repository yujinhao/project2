<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.CourseDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸Ŀγ���Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllStudent">�γ̹���</a>&nbsp;-</span>&nbsp;�޸Ŀγ���Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�޸Ŀγ���Ϣ</span>
				</div>
				<form action="updateCourseServlet">
                        <%
                        	String CourseId = request.getParameter("CourseId");
							Vector<CourseDTO> v = new Vector<CourseDTO>();
							v = (Vector<CourseDTO>)session.getAttribute("allcourse");
							Iterator it = v.iterator();
							CourseDTO d = null;
							while(it.hasNext()){
								d = (CourseDTO)it.next();
								if(d.getCourseId().equals(CourseId)){
						 %>				
				<div class="baBody">
					<div class="bbD">�γ̱�ţ�<input readOnly="true" name="CourseId" value=<%=d.getCourseId() %> class="input3" /></div>
					<div class="bbD">�γ����ƣ�<input name="CourseName" value=<%=d.getCourseName() %> class="input3" /></div>
					<div class="bbD">�γ�ѧ�֣�<input name="CourseCredit" value=<%=d.getCourseCredit() %> class="input3" /></div>
					<div class="bbD">�γ�ѧʱ��<input name="CourseClass" value=<%=d.getCourseClass()%> class="input3" /></div>
					<div class="bbD">�γ����ʣ�<input name="CourseDesc" value=<%=d.getCourseDesc() %> class="input3" /></div>
					<div class="bbD">�Ͽ�ʱ�䣺<input name="ClassTime" value=<%=d.getClassTime() %> class="input3" /></div>
					<div class="bbD">�Ͽεص㣺<input name="Address" value=<%=d.getAddress() %> class="input3" /></div>
					<div class="bbD">�γ�������<input name="Volume" value=<%=d.getVolume() %> class="input3" /></div>
					<div class="bbD">�γ�������<input name="Remain" value=<%=d.getRemain() %> class="input3" /></div>
					
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="findAllCourseServlet">ȡ��</a>
						</p>
					</div>
				</div>
                         <%
								}}
						%>				
				</form>
			</div>

			<!-- ��Աע��ҳ����ʽend -->
		</div>
	</div>
</body>
</html>