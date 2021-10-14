<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
	<h1>All Books</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>#Pages</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="oneBook" items="${books}">
			<tr>
				<td><c:out value="${ oneBook.id }"/></td>
				<td><a href="/books/${ oneBook.id }"><c:out value="${ oneBook.title }"/></a></td>
				<td><c:out value="${ oneBook.language }"/></td>
				<td><c:out value="${ oneBook.numberOfPages }"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>