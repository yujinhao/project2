<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.StudentsDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<title>��ӿγ���Ϣ</title>
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<!--  <div class="page">
				<img src="img/coin02.png" /><span><a href="#">��ҳ</a>&nbsp;-&nbsp;<a
					href="findAllCourseServlet">�γ���Ϣ����</a>&nbsp;-</span>&nbsp;��ӿγ���Ϣ
			</div>-->
		</div>
		<div class="page ">
			<!-- ��Աע��ҳ����ʽ -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>����γ���Ϣ</span>
				</div>
				<form action="addCourseServlet" name="form">			
				<div class="baBody">
					<p>"<span class="f_cB">&nbsp;*&nbsp;</span>"��Ϊ������Ŀ</p>
					<div class="bbD">�γ̱��<span class="f_cB">&nbsp;*</span>
					<input id="CourseId" name="CourseId" class="input3" required />
					</div>
					<div class="bbD">�γ�����<span class="f_cB">&nbsp;*</span>
					<input id="CourseName" name="CourseName" class="input3" required />
					</div>
					<div class="bbD">�γ�ѧ��<span class="f_cB">&nbsp;*</span>
					<input id="CourseCredit" name="CourseCredit" class="input3" required />
					</div>
					<div class="bbD">�γ�ѧʱ<span class="f_cB">&nbsp;*</span>
					<input id="CourseClass" name="CourseClass" class="input3" required />
					</div>					
					<div class="bbD">�γ�����<span class="f_cB">&nbsp;*</span>
					<input id="CourseDesc" name="CourseDesc" class="input3" required />
					</div>
					<div class="bbD">�Ͽ�ʱ��<span class="f_cB">&nbsp;*</span>
					<input id="ClassTime" name="ClassTime" class="input3" required />
					</div>
					<div class="bbD">�Ͽεص�<span class="f_cB">&nbsp;*</span>
					<input id="Address" name="Address" class="input3" required />
					</div>
					<div class="bbD">�γ�����<span class="f_cB">&nbsp;*</span>
					<input id="Volume" name="Volume" class="input3" required />
					</div>
					<div class="bbD">�γ�����<span class="f_cB">&nbsp;*</span>
					<input id="Remain" name="Remain" class="input3" required />
					</div>
					
					<div class="bbD">
						<p class="bbDP">
							 <button class="btn_ok btn_yes" type="submit" onClick="return check();">ȷ�����</button>
							<a class="btn_ok btn_no" href="addCourseInfo.jsp">ȡ��</a>
							<!--<input type="submit" value="ȷ�����"/>
                            <input type="button" value="����" onclick="history.back(-1)"/> -->
						</p>
					</div>
				</div>			
				</form>
			</div>

			<!-- ��Աע��ҳ����ʽend -->
		</div>
	</div>
</body>
</html>