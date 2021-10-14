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
	
 		<h1 class="text-primary my-4">Register:</h1>
	    <form:form action="/register" method="post" modelAttribute="newUser">
	        <div class="form-group">
	            <label>User Name:</label>
	            <form:input path="userName" class="form-control" />
	            <form:errors path="userName" class="text-danger" />
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
	    
	    <h1 class="text-primary my-4">Login:</h1>
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