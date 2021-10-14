<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Java Belt</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content-between mt-4">
			<div class="div">
			    <h1 class="text-success">Namaste, <c:out value="${ loggedInUser.name }" />.</h1>
			</div>
			<div class="div">
				<a href="/logout" class="btn btn-danger">Logout</a>
			</div>
		</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Class Name</th>
					<th>Instructor</th>
					<th>Weekday</th>
					<th>Price</th>
					<th>Time</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneCourse" items="${ allCourses }">
					<tr>
						<td> <a href="/courses/${ oneCourse.id }"> <c:out value="${oneCourse.courseName}" /> </a>
							<c:if test="${ loggedInUser.id == oneCourse.user.id }">  
								<a href="/courses/${ oneCourse.id }/edit" class="btn btn-dark">Edit</a>
							</c:if>
						</td>
						<td><c:out value="${oneCourse.user.name}" /> </td>
						<td><c:out value="${oneCourse.day}" /></td>
						<td><c:out value="$ ${oneCourse.price}" /></td>
						<td><c:out value="${oneCourse.time}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="/courses/new" class="btn btn-dark">+ New Course</a>
		
	</div>
</body>
</html>