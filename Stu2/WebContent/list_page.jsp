<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.test.domain.Student"%>
<%@page import="com.test.domain.PageBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息列表</title>
<script type="text/javascript">
	function doDelete(sid){
		//alert("确认删除？");
		var flag=confirm("确认删除？");
		if(flag){
			//[widow.]location...打开超链接，访问servlet
			location.href="DeleteServlet?sid="+sid;
		}
	}
</script>
</head>
<body>
<form action="SearchStudentServlet" method="post">
	<table border="1px" width="700">
		<tr>
			<td colspan="8">
				按姓名查询：<input type="text" name="sname" /> 
				&nbsp;
				按性别查询:<select name="sgender">
					<option value="">--请选择--
					<option value="男">男
					<option value="女">女
				</select>
				&nbsp;&nbsp;&nbsp;
				<input type="submit" value="查询"/>
				&nbsp;&nbsp;&nbsp;
				<a href="add.jsp">添加</a>
			</td>
		</tr>
		
		<tr>
			<td>id</td>
			<td>名字</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<%
			PageBean pageBean=(PageBean)request.getAttribute("pageBean");
			List<Student> list =pageBean.getList();

			for (int i = 0; i < list.size(); i++) {
				Student stu = (Student) list.get(i);
		%>
		<tr>
			<td><%=stu.getSid() %></td>
			<td><%=stu.getSname() %></td>
			<td><%=stu.getGender() %></td>
			<td><%=stu.getPhone() %></td>
			<td><%if(stu.getBirthday()!=null) out.print(stu.getBirthday());%></td>
			<td><%=stu.getHobby() %></td>
			<td><%=stu.getInfo() %></td>
			<td><a href="EditServlet?sid=<%=stu.getSid()%>"">更新</a> 
			<a href="#" onclick="doDelete(<%=stu.getSid()%>)">删除</a></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="8">
				第<%=pageBean.getCurrentPage() %>/<%=pageBean.getTotalPage() %>
				&nbsp;&nbsp;
				每页显示<%=pageBean.getPageSize() %>条
				&nbsp;&nbsp;&nbsp;
				总的记录数:<%=pageBean.getTotalSize() %>
				&nbsp;&nbsp;&nbsp;
				<%if(pageBean.getCurrentPage()!=1){ %>
				<a href="StudentListPageServlet?currentPage=1">首页</a>
				| <a href="StudentListPageServlet?currentPage=<%=pageBean.getCurrentPage()-1 %>">上一页</a>
				<%} %>
				
				<%for(int begin=1;begin<=pageBean.getTotalPage();begin++){
						if(pageBean.getCurrentPage()==begin)
							out.print(begin);
						else{
					%>
					<a href="StudentListPageServlet?currentPage=<%=begin%>"><%=begin%></a>
				<%} %>
				<%} %>
				<%if(pageBean.getCurrentPage()!=pageBean.getTotalPage()){ %>
				<a href="StudentListPageServlet?currentPage=<%=pageBean.getCurrentPage()+1 %>">下一页</a>
				| <a href="StudentListPageServlet?currentPage=<%=pageBean.getTotalPage() %>">尾页</a>
				<%} %>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>