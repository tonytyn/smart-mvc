<%@ page  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%pageContext.setAttribute("day", 1); %>
	<c:choose >
		<c:when test="${day==1 }">
			Hello Monday!
		</c:when>
		<c:when test="${day==2 }">
			Hello Tuesday
		</c:when>
		<c:otherwise >
			Hello fffff
		</c:otherwise>
		
	</c:choose>



</body>
</html>