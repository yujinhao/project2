<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>ѧ��������Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllStudent">��Ϣά��</a>&nbsp;-</span>&nbsp;������Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>������Ϣ</span>
				</div>
				<form action="findStudentInfo">
                        <%
                        Vector<StudentsDTO> v = new Vector<StudentsDTO>();
						v = (Vector<StudentsDTO>)session.getAttribute("person");
						Iterator it = v.iterator();
						StudentsDTO s = null;
						while(it.hasNext()){
							s = (StudentsDTO)it.next();		
						 %>				
				<div class="baBody">
					<div class="bbD">ѧ����ţ�<%=s.getStudentId()%></div>	
					<div class="bbD">�����༶��<%=s.getClassId() %></div>
					<div class="bbD">ѧ��������<%=s.getStudentName() %></div>
					<div class="bbD">ѧ���Ա�<%=s.getStudentSex() %> </div>
					<div class="bbD">ѧ�����䣺<%=s.getStudentAge() %></div>
					<div class="bbD">��ѧʱ�䣺<%=s.getEntranceTime() %></div>
					<div class="bbD">��¼���룺<%=s.getStudentPassw() %> </div>
					<div class="bbD">
                        <p class="bbDP">
							<a href="updateStudent.jsp?StudentId=<%=s.getStudentId()%>" class="btn_ok btn_yes" type="submit">�޸ĸ�����Ϣ</a>
						</p>
					</div>	
				</div>
				<%-- <div class="btn_box floatR mag_l20">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="updateStudent.jsp?StudentId=<%=s.getStudentId()%>">�޸ĸ�����Ϣ</a>
                </div> --%>
                         <%
								}
						%>				
				</form>
			</div>

			<!-- ��Աע��ҳ����ʽend -->
		</div>
	</div>
</body>
</html>