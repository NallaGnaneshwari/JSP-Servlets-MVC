package com.gina.reviseServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloWorldServlet1")
public class HelloWorldServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HelloWorldServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step 1: set the content type --> telling browser that this the type of content i'm gonna send you
		response.setContentType("text/html");
		//step 2: get printWriter handler (response object's writer)
		PrintWriter out = response.getWriter();
		//step 3: generate html
		out.println("<html><body>");
		out.println("<h2>Hello World!</h2>");
		out.println("<hr>");
		out.println("Time on the server is:"+new java.util.Date());
		out.println("</html></body>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


//just execute the servlet