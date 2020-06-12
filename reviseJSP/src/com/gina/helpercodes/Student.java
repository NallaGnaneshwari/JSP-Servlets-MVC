package com.gina.helpercodes;

public class Student {
private String firstName;
private String lastName;
private boolean goldCustomer;

public Student(String firstName, String lastName, boolean goldenCustomer) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.goldCustomer = goldenCustomer;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public boolean isGoldCustomer() {
	return goldCustomer;
}
public void setGoldCustomer(boolean goldenCustomer) {
	this.goldCustomer = goldenCustomer;
}
}
