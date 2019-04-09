<%@page import="entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL语法</h1>
<h3>输出数组内容</h3>
<%int[] array = {1,2,3,4,5};
	request.setAttribute("array", array);
%>
array=${array }<br>
array[0]=${array[0] }<br>
array[8]=${array[8] }<br>
<hr>
<h3>输出集合中内容</h3>
<%List<String>list = new ArrayList();
	list.add("宋江");
	list.add("史进");
	list.add("林冲");
	request.setAttribute("list", list);
%>
list[0]=${list[0] }<br>
list[8]=${list[8] }<br>
<hr>
<h3>输出对象中内容</h3>
<%User user = new User(1,"张三","wwww","345");
	request.setAttribute("user", user);
%>
username =${user.username }<br>

<hr>
</body>
</html>