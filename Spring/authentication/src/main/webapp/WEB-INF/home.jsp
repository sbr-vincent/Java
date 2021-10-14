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
    <h1 class="text-success">Welcome <c:out value="${ loggedInUser.userName }" /></h1>
    
    <a href="/logout" class="btn btn-danger">Logout</a>
</body>
</html>