<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add student</title>
<link type="text/css" rel="stylesheet" href="CSS/pagestyle.css"><link>
<link type="text/css" rel="stylesheet" href="CSS/add-student-style.css"/>
<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">


</head>
<body>

<h1>University of Cincinnati</h1>

<hr>

<div id="container">



<form action="StudentServlet" method="POST">

	<input type="hidden" name="command" value="ADD"/>  <!-- hidden form field -->
	
	<table>
		<tr><h3>Add Student</h3></tr>
		
		<tr>
			<td><label>First Name:</label></td>
			<td><input type="text" name="firstName" placeholder="your first name"/></td>
		</tr>
		
		<tr>
			<td><label>Last Name:</label></td>
			<td><input type="text" name="lastName" placeholder="your last name"/></td>
		</tr>
		
		<tr>
			<td><label>Email:</label></td>
			<td><input type="email" name="email" placeholder="example@gmail.com"/></td>
		</tr>
		
		 <tr>
		 	<td><label></label></td>
			<td>
				<input type="submit" value="Save" name="save"/>
			</td>
		
		</tr>
	
	</table>

	

	<p>
		<a href="StudentServlet">Back to List</a>
	</p>


</form>


</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="JS/style.js"></script>
</body>
</html>