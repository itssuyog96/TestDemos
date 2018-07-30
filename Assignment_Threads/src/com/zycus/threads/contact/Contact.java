package com.zycus.threads.contact;

public class Contact {
	private String firstName;
	private String lastName;
	private int age;
	private long phone;
	private String email;

	public Contact(String firstName, String lastName, int age, long phone, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return firstName + ", " + lastName + ", " + age + ", " + phone + ", " + email + "\n";
	}

}
