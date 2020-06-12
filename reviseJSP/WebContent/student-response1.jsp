




<html>
<head>
<title>JSP response after reading the form data</title>
</head>


<body>
<h3>You have successfully registered!!</h3><br>
The student is confirmed ${param.firstname} ${param.lastname}<br>
The student country is : <%= request.getParameter("country") %><br>
The student's favorite language is: <%= request.getParameter("favoriteLanguage") %><br>
The student's favorite libraries and frameworks are:
<ul>
	<% 
	String[] languages = request.getParameterValues("favoriteFramework");
	if(languages!=null){  /*since checkbox returns multiple values  */
	for(String tempLang:languages){
		out.println("<li>"+ tempLang+"</li>");
		}
	}
	%>
	
</ul>


</body>
</html>