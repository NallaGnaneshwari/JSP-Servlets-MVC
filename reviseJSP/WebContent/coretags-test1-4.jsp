<%@  page import="com.gina.helpercodes.Student,java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
<head></head>

<body>


<!-- c:set -->
<c:set var="stuff" value= "<%=new java.util.Date() %>"/>
Time on the server is ${stuff}
<br>



<br> Using c:forEach<br>
<!-- simple c:forEach -->
<%
//setting up sample data...., usually provided by MVC
String[] cities = {"Mumbai", "singapore", "Philadelhia"};
//to use JSTL tags, the data has to be a part of the attributes of either of request, session or application, page context
pageContext.setAttribute("myCities", cities);
%>

<!-- Printing the above list of cities  -->
<c:forEach var="tempCity" items="${myCities}">
${tempCity}<br>
</c:forEach>





<!-- tough c:forEach -->
<%
//setting up sample data.... usually provided by MVC
List<Student> data = new ArrayList<>();
data.add(new Student("Ajay", "Rao",false));
data.add(new Student("John", "Doe",false));
data.add(new Student("Mary","Doe",true));
/*Adding the above data into one of the attribute context of request or session or application or pageContext  */
pageContext.setAttribute("myStudents", data);
%>

<!-- Printing the above list of students  -->
<table border="1">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gold Student</th>
	</tr>

<c:forEach var="tempStudent" items="${myStudents}">
	<tr>
		<td>${tempStudent.firstName}</td>
		<td>${tempStudent.lastName}</td>
		<td>${tempStudent.goldCustomer}</td>
	</tr>
</c:forEach> 

</table>





<br> Using c:if <br>
<!-- c:if  -->
<%
//setting up sample data.....usually provided by MVC
List<Student> customerData = new ArrayList<>();
customerData.add(new Student("Ajay","Rao",false));
customerData.add(new Student("John","Doe",false));
customerData.add(new Student("Mary","Doe",true));
/*Adding the above data into one of the attribute context of request or session or application or pageContext  */
pageContext.setAttribute("myCustomers",customerData);
%>

<!-- Printing the above list of customers and offering a discount if they are a golden customer -->
<table border=1>
	<tr>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Gold Customer</th>
	</tr>


	<c:forEach var="tempCustomer" items="${myCustomers}">
	<tr>
		<td>${tempCustomer.firstName}</td>
		<td>${tempCustomer.lastName}</td>
		
		
		<td>
			<c:if test="${tempCustomer.goldCustomer}">
			Special Discount
			</c:if>
			
			<c:if test="${not tempCustomer.goldCustomer}">
			No Discount
			</c:if>
		</td>
		
		
	</tr>
	
	</c:forEach>
	
</table>





<br> Using c:choose <br>
<!-- c:choose  c:when, c:otherwise -->
<%
//setting up sample data.....usually provided by MVC
List<Student> switchData = new ArrayList<>();
switchData.add(new Student("Ajay", "Rao", false));
switchData.add(new Student("John","Doe",false));
switchData.add(new Student("Mary","Com",true));
/* Adding above data into one of the attribute context of request or session or application or page context */
pageContext.setAttribute("mySwitchs", switchData);
%>

<!-- Printing the above list of customers and offering a discount when they are a golden customer  -->
<table border=1>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gold Customer</th>
	</tr>

	<c:forEach var="tempSwitch" items="${mySwitchs}">
		<tr> 
			<td>${tempSwitch.firstName}</td>
			<td>${tempSwitch.lastName}</td>
			<td>
				<c:choose>
					<c:when test="${tempSwitch.goldCustomer}">
					Discount applicable
					</c:when>
				
					<c:otherwise>
					No Discount for you
					</c:otherwise>
				
				</c:choose>
			
			</td>
		</tr>
	</c:forEach>
	


</table>



</body>

</html>