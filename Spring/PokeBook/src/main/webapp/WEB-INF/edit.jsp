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
	<h1 class="text-success">Edit Expense</h1>
	<a href="/expenses" class="text-primary">Go Back</a>
	<form:form action="/expenses/${onePoke.id}" method="post" modelAttribute="onePoke">
	    <input type="hidden" name="_method" value="put">
	    <div class="form-floating mb-3">

			<form:input placeholder="Expense Name:" class="form-control"
				path="expense" />
	
			<form:label class="form-label" path="expense">Expense Name:</form:label>
	
			<form:errors class="text-danger" path="expense" />

		</div>
		<div class="form-floating mb-3">

			<form:input placeholder="Vendor Name:" class="form-control"
				path="vendor" />
	
			<form:label class="form-label" path="vendor">Vendor Name:</form:label>
	
			<form:errors class="text-danger" path="vendor" />

		</div>
		<div class="form-floating mb-3">

			<form:input placeholder="Amount:" class="form-control"
				path="amount" />
	
			<form:label class="form-label" path="amount">Amount:</form:label>
	
			<form:errors class="text-danger" path="amount" />

		</div>
		<div class="form-floating mb-3">

			<form:input placeholder="Description:" class="form-control"
				path="description" />
	
			<form:label class="form-label" path="description">Description:</form:label>
	
			<form:errors class="text-danger" path="description" />
		</div>   
	    <input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
</body>
</html>