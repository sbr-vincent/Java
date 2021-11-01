<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>View Product</title>
</head>
<body>
	<div class="container">	
		<div class="navbar d-flex justify-content-between my-3 border-bottom border-5 border-success px-2">
			<h2> <a href="/dashboard" style="text-decoration: none"  class="text-dark"> Gnome Sweet Gnome </a></h2>
				
			<div class="rightNav">
				<a href="/cart" style="text-decoration: none" class="text-dark">
					<svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-cart3 mr-3" viewBox="0 0 16 16">
			  			<path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>						
					</svg>
				</a>
				<a href="/products/new" class="btn btn-success ml-3">Create Product</a>
				<a href="/logout" class="btn btn-danger ml-3">Logout</a>
			</div>
		</div>
		
		<nav aria-label="breadcrumb" class="m-2">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="/dashboard">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Lawn Gnomes</li>
		  </ol>
		</nav>
		
		<div class="main d-flex justify-content-center">
			<img src="${ oneProduct.image }" style="width:18rem; height:18rem;" class="mr-2" alt="Gnome statue">
			<div class="card text-center" style="width: 14rem;">
				<div class="card-body">
					<h4 class="card-title"> <a href="/products/${oneProductID}"></a> ${ oneProduct.name }</h4>
					<p class="fw-bold">Description:</p>
					<p class="card-text"> ${ oneProduct.description }</p>
					<p class="card-text"> $ ${ oneProduct.price }</p>
					<a href="###" class="btn btn-success">Add to cart</a>							
				</div>
			</div>
		</div>
	</div>
</body>
</html>