<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	List<UserInfo> list = (List) request.getAttribute("list");
%>
<body>
	<!-- 查询-->
	<form action="QueryUserInfoServlet" method="post">
		编号: <input id="id" name="id" type="text" /><br> 姓名：<input
			id="name" name="name" type="text" /><br>
			 <input type="submit" value="查询" /> <input type="reset"
			value="重置" /> <a href="userAdd.jsp">注册</a>
	</form>
	------------------------------------------------
	<!--  列表 -->
	<table>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>备注</td>
			<td colspan="2" align="right">操作</td>
		</tr>
		<c:forEach items="${list}" var="userinfo">
			<tr>
				<td>${userinfo.id}</td>
				<td>${userinfo.name}</td>
				<td>${userinfo.age}</td>
				<td>${userinfo.remark}</td>
				<td><a href="FindUserServlet?id=${userinfo.id}">修改</a></td>
				<td><a href="DeleteUserInfoServelt?id=${userinfo.id}" >删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>