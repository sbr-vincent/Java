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
			<h1><c:out value="${ allNinjas.name }" /> Location Ninjas</h1>
		</div>
	
		<table class="table table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${allNinjas.ninjas}">
					<tr>
						<td><c:out value="${ ninja.firstName }" /></td>
						<td><c:out value="${ ninja.lastName }" /></td>
						<td><c:out value="${ ninja.age }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>