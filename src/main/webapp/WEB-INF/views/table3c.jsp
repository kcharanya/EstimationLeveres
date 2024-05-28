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
	<h1 style="background-color: brown; color: aliceblue;">3C
		Estimation Input</h1>
	<div class="container flex justify-center">
		<form:form action="input3c" method="POST">
			<table class="table table-hover table-striped table-sm w-50"
				style="margin: auto">

				<thead>
			<tr>
				<th>Parameter</th>
				<th>Value</th>
			</tr>
			</thead>
				<tr>
					<td>#Tables</td>
					<td><input name="tablesValue" type="number" value="0" /></td>
				</tr>
				<tr>
					<td>#Total Jobs</td>
					<td><input name="totaljobsValue" type="number" value="0" /></td>
				</tr>
				<tr>
					<td>#SR's</td>
					<td><input name="srValue" type="number" value="0" /></td>
				</tr>
				<tr>
					<td>#C Jobs</td>
					<td><input name="cjobsValue" type="number" value="0" /></td>
				</tr>
				<tr>
					<td>#SP's</td>
					<td><input name="spValue" type="number" value="0" /></td>
				</tr>

			</table>
        <div style="width: 100%; text-align: center">
				<input type="submit" class="btn btn-success" value="Submit">
			</div>
			
		</form:form>
		<!--  <a href="home"><button type="submit">HOME PAGE</button></a> -->
		</div>
</body>
</html>