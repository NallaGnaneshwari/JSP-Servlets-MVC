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


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//Reference for Instance of StudentDbUtil
	private StudentDbUtil studentDbUtil;

	//step 1: do the resource injection
	@Resource(name="jdbc/student_database")

	//step 2: get a reference to the connection pool / dataSource
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();

		//create instance of studentDBUtil and pass in the connection pool reference
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// read the command parameter (hidden field) submitted by form
		String theCommand = request.getParameter("command");
		
		//if the command is missing, then default to listing students
		if(theCommand==null) {
			theCommand="LIST";
		}
		
		
		//routing to appropriate method - simply list/add/update
		
		try {
			switch(theCommand) {
			
				case "LIST":
					listStudents(request,response);
					break;
				
				case "ADD":
					addStudent(request,response);
					break;
					
				case "LOAD":
					loadStudent(request,response);
					break;
					
				default:
					listStudents(request,response);
				}
	
		}
		
		//		try {
		//		// list the students ... in mvc fashion
		//		listStudents(request, response);	
		//		}
		
		catch (Exception e) {
			throw new ServletException(e);
		}
		
	}




	


	


	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			// get students from db util
			List<Student> students = studentDbUtil.getStudents();

			//step 3: add the data to the request object before dispatching it
			request.setAttribute("STUDENT_LIST", students);

			//step 4: Call the JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");

			//step 5: forward the data to JSP
			dispatcher.forward(request, response);
		
	}
	

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
			//read student info from the form data
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
		
			//create a new student object
			Student tempStudent = new Student(firstName, lastName,email);
		
			
			//add that student into the database
			studentDbUtil.addStudent(tempStudent);
		
			
			//send back to the main page (the student list)
			listStudents(request,response);
		
			
	}


	private void loadStudent(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//read student id from the from data
		String theStudentId = request.getParameter("studentId");
		
		//get the student from db using that id (db util)
		Student theStudent = studentDbUtil.getStudent(theStudentId);
		
		//give this fetched student to the JSP page by adding it to request object
		request.setAttribute("THE_STUDENT", theStudent);
		
		//send the data to JSP page (update-student-form) to prepopulate
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
		

		
	}
	
}

		
		
	















