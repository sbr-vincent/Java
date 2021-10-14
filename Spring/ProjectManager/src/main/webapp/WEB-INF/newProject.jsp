<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>New Project</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Create A Project</h1>
		</div>
		<form:form action="/projects/create" method="post" modelAttribute="project">
			<div class="form-floating mb-3">
	
				<form:input placeholder="Title:" class="form-control"
					path="title" />
		
				<form:label class="form-label" path="title">Title:</form:label>
		
				<form:errors class="text-danger" path="title" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Description:" class="form-control"
					path="description" />
		
				<form:label class="form-label" path="description">Description:</form:label>
		
				<form:errors class="text-danger" path="description" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Due By:" class="form-control"
					path="dueBy" type="date" />
		
				<form:label class="form-label" path="dueBy">Due By:</form:label>
		
				<form:errors class="text-danger" path="dueBy" />
	
			</div>
			<form:hidden path="lead" value="${loggedInUser.id}"/>
			<a href="/dashboard" class="btn btn-dark">Cancel</a>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>