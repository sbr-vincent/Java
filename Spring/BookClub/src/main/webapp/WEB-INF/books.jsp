<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Cafe Java</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content-between mt-4">
			<div class="div">
			    <h1 class="text-success">Welcome <c:out value="${ loggedInUser.userName }" /></h1>
			    <p>Books from everyone's shelves: </p>
			</div>
			<div class="div">
				<a href="/logout" class="btn btn-danger">Logout</a>
				<a href="/books/new" class="btn btn-dark">Add a book to my shelf</a>
			</div>
			
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneBook" items="${ allBooks }">
					<tr>
						<td> <c:out value="${oneBook.id}" /> </td>
						<td> <a href="/books/${ oneBook.id }"> <c:out value="${oneBook.title}" /> </a> </td>
						<td> <c:out value="${oneBook.author}" /> </td>
						<td> <c:out value="${oneBook.user.userName}" /> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>