<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.MajorDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸�רҵ��Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllMajor">רҵ����</a>&nbsp;-</span>&nbsp;�޸�רҵ��Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�޸�רҵ��Ϣ</span>
				</div>
				<form action="updateMajorServlet">
                        <%
                        	String MajorId = request.getParameter("MajorId");
							Vector<MajorDTO> v = new Vector<MajorDTO>();
							v = (Vector<MajorDTO>)session.getAttribute("allmajor");
							Iterator it = v.iterator();
							MajorDTO s = null;
							while(it.hasNext()){
								s = (MajorDTO)it.next();
								if(s.getMajorId().equals(MajorId)){
						 %>				
				<div class="baBody">
					<div class="bbD">רҵ��ţ�<input readOnly="true" name="MajorId" value=<%=s.getMajorId() %> class="input3" /></div>
					<div class="bbD">Ժϵ��ţ�<input name="DeptId" value=<%=s.getDeptId() %> class="input3" /></div>
					<div class="bbD">רҵ���ƣ�<input name="MajorName" value=<%=s.getMajorName() %> class="input3" /></div>
					<div class="bbD">�༶������<input name="ClassNumber" value=<%=s.getClassNumber() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="findAllMajor">ȡ��</a>
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