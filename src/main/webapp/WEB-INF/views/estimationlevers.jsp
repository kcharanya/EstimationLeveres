<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark" >
		<a class="navbar-brand" href="#"><b>Vanguard</b></a> 
		<a class="navbar-brand" href="home"><b>Home</b></a>
	</nav>
	
	<div style="width:100% ; margin:100px 0px; text-align:center">
	<h2>
	<b>PRODUCT FAMILY</b>
		<!-- <b>ENTER PRODUCT FAMILY</b> -->
	</h2>
	<h4>${message}</h4>



	<form:form action="estimationleverinput" method="POST">
	<!-- 	<label for="prodfamily">Product Family</label> -->
		<input type="text" id="prodfamily" name="prodfamily" placeholder="Enter product family">
		<input type="submit" value="Submit">
	</form:form>

	<!-- <br>
	<a href="home"><button type="submit">HOME PAGE</button></a>
	<br> -->
	
	</div>
	
</div>
</body>
</html>


