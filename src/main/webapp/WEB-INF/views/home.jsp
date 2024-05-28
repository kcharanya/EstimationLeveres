<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
thead {
	background-color: grey;
	color: white;
}

td {
	border: 1px dashed black;
}
</style>
</head>
<body>
	<img
		src="https://logos-world.net/wp-content/uploads/2021/03/Vanguard-Logo.png"
		alt="vanguard title" width=400>
	<h3 style="color: tomato;">RIG Modernization</h3>
	<h4>Mining Estate By Product Family</h4>
	<h5>Date:05/06/2024</h5>
	
	<table>
		<thead>
			<tr>
				<td colspan="30">Tabs Overview</td>
			</tr>
		</thead>


		<tr>
			<td colspan="15" style="background-color: grey;">POD ESTIMATION</td>
			<td>Provides an estimate of the PODs required for the product
				family selected by the user</td>

		</tr>
		<tr>
			<td colspan="15" style="background-color: grey;"><a
				href="displaypodassumptions" target="_blank"><button
						type="submit">
						<b>POD ASSUMPTIONS</b>
					</button></a></td>
			<td>Lists out all the assumptions that have been considered for
				effort estimation</td>
		</tr>
		<tr>
			<td colspan="15" style="background-color: grey;"><a
				href="estimationlevers" target="_blank"><button
						type="submit">
						<b>TEMPLATE</b>
					</button></a></td>
			<td>Outlines the estimation levers,story point per lever</td>
		</tr>
	


	</table>


</body>
</html>