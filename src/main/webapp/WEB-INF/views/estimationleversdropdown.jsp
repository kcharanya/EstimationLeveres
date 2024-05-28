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
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><b>Vanguard</b></a> <a
			class="navbar-brand" href="home"><b>Home</b></a>
	</nav>
	<h2 style="background-color: brown; color: aliceblue; margin:10px 0">Estimation
		levers</h2>
	<div style="width:100% ; margin:100px 0px; text-align:center">
	
	<form:form action="productfamilyinput" method="POST">
		<select name="Choice">
			<c:forEach items="${prodFamilies}" var="value">
				<option value="${value.productFamily}">${value.productFamily}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Submit">
	</form:form>
	</div>

</body>
</html>