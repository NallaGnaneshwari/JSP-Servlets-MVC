package com.gina.projectServletCodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtility_tbd {

	private DataSource dataSource;
	
	public StudentDBUtility_tbd(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		Connection myConn= null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		// get a connection to the database
		try 
		{
			myConn = dataSource.getConnection();
			
			//create a sql statement
			String sql = "select * from student";
			myStmt = myConn.createStatement();
			
			//execute the query
			myRs = myStmt.executeQuery(sql);
		
			//process result set
			while(myRs.next()) {
				//retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				//create a new student object
				Student tempStudent = new Student(id,firstName, lastName,email);
				
				//add it to the list of students
				 students.add(tempStudent);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(myConn,myStmt, myRs);
		}
		
		return students;
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
	
		try {
		if(myConn!=null) 
			myConn.close();
		if(myStmt!=null)
			myStmt.close();
		if(myRs!=null)
			myRs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
