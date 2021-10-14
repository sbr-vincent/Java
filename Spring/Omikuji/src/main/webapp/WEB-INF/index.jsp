<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji" method="post">
		<label>Pick any number from 5 to 25</label>
		<input type="number" name="number" min="5" max="25">
		<br>
		<label>Enter the name of any city.</label>
		<input type="text" name="city">
		<br>
		<label>Enter the name of any real person.</label>
		<input type="text" name="person">
		<br>
		<label>Enter professional endeavor or hobby.</label>
		<input type="text" name="hobby">
		<br>
		<label>Enter any type of living thing.</label>
		<input type="text" name="thing">
		<br>
		<label>Say something nice to someone:</label>
		<textarea rows="3" cols="23" name="saying"></textarea>
		<p>Send and show a friend</p>
		<input type="submit" value="Send">
	</form>
</body>
</html>