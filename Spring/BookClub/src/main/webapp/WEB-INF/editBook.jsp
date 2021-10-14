<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body class="container">
	<h1 class="text-success">Change Your Entry</h1>
	<a href="/books" class="text-dark">Go Back to the Shelves</a>
	<form:form action="/books/${oneBook.id}/update" method="post" modelAttribute="oneBook">
	    <input type="hidden" name="_method" value="put">
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
	    <input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
</body>
</html>