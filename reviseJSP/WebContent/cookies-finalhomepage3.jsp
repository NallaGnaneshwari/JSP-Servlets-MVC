<html>
<head><title>Training portal</title></head>


<body>
<h1>Training Portal</h1>
<%
String lang = "java";
Cookie[] cookies = request.getCookies();
if(cookies !=null){
	for(Cookie tempCookie : cookies){
		if(tempCookie.getName().equals("myApp.favoriteLanguage")){
			lang=tempCookie.getValue();
			break;
		}
	}
}
%>

New Books for <%= lang %> 
	<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
	</ul>

Latest News reports for <%= lang %> 

<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
	</ul>

Hot Jobs for <%= lang %>

<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
	</ul>

<a href="cookies-form3.html">Personalize this page</a>
</body>
</html>