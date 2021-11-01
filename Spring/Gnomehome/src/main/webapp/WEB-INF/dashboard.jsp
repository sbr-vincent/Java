<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content-between my-3 border-bottom border-5 border-success">
			<h2> <a href="/dashboard" style="text-decoration: none"  class="text-dark"> Gnome Sweet Gnome </a></h2>
			
			<div class="rightNav">
				<a href="/cart" style="text-decoration: none" class="text-dark">
					<svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-cart3 mr-3" viewBox="0 0 16 16">
		  				<path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>						
					</svg>
				</a>
				<c:if test="${ loggedInUser.id == 1 }"><a href="/products/new" class="btn btn-success ml-3">Create Product</a></c:if>
				<a href="/logout" class="btn btn-danger ml-3">Logout</a>
				
			</div>
		</div>
	
		<div class="d-flex flex-wrap justify-content-evenly">
			<c:forEach var="oneProduct" items="${ allProducts }">
				<div class="col-3">
					<div class="card text-center" style="width: 12rem;">
						<img src="${ oneProduct.image }" style="width:12rem; height:12rem;" class="card-img-top" alt="Lawn Gnome">
						<div class="card-body">
							<h5 class="card-title"> <a href="/products/${oneProduct.id}"  class="text-dark" style="text-decoration:none"> ${ oneProduct.name } </a></h5>
							<p class="card-text"> ${ oneProduct.description }</p>
							<p class="card-text"> $ ${ oneProduct.price }</p>
							<a href="/products/${oneProduct.id}/addCart" class="btn btn-success">Add to cart</a>		
							<c:if test="${ loggedInUser.id == 1 }"><a href="/products/${ oneProduct.id }/edit" class="btn btn-danger">Edit</a></c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>