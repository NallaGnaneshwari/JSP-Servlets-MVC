
package com.gina.projectServletCodes;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




@WebServlet("/StudentServlet_tbd")
public class StudentServlet_tbd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentServlet_tbd() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    //step1:
	
  	//Resource injection & get a reference to the connection pool
  	@Resource(name="jdbc/student_database")
  	private DataSource dataSource;
  	
  	//create an instance of DB Utility class
  	private StudentDBUtility_tbd studentDBUtility;
  	@Override 
  	public void init() {
  		studentDBUtility = new StudentDBUtility_tbd(dataSource);
  	}
  	
	
  	// step 2:
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the data
		List<Student> students = studentDBUtility.getStudents();
		
		//adding it to the request object
		request.setAttribute("STUDENT_LIST", students);
		
		//call JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		
		//forward the data to JSP
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
