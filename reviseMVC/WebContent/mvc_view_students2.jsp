<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>


<body>
<h3>The List of students:</h3>
<hr>


<table border='1'>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>
	<c:forEach var="tempStudent" items="${student_list}">
	<tr>
		<td>${tempStudent.firstName}</td>
		<td>${tempStudent.lastName}</td>
		<td>${tempStudent.email}</td>
	</tr>

</c:forEach>
</table>

</body>
</html>



<!-- corresponding servlet:MVCServletUsingHelperClass2
This JSP will receive data from the the above servlet and generate the html
 -->