<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Cafe Java</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Project Manager</h1>
			<p>A place for teams to manage projects</p>
		</div>
 		<h2 class="text-primary my-4">Register:</h2>
	    <form:form action="/register" method="post" modelAttribute="newUser">
	        <div class="form-group">
	            <label>First Name:</label>
	            <form:input path="firstName" class="form-control" />
	            <form:errors path="firstName" class="text-danger" />
	        </div>
	        <div class="form-group">
	            <label>Last Name:</label>
	            <form:input path="lastName" class="form-control" />
	            <form:errors path="lastName" class="text-danger" />
	        </div>
	        <div class="form-group">
	            <label>Email:</label>
	            <form:input path="email" class="form-control" />
	            <form:errors path="email" class="text-danger" />
	        </div>
	        <div class="form-group">
	            <label>Password:</label>
	            <form:password path="password" class="form-control" />
	            <form:errors path="password" class="text-danger" />
	        </div>
	        <div class="form-group">
	            <label>Confirm Password:</label>
	            <form:password path="confirm" class="form-control" />
	            <form:errors path="confirm" class="text-danger" />
	        </div>
	        <input type="submit" value="Register" class="btn btn-primary mt-2" />
	    </form:form>
	    
	    <h2 class="text-primary my-4">Login:</h2>
	    <form:form action="/login" method="post" modelAttribute="newLogin">
	        <div class="form-group">
	            <label>Email:</label>
	            <form:input path="email" class="form-control" />
	            <form:errors path="email" class="text-danger" />
	        </div>
	        <div class="form-group">
	            <label>Password:</label>
	            <form:password path="password" class="form-control" />
	            <form:errors path="password" class="text-danger" />
	        </div>
	        <input type="submit" value="Login" class="btn btn-success mt-2" />
	    </form:form>
	</div>
    
</body>
</html>