
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
List of people:
<c:forEach var="tempPeople" items="${people_list}">
<br>${tempPeople}
</c:forEach>

</body>
</html>


<!-- corresponding servlet:MVCServletUsingOwnData
This JSP will receive data from the the above servlet and generate the html
 -->