<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="java.util.*" %>
<%@page import="cn.edu.lingnan.dto.Room" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script language="javascript">
function check(){
  var inputs = document.getElementsByTagName('input');
  for(var i=0,len=2;i<len;i++){
    if(inputs[i].value.replace(/\s/g,'') == ''){
     alert('�������Ϊ�գ�');
     inputs[i].focus();
     return false;
    }
  }
  return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>����Աҳ��</title>
</head>
<body>
<div align="center">
<H3>���Ӱ����Ϣ</H3>
<form id="form1" name="form1" method="post" action="RoomServlet">
 <table width="60%" border="1" class="tableEdit">
      <tr>
        <td width="34%">�����</td>
        <td width="66%">
          <label>
            <input type="text" name="Rid" id="Rid" />
          </label>
        *</td>
      </tr>
      <tr>
        <td>��������</td>
        <td><input type="text" name="Rtype" id="Rtype" />
          *</td>
      </tr>
      <tr>
        <td>��ʳ�ײ�</td>
        <td><input type="text" name="Breakfirst" id="Breakfirst" /> </td>
      </tr>
      <tr>
        <td>�۸�</td>
        <td><input type="text" name="Price" id="Price" />
          </td>
      </tr>
      <tr>
        <td colspan="2"><label>
          <input type="submit" name="action" id="button" value="add" />
        </label></td>
        </tr>
    </table>
   </form>
   </div>
</body>
</html>