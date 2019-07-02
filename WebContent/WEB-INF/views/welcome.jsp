<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	//response.setHeader("Cache-Control", "no-cache, no store, must revalidate"); // HTTP 1.1
	//response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxies
	if(session.getAttribute("username") == null) {
		response.sendRedirect(request.getContextPath() + "/login");
	}
%>

	Welcome ${username}!
	<br>
	<a href="<c:url value="/aboutUs"/>">About Us</a>
	<h1>|</h1>
	<a href="<c:url value="/videos"/>">Videos Here</a>
	<form action=logout method=post>
		<input type="submit" value="logout">
	</form>
</body>
</html>