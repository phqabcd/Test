<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.test.domain.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新学生页面</title>
</head>
<body>
<h3>更新学生页面</h3>
<form method="post" action="UpdateServlet">
	<% Student stu=(Student)request.getAttribute("stu");
		System.out.println(stu);
	%>
	<!-- 不显示但仍传递的参数 -->
	<input type="hidden" name="sid" value="<%=stu.getSid() %>">
	<table border="1" width="600">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="sname" value="<%=stu.getSname()%>"/></td>
		</tr>
		<!-- 在radio中判断，checked勾选对应的性别 -->
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="男" <%if(("男").equals(stu.getGender())){%>checked<%} %> />男
				<input type="radio" name="gender" value="女" <%if(("女").equals(stu.getGender())){%>checked<%} %> />女
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phone" value="<%=stu.getPhone() %>"></td>
		</tr>
		<tr>
			<td>生日</td>
			<td><input type="text" name="birthday" value="<%=stu.getBirthday()%>"></td>
		</tr>
		<tr>
			<td>爱好</td>
			<!-- 爱好有多个 -->
			<td><input type="checkbox" name="hobby" value="游泳" <%if(stu.getHobby()!=null&&stu.getHobby().contains("游泳")){ %>checked<%} %>>游泳
			<input type="checkbox" name="hobby" value="篮球" <%if(stu.getHobby()!=null&&stu.getHobby().contains("篮球")){ %>checked<%} %>>篮球
			<input type="checkbox" name="hobby" value="足球" <%if(stu.getHobby()!=null&&stu.getHobby().contains("足球")){ %>checked<%} %>>足球
			<input type="checkbox" name="hobby" value="看书" <%if(stu.getHobby()!=null&&stu.getHobby().contains("看书")){ %>checked<%} %>>看书
			<input type="checkbox" name="hobby" value="写字" <%if(stu.getHobby()!=null&&stu.getHobby().contains("写字")){ %>checked<%} %>>写字</td>
		</tr>
		<tr>
			<td>简介</td>
			<td><textarea rows="3" cols="20" name="info"><%=stu.getInfo() %></textarea>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="更新"/>
		</tr>
	</table>
</form>
</body>
</html>