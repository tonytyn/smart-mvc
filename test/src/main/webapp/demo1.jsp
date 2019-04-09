<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.write("你好张三 <br>");

	request.getHeader("cookie");
	
	out.write(request.getHeader("cookie")+"<br>");
	
	response.setHeader("msg", "hello3");
	
	out.write(session.getId()+"<br>");
	
	out.write(application.getServerInfo()+"<br>");
	
	out.write(config.getServletName()+"<br>");
	
	out.write(page.toString());
	
%>


</body>
</html>