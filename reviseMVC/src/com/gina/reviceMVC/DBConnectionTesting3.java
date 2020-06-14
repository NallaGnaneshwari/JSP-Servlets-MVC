package com.gina.reviceMVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/DBConnectionTesting3")
public class DBConnectionTesting3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// step 1: Resource Injection
	@Resource(name="jdbc/student_database")
	//step 2: getting a refernce to the connection pool
	private DataSource dataSource;
	
   
    public DBConnectionTesting3() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step 1:set content type and get writer 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//step 2: get a connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
		myConn = dataSource.getConnection();
		
		//step 3: create a statement
		String sql = "select * from student";
		myStmt = myConn.createStatement();
		
		//step 4: execute the query
		myRs = myStmt.executeQuery(sql);
		
		//step 5: process the result set
		while(myRs.next()) {
			String email = myRs.getString("email");
			out.println(email +"<br>");
			
		}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
