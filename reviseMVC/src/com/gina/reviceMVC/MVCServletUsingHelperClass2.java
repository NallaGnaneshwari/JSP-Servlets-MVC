package com.gina.reviceMVC;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MVCServletUsingHelperClass2")
public class MVCServletUsingHelperClass2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MVCServletUsingHelperClass2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//step 1: get the data from the database/ helper class/ create your own data and add it to request object before dispatching the request object
		List<Student> students = HelperClassUtil.getStudents();
		request.setAttribute("student_list", students);
		
	//step 2: call the JSP 
		RequestDispatcher dispatcher =request.getRequestDispatcher("/mvc_view_students2.jsp");
		
	//step 3: send/forward data to jsp
		dispatcher.forward(request, response);
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


// Let's not run the servlet, let's create an html whose href would point to this servlet.
// And soon after we click on that href in html, it will call and run the servlet, the servlet will
// then send the data to jsp and jsp will generate an html.

// corresponding html: mvc_view_students2.html
// corresponding jsp: mvc_view_students2.jsp