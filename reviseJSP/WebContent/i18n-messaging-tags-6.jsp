<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>

<head>
<title>Multi Lingual Application</title>
</head>


<body>

<!-- picking the locale -->
<c:set var="theLocale" value="${not empty param.theLocale?param.theLocale:pageContext.request.locale}"></c:set>
<!-- setting the locale -->
<fmt:setLocale value="${theLocale}"></fmt:setLocale>
<!--setting the resource bundle-->
<fmt:setBundle basename="com.gina.helpercodes.i18n.resources.mylabels"></fmt:setBundle>


<a href="i18n-messaging-tags-6.jsp?theLocale=en_US" >English (US)</a>
<a href="i18n-messaging-tags-6.jsp?theLocale=es_ES" >Spanish (ES)</a>
<a href="i18n-messaging-tags-6.jsp?theLocale=de_DE" >Germany (DE)</a>
<hr>

<fmt:message key="label.greet"></fmt:message><br><br>
<fmt:message key="label.firstname"></fmt:message><i>John</i><br><br>
<fmt:message key="label.lastname"></fmt:message><i>Doe</i><br><br>
<fmt:message key="label.welcome"></fmt:message>


<hr>
The selected Locale is: ${theLocale}


</body>
</html>