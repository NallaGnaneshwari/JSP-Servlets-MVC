<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Update Student</title>
<link type="text/css" rel="stylesheet" href="CSS/pagestyle.css"><link>
<link type="text/css" rel="stylesheet" href="CSS/add-student-style.css"/>
<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
</head>


<body>
<h1>University Of Cincinnati</h1>
<hr>
	
	
	<div id="container">
		<h3>Update Student</h3>
		
		<form action="StudentServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />   <!-- hidden form field -->
			<input type="hidden" name="studentId" value="${THE_STUDENT.id}" />
			
			<table>
				
				
				<tr>
					<td><label>First name:</label></td>
					<td><input type="text" name="firstName" value="${THE_STUDENT.firstName}" /></td>
				</tr>

				<tr>
					<td><label>Last name:</label></td>
					<td><input type="text" name="lastName" value="${THE_STUDENT.lastName}" /></td>
				</tr>

				<tr>
					<td><label>Email:</label></td>
					<td><input type="text" name="email" value="${THE_STUDENT.email}" /></td>
				</tr>
					
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
					
				
			</table>
		</form>
		
	
		<p>
			<a href="StudentServlet">Back to List</a>
		</p>
	</div>
	
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="JS/style.js"></script>
</body>

</html>