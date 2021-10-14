<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h1 class="text-danger">Fruity Loops</h1>
	<table class="col-6 table table-danger">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneFruit" items="${fruityloops}">
				<tr>
					<td><c:out value="${oneFruit.name}"> </c:out></td>
					<td><c:out value="${oneFruit.price}"> </c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>