<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Add a Book to Your Shelf</h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<form:form action="/books/create" method="post" modelAttribute="book">
			<div class="form-floating mb-3">
	
				<form:input placeholder="Title:" class="form-control"
					path="title" />
		
				<form:label class="form-label" path="title">Title:</form:label>
		
				<form:errors class="text-danger" path="title" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Author:" class="form-control"
					path="author" />
		
				<form:label class="form-label" path="author">Author:</form:label>
		
				<form:errors class="text-danger" path="author" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Thoughts:" class="form-control"
					path="thoughts" />
		
				<form:label class="form-label" path="thoughts">Thoughts:</form:label>
		
				<form:errors class="text-danger" path="thoughts" />
	
			</div>
			<form:hidden path="user" value="${loggedInUser.id}"/>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>