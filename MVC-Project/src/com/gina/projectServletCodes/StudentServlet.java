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

		try {
		// list the students ... in mvc fashion
		listStudents(request, response);	
		}
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

	

}













