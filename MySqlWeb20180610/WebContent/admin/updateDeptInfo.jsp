<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.DeptDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸�Ժϵ��Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllDept">Ժϵ����</a>&nbsp;-</span>&nbsp;�޸�Ժϵ��Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�޸�Ժϵ��Ϣ</span>
				</div>
				<form action="updateDeptServlet">
                        <%
                        	String DeptId = request.getParameter("DeptId");
							Vector<DeptDTO> v = new Vector<DeptDTO>();
							v = (Vector<DeptDTO>)session.getAttribute("alldept");
							Iterator it = v.iterator();
							DeptDTO s = null;
							while(it.hasNext()){
								s = (DeptDTO)it.next();
								if(s.getDeptId().equals(DeptId)){
						 %>				
				<div class="baBody">
					<div class="bbD">Ժϵ��ţ�<input readOnly="true" name="DeptId" value=<%=s.getDeptId() %> class="input3" /></div>
					<div class="bbD">Ժϵ���ƣ�<input name="DeptName" value=<%=s.getDeptName() %> class="input3" /></div>
					<div class="bbD">Ժϵ���Σ�<input name="DeptChairman" value=<%=s.getDeptChairman() %> class="input3" /></div>
					<div class="bbD">��ϵ��ʽ��<input name="DeptTel" value=<%=s.getDeptTel() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="findAllDept">ȡ��</a>
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