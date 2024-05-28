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
	<h3 style="text-align: center">SUMMARY</h3>
	<div class="container flex justify-center">

		<table class="table table-hover table-striped table-sm"
			style="margin: auto">
			<thead>

				<tr>
					<th>sNo</th>
					<th>productFamily</th>
					<th>Phase</th>
					<th>Impact Analysis</th>
					<th>jobs</th>
					<th>SR</th>
					<th>SP</th>
					<th>Total Story Points</th>
					<th>Number of Pod Sprints</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${summaryList}" varStatus="loop">
					<tr>
						<td>${loop.count}</td>
						<td>${item.productFamily}</td>
						<td>${item.tableName}</td>
						<td>${item.impactAnlaysis}</td>
						<td>${item.jobs}</td>
						<td>${item.sr}</td>
						<td>${item.sp}</td>
						<td>${item.tsp}</td>
						<td>${item.nps}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<h4>${message}</h4>


	<!-- <br>
	<a href="home"><button type="submit">HOME PAGE</button></a>
	<br> -->

</body>
</html>



