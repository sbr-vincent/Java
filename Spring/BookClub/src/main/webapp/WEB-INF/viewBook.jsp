<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
	<div class="navbar">
		<h1> <c:out value="${ oneBook.title }" /> </h1>
		<a href="/books" class="btn btn-dark">Back to the shelves</a>
	</div>
	<c:if test="${ loggedInUser.id == oneBook.user.id }">
	 	<p>You read <c:out value="${ oneBook.title }" /> </p>
	 	<p>Here are your thoughts:</p>
	 	<hr>
		<p><c:out value="${oneBook.thoughts}"/></p>
		<hr>
	</c:if>
	
	<c:if test="${ loggedInUser.id != oneBook.user.id }"> 
		<p> <c:out value="${oneBook.user.userName}"/> read <c:out value="${ oneBook.title }" /> by <c:out value="${ oneBook.author }" /> </p>
		<p>Here are <c:out value="${oneBook.user.userName}"/>'s thoughts:</p>
		<hr>
		<p><c:out value="${oneBook.thoughts}"/></p>
		<hr>
	</c:if>

	<c:if test="${ loggedInUser.id == oneBook.user.id }">
		<a href="/books/${oneBook.id}/edit" class="btn btn-warning">Edit</a>
	</c:if>
</body>
</html>