package com.gina.reviseServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet2
 */
@WebServlet("/StudentServlet2")
public class StudentServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 1: set the content type --> telling browser that this the type of content i'm gonna send you
		response.setContentType("text/html");
		// step 2: get handler for response i.e., get a response writer object
		PrintWriter out = response.getWriter();
		// step 3: generate the html
		out.println("<html><body>");
		out.println(" <h3>The student has confirmed: "+request.getParameter("firstname")+" "+request.getParameter("lastname")+"</h3>");
		out.println("</html></body>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


//corresponding html : studentservlet2.html
// enter the data in the html form and submit, the data will be submitted to this servlet and the servlet will use that data and generate the html
// No need to execute this servlet separately