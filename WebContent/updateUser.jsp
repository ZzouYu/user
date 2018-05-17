<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%  UserInfo user = (UserInfo)request.getAttribute("userinfo") ; %>
<script type="text/javascript">
</script>
<body>
	<form name="form1" method="post" action="UpdateUserServlet">
		<input name="id" type="hidden" id="id" value="<%=user.getId() %>">
		<table border="0" align="center">
			<tr>
				<td>姓名</td>
				<td><input name="name" type="text" id="birthday" value="<%=user.getName() %>"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input name="age" type="text" id="age" value="<%=user.getAge() %>"></td>
			</tr>

			<tr>
				<td>备注</td>
				<td><input name="remark" type="text" id="remark" value="<%=user.getRemark() %>"></td>
			</tr>
			<tr>
				<td>
				<div align="center">
					<input type="submit" name="Submit" value="提交"> 
					<input type="reset" name="Submit2" value="重置">
				</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>