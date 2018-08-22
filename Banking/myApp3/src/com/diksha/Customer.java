package com.diksha;

public class Customer {
	
	private String title;
	private String firstname;
	private String lastname;
	private String Age;
	private String DOB;
	private String PAN;
	
	public Customer(String title, String firstname, String lastname, String age, String dOB,String PAN) {
		super();
		this.PAN=PAN;
		this.title = title;
		this.firstname = firstname;
		this.lastname = lastname;
		Age = age;
		DOB = dOB;
	}
	
	
	public String getPAN() {
		return PAN;
	}


	public void setPAN(String pAN) {
		PAN = pAN;
	}


	public Customer() {
		super();
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Customer [title=" + title + ", firstname=" + firstname + ", lastname=" + lastname + ", Age=" + Age
				+ ", DOB=" + DOB+ "]";
	}
	
	
	

}
