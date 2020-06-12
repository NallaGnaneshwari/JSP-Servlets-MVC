

<%@page import="com.gina.helpercodes.FunUtilities, java.util.ArrayList" %>

<html>
<head>

</head>
<body align="center">

<jsp:include page="header.html"/>

Hello world : <%=new java.util.Date() %>
<br>
Converting "hello world" into upper case <%=  new String("hello world").toUpperCase() %>
<br>
Computing 25 * 4 = <%=25*4%>
<br>
Is 25 > 100 ? <%=25>100 %>

<% for(int i=1;i<=5;i++){
	out.println("<br> 10*"+i+"="+10*i);
} %>


<%!
String makeItLower(String data){
	return data.toLowerCase();
}
%>

<br>
Now i'm making the above "HELLO WORLD" to lower case : <%= makeItLower("HELLO WORLD")%>
<br><br>
Now i'm appending some text to "hello world":<%= FunUtilities.appendText("hello world") %>
<br>
The user is working on browser: <%= request.getHeader("User-Agent") %>
<br>
The language of the user is: <%=request.getLocale() %>


<br><br><br><br>
<jsp:include page="footer.jsp"/>
</body>

</html>