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
			<h1>Create A Course</h1>
		</div>
		<form:form action="/courses/create" method="post" modelAttribute="course">
			<div class="form-floating mb-3">
	
				<form:input placeholder="Name:" class="form-control"
					path="courseName" />
		
				<form:label class="form-label" path="courseName">Name:</form:label>
		
				<form:errors class="text-danger" path="courseName" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Day of Week:" class="form-control"
					path="day" />
		
				<form:label class="form-label" path="day">Day of Week:</form:label>
		
				<form:errors class="text-danger" path="day" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Drop-In Price:" class="form-control"
					path="price" type="number" />
		
				<form:label class="form-label" path="price">Drop-In Price:</form:label>
		
				<form:errors class="text-danger" path="price" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Time:" class="form-control"
					path="time" type="time"/>
		
				<form:label class="form-label" path="time">Time:</form:label>
		
				<form:errors class="text-danger" path="time" />
	
			</div>
			<div class="form-floating mb-3">
	
				<form:input placeholder="Description:" class="form-control"
					path="description" type="dateTime"/>
		
				<form:label class="form-label" path="description">Description:</form:label>
		
				<form:errors class="text-danger" path="description" />

			</div>
			<form:hidden path="user" value="${loggedInUser.id}"/>
			<a href="/dashboard" class="btn btn-dark">Cancel</a>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>