<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	<h5 style="background-color: brown; color: aliceblue; " colspan="20">
		POD Sprint Hours(for Mining Hours)</h5>


<div class="container flex justify-center" >
		<table class="table table-hover table-striped table-sm" style="margin:auto" >
			<tr>
				<td><label for="firstName">Productive days / sprint (1
						day planned for Sprint Ceremonies and another day for holiday /
						pto)</label></td>
				<td>${podInput.firstName}</td>
			</tr>
			<tr>
				<td><label for="secondName">Billed hours per person per
						day</label>
				<td>${podInput.secondName}</td>
			</tr>
			<tr>
				<td><label for="thirdName">Each Miner focuses on 2
						story points / day</label></td>
				<td>${podInput.thirdName}</td>
			</tr>
			<tr>

				<td><label for="fourthName">Number of practitioners per
						POD</label></td>
				<td>${podInput.fourthName}</td>
			</tr>
			<tr>
				<td><label for="fifthName">Number of story points per
						sprint</label></td>
				<td>${podInput.fifthName}</td>
			</tr>
			<tr>

				<td><label for="sixthName">Billed hours per person per
						sprint (considering holidays)</label></td>
				<td>${podInput.sixthName}</td>
			</tr>
			<tr>
				<td><label for="seventhName">Number of sprints per year</label></td>
				<td>${podInput.seventhName}</td>
			</tr>
			<tr>
				<td><label for="eightName">Billing rate per hour for SC</label></td>
				<td>${podInput.eightName}</td>
			</tr>
			<tr>
				<td><label for="ninthName">Billing rate per hour for C</label></td>
				<td>${podInput.ninthName}</td>
			</tr>
			<tr>
				<td><label for="tenName">Billing rate per hour for BA</label></td>
				<td>${podInput.tenName}</td>
			</tr>
		</table>
		
		<div style="width:100%;text-align:center">
		
		<a href="estimationlevers"><button type="submit" class="btn btn-success">Go To Estimation levers</button> </a>
		
		
		<a href="podassumptions"><button type="submit" class="btn btn-warning">Edit Pod Assumptions</button> </a>

<br>
	<!-- <a href="home"><button type="submit">HOME PAGE</button></a>
	<br> -->
	
	</div>
	</div>



</body>

</html>
