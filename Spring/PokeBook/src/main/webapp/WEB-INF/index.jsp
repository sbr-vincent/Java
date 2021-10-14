<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Display/Form</title>
</head>
<body class="container">
	<h1 class="text-primary">PokeBook</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBook" items="${books}">
				<tr>
					<td><c:out value="${ oneBook.expense }" /></td>
					<td><c:out value="${ oneBook.vendor }" /></td>
					<td>$<c:out value="${ oneBook.amount }" /></td>
					<td><a href="/expenses/${oneBook.id}/edit" class="btn btn-primary">Edit</a> <a href="/books/${oneBook.id}/delete" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2 class="text-primary">Track An Expense</h2>
	<form:form action="/expenses" method="post" modelAttribute="poke">
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