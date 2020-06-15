<%@ page import="com.gina.projectServletCodes.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listing Students</title>
<link type="text/css" rel="stylesheet" href="CSS/pagestyle.css"><link>
<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
</head>
<body>

<%-- <% List<Student> students = (List<Student>)request.getAttribute("STUDENT_LIST");
%>
<c:set var="students" value="${students}"></c:set>  --%>


<h1>University Of Cinicinnati</h1>
	
<hr>

<div id="container">
<div id="content">

<input type ="button" value="Add Student" class ="add-student-button" onclick="window.location.href='add-student-form.jsp';return false;"/>


<table >
	<thead>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</thead>
	
	<c:forEach var="tempStudent" items="${STUDENT_LIST}">
		<tr>
			<td>${tempStudent.firstName}</td>
			<td>${tempStudent.lastName}</td>
			<td>${tempStudent.email}</td>
		</tr>
	
	</c:forEach>
	
</table>


</div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="JS/style.js"></script>
</body>
</html>