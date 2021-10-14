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
			    <h1 class="text-success">Welcome <c:out value="${ loggedInUser.firstName }" /></h1>
			</div>
			<div class="div">
				<a href="/logout" class="btn btn-danger">Logout</a>
				<a href="#" class="btn btn-dark">Some link</a>
			</div>
			
		</div>
		<div class="d-flex justify-content-between">
			<p >All Projects</p>
			<a href="/projects/new" class="btn btn-warning">+ new project</a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<p class="my-4">Your Projects</p>
		<table class="table table-striped mt-3">
			<thead>
				<tr>
					<th>Project</th>
					<th>Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>