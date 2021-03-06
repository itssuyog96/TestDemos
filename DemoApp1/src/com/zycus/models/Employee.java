package com.zycus.models;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3206762648918992327L;
	private String firstName, lastName;
	private String designation;
	private int age;

	public Employee(String firstName, String lastName, String designation, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.age = age;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", designation=" + designation + ", age="
				+ age + "]";
	}
}
