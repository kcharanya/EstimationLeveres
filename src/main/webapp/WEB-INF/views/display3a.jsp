<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
   $(document).ready(function() {
       $('form').on('submit', function(e)   {
    
        e.preventDefault();
        var confirmUpdate = confirm('Do you want to save data to the database?');
        
        var formData = $(this).serialize() + "&confirmUpdate=" + confirmUpdate	
       
        $.ajax({
            type: "GET",
            url: $(this).attr('action'),
            data: formData,
            contentType: "application/json",
            success: function(data) {
                console.log(data);
                window.location.href = "/vanguard/summary"; // redirect to the summary page
            },
            error: function(e) {
                console.log("ERROR : ", e);
            }
        });
    
   
       });
   });
</script>
<title></title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><b>Vanguard</b></a> <a
			class="navbar-brand" href="home"><b>Home</b></a>
	</nav>
	<table class="table border border-secondary">
		<tr>
			<th style="background-color: brown; color: aliceblue; width: 15px"
				colspan="120">Estimation Summary(3P)</th>
		</tr>

		<tr style="background-color: brown; color: aliceblue;">
			<td>Category</td>
			<td colspan="10">3A</td>
			<td colspan="10">3B</td>
			<td colspan="10">3C</td>
		</tr>

		<tr>
			<td>Impact analysis</td>
			<td colspan="10">${output3a.iAsum}</td>
			<td colspan="10">${output3b.iAsum}</td>
			<td colspan="10">${output3c.iAsum}</td>



		</tr>

		<tr>
			<td>Jobs</td>
			<td colspan="10">${output3a.jobSum}</td>
			<td colspan="10">${output3b.jobSum}</td>
			<td colspan="10">${output3c.jobSum}</td>

		</tr>
		<tr>
			<td>SR's</td>
			<td colspan="10">${output3a.SRSum}</td>
			<td colspan="10">${output3b.SRSum}</td>
			<td colspan="10">${output3c.SRSum}</td>

		</tr>
		<tr>
			<td>SP's</td>
			<td colspan="10">${output3a.SPSum}</td>
			<td colspan="10">${output3b.SPSum}</td>
			<td colspan="10">${output3c.SPSum}</td>

		</tr>
		<tr style="background-color: brown; color: aliceblue;">
			<td>Total Story Points</td>
			<td colspan="10"><c:set var="TSP3A"
					value="${output3a.iAsum + output3a.jobSum + output3a.SRSum + output3a.SPSum}" />
				${TSP3A}</td>
			<td colspan="10"><c:set var="TSP3B"
					value="${output3b.iAsum + output3b.jobSum + output3b.SRSum + output3b.SPSum}" />
				${TSP3B}</td>

			<td colspan="10"><c:set var="TSP3C"
					value="${output3c.iAsum + output3c.jobSum + output3c.SRSum + output3c.SPSum}" />
				${TSP3C}</td>


		</tr>
		<br>
		<tr style="background-color: brown; color: aliceblue;">
			<td>No Of POD Sprints</td>
			<td colspan="10"><c:set var="NPSA" value="${TSP3A/fifthname}" />
				${NPSA}</td>
			<td colspan="10"><c:set var="NPSB" value="${TSP3B/fifthname}" />
				${NPSB}</td>
			<td colspan="10"><c:set var="NPSC" value="${TSP3C/fifthname}" />
				${NPSC}</td>
		</tr>
		<br>
	</table>
	<form:form action="summary" method="GET">
 	<div style="width:100%;text-align:center">
 	<input type="submit" class="btn btn-success" value="Summary">
 	</div>
 	</form:form>
	<h2>3A Table</h2>
	<table class="table table-hover table-striped table-sm" style="margin:auto">
		<thead>
			<tr>
				<th>Category</th>
				<th>Sl No:</th>
				<th>Estimation Levers</th>
				<th>Value</th>
				<th>Story Points Per Unit</th>
				<th>Total Story Points</th>
				<th>Notes</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="item" items="${list3A}">
				<tr>
					<td>${item.category}</td>
					<td>${item.sno}</td>
					<td>${item.ELevers}</td>
					<td>${item.value}</td>
					<td>${item.SPUnit}</td>
					<td>${item.TSP}</td>
					<td>${item.notes}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

 	
 	
 	<!-- <br>
	<a href="home"><button type="submit">HOME PAGE</button></a>
	<br> -->
</body>
</html>