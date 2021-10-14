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
			<h1>New Ninja</h1>
			<a href="/dojos/new">Create a Dojo</a>
		</div>
		<form:form action="/ninjas/create" method="post" modelAttribute="ninja">
			<div class="form-floating mb-3">
				<form:select path="dojo">
					<c:forEach items="${ allDojos }" var="dojo">
					<form:option value="${ dojo.id }" label="${dojo.name }"></form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="First Name:" class="form-control"
					path="firstName" />
		
				<form:label class="form-label" path="firstName">First Name:</form:label>
		
				<form:errors class="text-danger" path="firstName" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Last Name:" class="form-control"
					path="lastName" />
		
				<form:label class="form-label" path="lastName">Last Name:</form:label>
		
				<form:errors class="text-danger" path="lastName" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Age:" class="form-control"
					path="age" />
		
				<form:label class="form-label" path="age">Age:</form:label>
		
				<form:errors class="text-danger" path="age" />
	
			</div>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>