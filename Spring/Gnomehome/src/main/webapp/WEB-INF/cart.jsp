<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Checkout Cart</title>
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
				<a href="/dashboard" class="btn btn-dark ml-3">Home</a>
				<a href="/logout" class="btn btn-danger ml-3">Logout</a>
			</div>
		</div>
		<c:if test="${ cart.size() == 0 }"> 
			<div class="text-center">
				<h1>Your Cart is Empty</h1> 
				<img src="data:image/png;base64,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" alt="Gnome Image" />
			</div>
		</c:if>
		<c:if test="${ cart.size() > 0 }">
			<div class="main d-flex justify-content-evenly">
				<div class="col-6 border border-1">
					<h4 class="text-center">Cart: $ <c:out value="${ orderTotal }"/> (<c:out value="${ cart.size() }"/> Gnomes)</h4>
					<table class="table table-striped table-hover">
					
						<thead>
							<tr>
								<th>Name</th>
								<th>Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="oneProduct" items="${ cart }"> 
									<tr>
										<td>${ oneProduct.name }</td>
										<td> $${ oneProduct.price }</td>
										<td> <a href="/delete/cartItem/${ cart.indexOf(oneProduct) }" class="btn btn-outline-danger" style="text-decoration: none"> X </a> </td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-4">
					<h5>Order Summary</h5>
					<p>Subtotal: (<c:out value="${ cart.size() }"/>)  $<c:out value="${ total }"/></p>
					<p>Delivery: Free</p>
					<p>Estimated tax:  $<c:out value="${ tax }"/></p>
					<hr />
					<p class="fw-bold">Total: $<c:out value="${ orderTotal }"/> </p>
					<form action="/checkout" method="POST">
				      <button type="submit">Checkout</button>
				    </form>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>