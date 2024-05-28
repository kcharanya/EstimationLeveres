<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
	<h5 style="background-color: brown; color: aliceblue; margin:10px 0">POD
		Assumptions</h5>
	<h5 style="background-color: brown; color: aliceblue;" colspan="20">
		POD Sprint Hours(for Mining Hours)</h5>
<div class="container flex justify-center" >

	<form:form action="podassumptionsinput" method="POST">
		<table class="table table-hover table-striped table-sm" style="margin:auto">
			<tr>
				<td><label for="firstName">Productive days / sprint (1
						day planned for Sprint Ceremonies and another day for holiday /
						pto)</label></td>
				<td><input type="number" id="firstName" name="firstName"
					pattern="^[0-9]*$" value="${podvalues.firstName}"></td>
			</tr>
			<tr>
				<td><label for="secondName">Billed hours per person per
						day</label>
				<td><input type="number" id="secondName" name="secondName"
					pattern="^[0-9]*$" value="${podvalues.secondName}"></td>
			</tr>
			<tr>
				<td><label for="thirdName">Each Miner focuses on 2
						story points / day</label></td>
				<td><input type="number" id="thirdName" name="thirdName"
					pattern="^[0-9]*$" value="${podvalues.thirdName}"></td>
			</tr>
			<tr>

				<td><label for="fourthName">Number of practitioners per
						POD</label></td>
				<td><input type="number" id="fourthName" name="fourthName"
					pattern="^[0-9]*$" value="${podvalues.fourthName}"></td>
			</tr>
			<tr>
				<td><label for="fifthName">Number of story points per
						sprint</label></td>
				<td><input type="number" id="fifthName" name="fifthName"
					pattern="^[0-9]*$" value="${podvalues.fifthName}"></td>
			</tr>
			<tr>

				<td><label for="sixthName">Billed hours per person per
						sprint (considering holidays)</label></td>
				<td><input type="number" id="sixthName" name="sixthName"
					pattern="^[0-9]*$" value="${podvalues.sixthName}"></td>
			</tr>
			<tr>
				<td><label for="seventhName">Number of sprints per year</label></td>
				<td><input type="number" id="seventhName" name="seventhName"
					pattern="^[0-9]*$" value="${podvalues.seventhName}"></td>
			</tr>
			<tr>
				<td><label for="eightName">Billing rate per hour for SC</label></td>
				<td><input type="number" id="eightName" name="eightName"
					pattern="^[0-9]*$" value="${podvalues.eightName}"></td>
			</tr>
			<tr>
				<td><label for="ninthName">Billing rate per hour for C</label></td>
				<td><input type="number" id="ninthName" name="ninthName"
					pattern="^[0-9]*$" value="${podvalues.ninthName}"></td>
			</tr>
			<tr>
				<td><label for="tenName">Billing rate per hour for BA</label></td>
				<td><input type="number" id="tenName" name="tenName"
					pattern="^[0-9]*$" value="${podvalues.tenName}"></td>
			</tr>
		</table>
		<div style="text-align:center">
		<input type="submit" class="btn btn-success" value="Submit">
		</div>

	</form:form>

	<!-- <br>
	<a href="home"><button type="submit">HOME PAGE</button></a>
	<br> -->

</div>
</body>

</html>
