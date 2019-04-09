<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@ page  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%pageContext.setAttribute("price", 28888); %>
<fmt:formatNumber >
	${price }
</fmt:formatNumber>
<hr>
<%pageContext.setAttribute("today", new Date()); %>
<fmt:formatDate value="${today }" pattern="yyyy/MM/dd"/>


</body>
</html>