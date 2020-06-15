<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.gina.projectServletCodes.*, java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>Listing Students</title>
	
<link type="text/css" rel="stylesheet" href="CSS/pagestyle.css"><link>
<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
</head>

<body>

<%-- <% List<Student> students = (List<Student>)request.getAttribute("STUDENT_LIST");
%>
<c:set var="students" value="${students}"></c:set>  --%>

	
<h1>University Of Cincinnati</h1>
<hr>		

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Student" 
				   onclick="window.location.href='add-student-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempStudent" items="${STUDENT_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="StudentServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
						<!-- Create an Update link with "id" embedded in it.
 						Making use of JSTL c:url & c:param tags -->
						<td> 
							<a href="${tempLink}">Update</a> 
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script src="JS/style.js"></script>
</body>


</html>
