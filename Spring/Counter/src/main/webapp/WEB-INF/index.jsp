<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<p>You have visited http://your_server <c:out value="${countToShow}"></c:out> times. </p>
	<a href="http://localhost:8080/your_server">Test another visit?</a>
</body>
</html>