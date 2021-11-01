<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Create Product</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Create a Product Listing</h1>
			<a href="/dashboard" class="btn btn-dark ml-3">Home</a>
		</div>
		<form:form action="/products/create" method="post" modelAttribute="product">
			<div class="form-floating mb-3">
	
				<form:input placeholder="Name:" class="form-control"
					path="name" />
		
				<form:label class="form-label" path="name">Name:</form:label>
		
				<form:errors class="text-danger" path="name" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Description:" class="form-control"
					path="description" />
		
				<form:label class="form-label" path="description">Description:</form:label>
		
				<form:errors class="text-danger" path="description" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Price:" class="form-control"
					path="price" type=""/>
		
				<form:label class="form-label" path="price">Price:</form:label>
		
				<form:errors class="text-danger" path="price" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Image URL:" class="form-control"
					path="image" />
		
				<form:label class="form-label" path="image">Image URL:</form:label>
		
				<form:errors class="text-danger" path="image" />
	
			</div>
			<form:hidden path="user" value="${loggedInUser.id}"/>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>