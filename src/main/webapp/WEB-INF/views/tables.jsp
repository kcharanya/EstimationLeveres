<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><b>Vanguard</b></a> <a
			class="navbar-brand" href="home"><b>Home</b></a>
	</nav>
	<div style="width:100% ; margin:100px 0px; text-align:center">
	<h3>SELECT PHASE</h3>
	<form:form action="tablechoice" method="POST">
		<select name="Choice">
			<option value="3A">3A</option>
			<option value="3B">3B</option>
			<option value="3C">3C</option>
		</select>
		<input type="submit" value="Submit">
	</form:form>
	</div>
	
	<!-- <br>
	<a href="home"><button type="submit">HOME PAGE</button></a> -->

</body>
</html>