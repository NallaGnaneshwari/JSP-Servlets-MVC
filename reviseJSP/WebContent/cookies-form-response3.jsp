<html>
<head>
</head>

<body>
<h1>
Thanks! We set your favorite language to ${param.favoriteLanguage}
</h1>


<%
// Create a new cookie from the form data and send it back to the browser  -->

//read form data
String favLang = request.getParameter("favoriteLanguage");

// create a new cookie
Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);

// set age of the cookie
theCookie.setMaxAge(60*60*25*365);

//sending it back to the browser
response.addCookie(theCookie);

%>

<a href="cookies-finalhomepage3.jsp">Return to Home Page</a>
</body>
</html>