<%@page contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册用户</title>
</head>
<body>
	<form name="form1" method="post" action="AddUserServlet">
		<table border="0" align="center">
			<tr>
				<td>姓名</td>
				<td><input name="name" type="text" id="birthday"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input name="age" type="text" id="age"></td>
			</tr>

			<tr>
				<td>备注</td>
				<td><input name="remark" type="text" id="remark"></td>
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