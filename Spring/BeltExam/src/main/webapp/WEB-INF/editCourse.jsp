<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body class="container">
	<h1 class="text-success"><c:out value="${oneCourse.courseName}" /></h1>
	<form:form action="/courses/${oneCourse.id}/update" method="post" modelAttribute="oneCourse">
	    <input type="hidden" name="_method" value="put">
	    
	    <div class="form-floating mb-3">

			<form:input placeholder="Course Name:" class="form-control"
				path="courseName" />
	
			<form:label class="form-label" path="courseName">Course Name:</form:label>
	
			<form:errors class="text-danger" path="courseName" />

		</div>
		<div class="form-floating mb-3">

			<form:input placeholder="Day of Week:" class="form-control"
				path="day" />
	
			<form:label class="form-label" path="day">Day of Week:</form:label>
	
			<form:errors class="text-danger" path="day" />

		</div>
		<div class="form-floating mb-3">

			<form:input placeholder="Price:" class="form-control"
				path="price" />
	
			<form:label class="form-label" path="price">Price:</form:label>
	
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
				path="description" />
	
			<form:label class="form-label" path="description">Description:</form:label>
	
			<form:errors class="text-danger" path="description" />

		</div>  
		<a href="/courses/${oneCourse.id}/delete" class="btn btn-danger">Delete</a>
		<a href="/dashboard" class="btn btn-dark">Cancel</a>
	    <input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
	
	
</body>
</html>