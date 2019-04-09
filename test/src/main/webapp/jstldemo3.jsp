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
<%-- <%pageContext.setAttribute("day", 1); %> --%>

<!--varStatus 是一个包含了当前循环信息的对象，该对象中有4个属性
	index 当前循环的次数 
  -->
<c:forEach begin="100" end="300" step="2" var="i" varStatus="st">
	<c:if test="${st.count%3==0 }">
	<span style="color: red">${i }</span><br>
	</c:if>
	${i }
</c:forEach>

<hr>
<% List<String> list = new ArrayList();
	list.add("刘备");
	list.add("关羽");
	list.add("张飞");
	list.add("诸葛亮 ");
	pageContext.setAttribute("list", list);
%>
<c:forEach items="${list }" var="name" >
	${name }<br>

</c:forEach>

</body>
</html>