package com.gina.reviceMVC;

import java.util.ArrayList;
import java.util.List;



public class HelperClassUtil {
//creating helper class that will help us to access the model (Student Clas)
	
	public static List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Mary", "Public", "mary@gmail.com"));
		students.add(new Student("John", "Doe","john@gmail.com"));
		students.add(new Student("Ajay","Rao","ajay@gmail.com"));
		
		return students;
	}
	
}
