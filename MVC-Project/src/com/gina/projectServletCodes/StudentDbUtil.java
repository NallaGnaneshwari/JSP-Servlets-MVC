// This is a helper class



package com.gina.projectServletCodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	//Reference to data source (for the one which comes from servlet)
	private DataSource dataSource;


	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	//JDBC code:
	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		//step 1: get the connection
		//step 2: create a sql statement
		//step 3: execute the query
		//step 4: process the result set
		//step 5: close the database object  (use finally{} )


		try {

			myConn = dataSource.getConnection();

			String sql = "select * from student order by last_name";
			
			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, email);
				
				// add it to the list of students
				students.add(tempStudent);				
			}
			
			return students;		
		}//end of try

		finally
		{
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addStudent(Student theStudent) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		//ResultSet myRs = null;

		//step 1: get a connection
		//step 2: create/prepare a statement
		//		set the parameter values
		//step 3: execute the query
		//step 4: process the result set
		//step 5: close the jdbc objects
		
		try {

			myConn = dataSource.getConnection();
			String sql = "insert into student (first_name, last_name, email) values (?, ?, ?)";
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());

			myStmt.execute();
		}
		finally
		{
			close(myConn, myStmt, null);
		}
	}

	public Student getStudent(String theStudentId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		int studentId;
		Student theStudent = null;

		//step 1: get a connection
		//step 2: create/prepare a sql statement
		//		set the parameter values
		//step 3: execute the query
		//step 4: process the result set
		//step 5: close the jdbc objects

		try {

			studentId = Integer.parseInt(theStudentId);

			myConn = dataSource.getConnection();
			String sql = "select * from student where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, studentId);
			myRs = myStmt.executeQuery();

			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				theStudent = new Student(studentId, firstName, lastName, email);
			}// end of if
			else {
				throw new Exception("Could not find student id: " + studentId);
			}				
			
			return theStudent;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
	}

	public void updateStudent(Student theStudent) throws Exception {

		//step 1: get a connection
		//step 2: create/prepare a statement
		// 	set the parameters for the statement
		//step 3: execute Query
		//step 4: process the result set
		//step 5: close all the jdbc objects

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {

			myConn = dataSource.getConnection();

			String sql = "update student set first_name=?, last_name=?, email=? where id=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getId());

			myStmt.execute();
		}
		finally {

			close(myConn, myStmt, null);
		}
	}

}















