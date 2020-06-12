<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>




<html>
<body>

<c:set var="data" value="university">
</c:set>


Collection length Operations
<!--fn tag , collection length()  -->
<h3>length() demo</h3>
Length of the string <b>${data}</b>: ${fn:length(data)} 


<br><br>String manipulation operations
<!--fn tag , string manipulation functions  -->
<!--  toUpperCase()-->
<h3>toUpperCase() demo</h3>
Uppercase version of string <b>${data}</b>: ${fn:toUpperCase(data)}

<!--  toLowerCase()-->
<h3>toLowerCase() demo</h3>
lowercase version of string <b>${data}</b>: ${fn:toLowerCase(data)}

<!-- startWith() -->
<h3>toStartWith() demo</h3>
Does the string <b>${data}</b> start with <b>uni</b>?: ${fn:startsWith(data,"uni")}


<c:set var="mixedCity" value="Singapore,Tokyo,India"></c:set>
The cities string : ${mixedCity}
<!-- split() -->
<h3>split() demo</h3>
<c:set var="citiesArray" value="${fn:split(mixedCity, ',')}"></c:set>
The splitted cities:
	<c:forEach var="tempCity" items="${citiesArray}">
	<br>${tempCity}
	</c:forEach>


<!-- join() -->
<h3>join() demo</h3>
<c:set var="joinedCities" value="${fn:join(citiesArray,'*')}"></c:set>
<br>The cities joined together using * : ${joinedCities}

</body>
</html>


