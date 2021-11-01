<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Checkout</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content-between mt-4 border-bottom border-5 border-success">
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
		
		<form action='/charge' method='POST' id='checkout-form'>
		    <input type='hidden' th:value='${amount/100}' name='amount' />
		    <label>Price:<span th:text='${amount/100}' /></label>
		    <!-- NOTE: data-key/data-amount/data-currency will be rendered by Thymeleaf -->
		    <script
		       src='https://checkout.stripe.com/checkout.js' 
		       class='stripe-button'
		       th:attr='data-key=${stripePublicKey}, 
		         data-amount=${amount}'
		       data-name='Gnome Sweet Gnome'
		       data-description='Product checkout'
		       data-image
		         ='https://www.baeldung.com/wp-content/themes/baeldung/favicon/android-chrome-192x192.png'
		       data-locale='auto'
		       data-zip-code='false'>
		   </script>
		</form>
	</div>
</body>
</html>