<%@ page import="java.util.*" %>


<html>

<head>
<title>session tracking in JSP using a session object</title>
</head>


<!-- Step 1: Creating a form  -->
<body>
<form action="session-form2.jsp">
Add new item: <input type="text" name="listItem">
<input type="submit" value="submit">
<br><br>
The item entered is: ${param.listItem}
</form>



<!-- Step 2: Add new item to "To Do" list -->
<%
//  get the ToDo list from session and print it 
List<String> items = (List<String>)session.getAttribute("myToDoList");


// If "myToDoList" does not exists inside the "session" object, create one -->
if(items==null)
{
items = new ArrayList<String>();
session.setAttribute("myToDoList", items);
}

// After creating one, add values or items into it 
String listItem = request.getParameter("listItem");
if((listItem!=null)&&(!listItem.trim().equals("")))
{
items.add(listItem);
}

%>



<!-- Step 3: Display the contents of the to-do list  -->
<hr>
<b>To Do list items are:</b>
<ol>
<%
for(String s: items){
	out.println("<li>"+s+"</li>");
}
%>
</ol>


</body>
</html>






































