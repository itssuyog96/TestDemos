package com.zycus.banking;

import java.sql.Date;

public class Customer {

	private String id;
	private String title;
	private String firstName;
	private String lastName;
	private Date dob;
	public Customer(String title, String firstName, String lastName, Date dob) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.setId(Hash.generateHash(String.valueOf(System.currentTimeMillis())));
	}
	public Customer(String id, String title, String firstName, String lastName, Date dob) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
