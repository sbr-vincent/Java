<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Show Omikuji</title>
</head>
<body>
	<div class="container bg bg-primary">
		<h1>Here's Your Omikuji!</h1>
		<p>In <c:out value="${ number }"/> years, you will live in <c:out value="${ city }"></c:out>
		 with <c:out value="${ person }"></c:out> as your roommate, <c:out value="${ hobby }"></c:out> for a living. 
		 The next time you see a <c:out value="${ thing }"></c:out>, you will have good luck. 
		 Also, <c:out value="${ saying }"></c:out> </p>
		<a href="/omikuji">Form Page</a>
	</div>
</body>
</html>