<%@ page  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%pageContext.setAttribute("day", 3); %>

<!-- c:if标签会将本次判断的结果以var的值作为name存入scope所指定的作用域 
	pageContext.setAttribute("flag",false);如果不加scope属性，默认也是page
-->
<c:if test="${day==7 }" var="flag" scope="page" >
今天很开心<br>
</c:if>
<c:if test="${!flag }" >
学习使我快乐 <br>
</c:if>
<c:choose></c:choose>



</body>
</html>