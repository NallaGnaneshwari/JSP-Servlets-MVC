package com.gina.reviceMVC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MVCServletUsingOwnData1
 */
@WebServlet("/MVCServletUsingOwnData1")
public class MVCServletUsingOwnData1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MVCServletUsingOwnData1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//creating my own data:
		String[] people = {"Susan", "Anil", "Mohammed", "Trupti"};
		
		//step 1: Add the data from db or helper or  own data to the request object before dispatching it to JSP
		request.setAttribute("people_list", people);
		//step 2: call the JSP  (hey JSP i wanna dispatch the request to you)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc_view_people1.jsp");
		//step 3: forward the data to JSP
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


// run the servlet and the data will be send to JSP and JSP will generate an HTML
// corresponding jsp: mvc_view_people1.jsp