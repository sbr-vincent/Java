<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>View course</title>
</head>
<body class="container">
	<div class="navbar">
		<h1> <c:out value="${ oneCourse.courseName }" /> </h1>
		<a href="/dashboard" class="btn btn-dark">Dashboard</a>
	</div>
	
	<p>Day: <c:out value="${oneCourse.day}"/></p>
	<p>Cost: $<c:out value="${oneCourse.price}"/></p>
	<p>Time: <c:out value="${oneCourse.time}"/></p>
	<p><c:out value="${oneCourse.description}"/></p>
	<hr>
	
	<h2>Students</h2>
	<p>List of students in the class</p>
	<c:forEach items="${ oneCourse.students }" var="student">
			<p><c:out value="${ student.name } - ${ student.email }"/></p>
	</c:forEach>
	<hr>
	<h3>New Student</h3>
	<div class="row d-flex justify-content-between">
		<form:form action="/students/create" method="post" modelAttribute="student">
				<div class="form-floating mb-3">
		
					<form:input placeholder="Name:" class="form-control"
						path="name" />
			
					<form:label class="form-label" path="name">Name:</form:label>
			
					<form:errors class="text-danger" path="name" />
		
				</div>
				<div class="form-floating mb-3">
		
					<form:input placeholder="Email:" class="form-control"
						path="email" />
			
					<form:label class="form-label" path="email">Email:</form:label>
			
					<form:errors class="text-danger" path="email" />
		
				</div>
				<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
		<hr>
		<h3>Existing Student</h3>
		<form action="/courses/${ oneCourse.id }/addStudent" method="post">
			<select name="studentId">
				<c:forEach items="${allStudents}" var="oneStudent">
					<option value="${ oneStudent.id }"> <c:out value="${oneStudent.name} - ${oneStudent.email}"/></option>
				</c:forEach>
			</select>
			<button class="btn btn-primary">Add Student</button>
		</form>
		
	</div>
	
</body>
</html>