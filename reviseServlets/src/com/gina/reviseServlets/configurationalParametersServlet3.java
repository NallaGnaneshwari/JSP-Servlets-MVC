package com.gina.reviseServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class configurationalParametersServlet3
 */
@WebServlet("/configurationalParametersServlet3")
public class configurationalParametersServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public configurationalParametersServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//step 1: set content type
		response.setContentType("text/html");
	
		//step 2: get printWriter 
		PrintWriter out = response.getWriter();
	
		// read the configurational parameters before generationg html, so that we can use them in html
		ServletContext context = getServletContext();
		String maxCartSize = context.getInitParameter("max-shopping-cart-size");
		String teamName = context.getInitParameter("project-team-name");
		
		//step 3: generate the html using printWriter
		out.println("<html><body> ");
		out.println("Max cart: "+maxCartSize);
		out.println("<br><br> ");
		out.println("Team Name: "+teamName);
		out.println("</html></body> ");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

// just run the servlet
