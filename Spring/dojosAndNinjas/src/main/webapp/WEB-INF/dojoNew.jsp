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
			<h1>New Dojo</h1>
			<a href="/ninjas/new">Create a Ninja</a>
		</div>
		<form:form action="/dojos/new" method="post" modelAttribute="dojo">
			<div class="form-floating mb-3">
	
				<form:input placeholder="Name:" class="form-control"
					path="name" />
		
				<form:label class="form-label" path="name">Name:</form:label>
		
				<form:errors class="text-danger" path="name" />
	
			</div>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>