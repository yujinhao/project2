<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.ManagersDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>�޸ĸ�����Ϣ</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="#">����</a>&nbsp;-</span>&nbsp;�޸ĸ�����Ϣ
			</div>
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>�޸ĸ�����Ϣ</span>
				</div>
				<form action="updateMyself">
                        <%
                        	String ManagerId = (String) session.getAttribute("UserId");
							Vector<ManagersDTO> v = new Vector<ManagersDTO>();
							v = (Vector<ManagersDTO>)session.getAttribute("myself");
							Iterator it = v.iterator();
							ManagersDTO s = null;
							while(it.hasNext()){
								s = (ManagersDTO)it.next();
								if(s.getManagerId().equals(ManagerId)){
						 %>				
				<div class="baBody">
					<div class="bbD">����Ա��ţ�<input readOnly="true" name="ManagerId" value=<%=s.getManagerId() %> class="input3" />&nbsp;&nbsp;��ϵ�绰��<input name="ManagerTel" value=<%=s.getManagerTel() %> class="input3" /></div>
					<div class="bbD">����Ա������<input name="ManagerName" value=<%=s.getManagerName() %> class="input3" />&nbsp;&nbsp;�칫��ַ��<input name="ManagerAddr" value=<%=s.getManagerAddr() %> class="input3" /></div>
					<div class="bbD">����Ա�Ա�<input name="ManagerSex" value=<%=s.getManagerSex() %> class="input3" />&nbsp;&nbsp;��¼���룺<input name="ManagerPassw" value=<%=s.getManagerPassw() %> class="input3" /></div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">ȷ���޸�</button>
							<a class="btn_ok btn_no" href="findMyself">ȡ��</a>
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